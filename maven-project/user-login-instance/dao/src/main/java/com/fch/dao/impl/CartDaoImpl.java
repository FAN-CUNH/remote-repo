package com.fch.dao.impl;

import com.fch.BaseUtil;
import com.fch.bean.*;
import com.fch.dao.CartDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @packageName com.fch.dao
 * @ClassName CartDaoImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/15 10:45
 * @Version 1.0
 */
public class CartDaoImpl implements CartDao {
    QueryRunner queryRunner;
    Connection conn;

    public CartDaoImpl() {
        queryRunner = new QueryRunner();
        conn = BaseUtil.dateBaseUtil();
    }

    @Override
    public Page<Product> queryProduct(String pname, String queryId, int currentPage, int pageSize) {
        //0. 编写条件模糊查询sql
        //String sql = String.format("select * from product where pname like '%s%s%s' limit %s, %s", "%", pname, "%", ((currentPage - 1) * pageSize), pageSize);
        StringBuffer sql = new StringBuffer("select * from product where pname like '%" + pname + "%'");
        if ("0".equals(queryId)) {
            sql.append(" order by shop_price asc ");
        } else if ("1".equals(queryId)) {
            sql.append(" order by shop_price desc ");
        } else if ("2".equals(queryId)) {
            sql.append(" order by market_price asc ");
        } else if ("3".equals(queryId)) {
            sql.append(" order by market_price desc ");
        } else if ("4".equals(queryId)) {
            sql.append(" order by is_hot asc");
        } else if ("5".equals(queryId)) {
            sql.append(" order by is_hot desc");
        }
        String sql1 = sql.toString().replace("*", "count(0)");
        sql.append(" limit ").append((currentPage - 1) * pageSize).append(",").append(pageSize);
        System.out.println("模糊查询sql = " + sql);

        //1. 执行sql
        List<Product> products;
        long total = 0;
        try {
            total = (long) queryRunner.query(conn, sql1, new ScalarHandler());
            products = queryRunner.query(conn, sql.toString(), new BeanListHandler<>(Product.class));
            System.out.println("products = " + products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2. 响应数据
        return new Page<>(currentPage, pageSize, (int) total, products);
    }

    /**
     * 加购
     * 同一个人的相同商品公用一个购物项编号，即先买一件后再次购买一件，只需数量加
     * 思路：
     * 1. 获取到商品必须参数和用户id
     * 2. 通过用户id判断该用户是否存在购物车
     * 3. 若存在购物车，则根据用户id找到该用户的购物车id，再通过pid查找该购物车中是否存在该商品，存在该商品则使其数量+count，小计+subTotal,购物车金额+subTotal
     * 4. 若不存在购物车，则新建购物车，添加该购物项，修改购物车金额为subTotal
     *
     * @param userId     用户id
     * @param pid        商品id
     * @param pname      商品名
     * @param pimage     商品图片
     * @param shop_price 商场价
     * @param count      购买商品数量
     * @param subTotal   商品金额小计
     * @return 返回是否添加商品到购物车的boolean值
     */
    @Override
    public boolean addProductToCart(String userId, String pid, String pname, String pimage, double shop_price, int count, double subTotal) {

        // 生成购物项编号
        String cartItemId = String.valueOf(UUID.randomUUID());

        // 判断当前订单项是所有者是否存在购物车
        String sql = String.format("select * from cart where userId = %s", userId);
        System.out.println("查询是否存在购物车sql:" + sql);

        // 执行sql
        Cart cart;
        try {
            cart = queryRunner.query(conn, sql, new BeanHandler<>(Cart.class));
            System.out.println("cart = " + cart);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String cartId;
        double total = 0;
        String sql1;
        String sql2;
        // 当前人存在购物车
        if (cart != null) {
            // 获取购物车id
            cartId = cart.getCartId();

            // 通过购物车id查询购物项表
            String sql4 = String.format("select * from cartitem where cartId = '%s' and pid = %s", cartId, pid);
            Cartitem cartitem;
            try {
                cartitem = queryRunner.query(conn, sql4, new BeanHandler<>(Cartitem.class));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (cartitem != null) {
                // 该商品购买过，更新改商品购物项的参数
                sql1 = String.format("update cartitem " +
                        "set count = (count + %s), " +
                        "subTotal = (subTotal + %s) " +
                        "where cartitemId = '%s'", count, subTotal, cartitem.getCartitemId());
                System.out.println("该商品购买过,更新改商品购物项的参数sql1 = " + sql1);
            } else {
                // 该商品购买过,添加购物项到购物项表
                sql1 = String.format("insert into cartitem" +
                        " values ('%s', '%s', '%s','%s','%s', %s, %s, %s)"
                        , cartItemId, pid, cartId, pname, pimage, shop_price, subTotal, count);
                System.out.println("该商品购买过,添加购物项到购物项表sql1 =" + sql1);
            }

            // 计算购物车总金额 -----> 此处不管该商品是否存在同类都是要把金额更新到购物车表
            total = cart.getTotal() + subTotal;
            // 更新购物车表
            sql2 = String.format("update cart set total = %s where cartId = '%s'", total, cartId);
            System.out.println("更新购物车表sql2:" + sql2);
        }
        // 当前人不存在购物车
        else {
            // 通过UUID生成购物车编号
            cartId = String.valueOf(UUID.randomUUID());

            // 创建购物车
            String sql3 = String.format("insert into cart values ('%s', %s, %s)", cartId, total, userId);
            System.out.println("sql3 = " + sql3);
            try {
                queryRunner.update(conn, sql3);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // 添加购物项到购物项表
            sql1 = String.format("insert into cartitem" +
                    " values ('%s', '%s', '%s','%s','%s', %s, %s, %s)"
                    , cartItemId, pid, cartId, pname, pimage, shop_price, subTotal, count);
            System.out.println("添加购物项" + sql1);

            // 更新购物车表
            sql2 = String.format("update cart set total = %s where cartId = '%s'", subTotal, cartId);
            System.out.println("更新购物车表sql2:" + sql2);
        }


        // 执行sql
        int update;
        int update1;
        try {
            //conn.setAutoCommit(false);
            update = queryRunner.update(conn, sql1);
            update1 = queryRunner.update(conn, sql2);
            //conn.commit();
        } catch (SQLException e) {
            /*try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
            throw new RuntimeException(e);
        }
        return (update1 > 0 && update > 0);
    }

    @Override
    public Cart queryAllCartProduct(String userId) {
        // 查询购物车是否存在
        String sql = String.format("select * from cart where userId = '%s'", userId);
        System.out.println("查询购物车是否存在sql = " + sql);
        Cart cart;
        try {
            cart = queryRunner.query(conn, sql, new BeanHandler<>(Cart.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (cart != null) {
            String cartId = cart.getCartId();
            String sql1 = String.format("select * from cartitem where cartId = '%s'", cartId);
            System.out.println("sql1 = " + sql1);
            List<Cartitem> cartitems;
            try {
                cartitems = queryRunner.query(conn, sql1, new BeanListHandler<>(Cartitem.class));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            cart.setCartitems(cartitems);
        }
        return cart;
    }

    @Override
    public boolean deleteCartitemByCartitemId(String cartId, String cartitemId) {
        // 查询当前购物项
        String sql2 = String.format("select * from cartitem where cartitemId = '%s'", cartitemId);
        Cartitem cartitem;
        try {
            cartitem = queryRunner.query(conn, sql2, new BeanHandler<Cartitem>(Cartitem.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 编写更新购物车金额sql
        Cart cart;
        String sql1 = String.format("select * from cart where cartId = '%s'", cartId);
        try {
            cart = queryRunner.query(conn, sql1, new BeanHandler<>(Cart.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (cart != null) {
            double total = cart.getTotal() - cartitem.getSubTotal();
            System.out.println(total);
            String sql3 = String.format("update cart set total = %s where cartId = '%s'", total, cartId);
            try {
                queryRunner.update(conn, sql3);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        // 编写删除sql
        String sql = String.format("delete from cartitem where cartitemId = '%s'", cartitemId);

        // 执行sql
        int delete;
        try {
            delete = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delete > 0;
    }

    @Override
    public boolean checkout(String userId, String[] cartitemIds) {
        // 根据userid查询用户对象
        User user;
        Cartitem cartitem = null;
        String sql0 = String.format("select * from user where userId = %s", userId);
        try {
            user = queryRunner.query(conn, sql0, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user != null) {
            // UUID生成一个订单编号
            String oid = String.valueOf(UUID.randomUUID());
            double subTotal = 0.0;

            // 生成订单
            java.util.Date date = new Date();//获得当前时间
            Timestamp ordertime = new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
            String sql4 = String.format("insert into orders values ( '%s', '%s', %s, %s, '%s', '%s', '%s', '%s')"
                    , oid, ordertime, subTotal, 0, user.getAddress()
                    , user.getName(), user.getTelephone(), user.getUserId());
            System.out.println("生成订单sql4 = " + sql4);
            try {
                queryRunner.update(conn, sql4);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            for (String cartitemId : cartitemIds) {
                // 编写查询购物项sql
                String sql = String.format("select * from cartitem where cartitemId = '%s'", cartitemId);
                System.out.println("编写查询购物项sql = " + sql);
                try {
                    cartitem = queryRunner.query(conn, sql, new BeanHandler<>(Cartitem.class));
                    System.out.println("cartitem = " + cartitem);

                    subTotal = subTotal + cartitem.getSubTotal();

                    // 初始化订单项
                    Orderitem orderitem = new Orderitem();
                    orderitem.setItemid(String.valueOf(UUID.randomUUID()));
                    orderitem.setPid(cartitem.getPid());
                    orderitem.setCount(cartitem.getCount());
                    orderitem.setOid(oid);
                    orderitem.setSubtotal(cartitem.getSubTotal());
                    System.out.println("orderitem = " + orderitem);

                    // 删除购物项
                    String sql1 = String.format("delete from cartitem " +
                            "where cartitemId = '%s'", cartitem.getCartitemId());
                    System.out.println("sql1 = " + sql1);
                    queryRunner.update(conn, sql1);

                    // 添加订单项
                    String sql2 = String.format("insert into orderitem" +
                            " values ('%s', %s, %s, %s, '%s')"
                            , orderitem.getItemid(), orderitem.getCount(), orderitem.getSubtotal(), cartitem.getPid(), orderitem.getOid());
                    queryRunner.update(conn, sql2);
                    System.out.println("sql2 = " + sql2);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            // 查询当前用户购物车是否被清空，若被清空则删除购物车，否则更新购物车金额
            long cartitemCount;
            if (cartitem != null) {
                String sql6 = String.format("select count(0) from cartitem where cartId = '%s'", cartitem.getCartId());
                try {
                    cartitemCount = (long) queryRunner.query(conn, sql6, new ScalarHandler());
                    if ((int)cartitemCount == 0) {
                        String sql7 = String.format("delete from cart where cartId = '%s'", cartitem.getCartId());
                        queryRunner.update(conn, sql7);
                        System.out.println("购物车已清空，删除购物车sql7 = " + sql7);
                    } else {
                        // 更新购物车金额
                        String sql5 = String.format("update cart set total = (total - %s)", subTotal);
                        queryRunner.update(conn, sql5);
                        System.out.println("更新购物车金额sql5 = " + sql5);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            // 更新订单总金额 subTotal是所有订单项金额的总和
            String sql3 = String.format("update orders set total = (total + %s) where oid = '%s'", subTotal, oid);
            System.out.println("更新订单总金额sql3 = " + sql3);
            int updateOrderTotal;
            try {
                updateOrderTotal = queryRunner.update(conn, sql3);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return (updateOrderTotal > 0);
        } else {
            return false;
        }
    }
}