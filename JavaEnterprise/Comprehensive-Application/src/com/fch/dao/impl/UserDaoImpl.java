package com.fch.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.User;
import com.fch.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @packageName com.fch.dao.impl
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/6 15:05
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    /**
     * queryRunner工具类
     * conn 数据库连接对象
     */
    QueryRunner queryRunner = null;
    Connection conn = null;
    public static final Logger log = Logger.getLogger(UserDaoImpl.class.getName());

    /**
     * 使用德鲁伊资源文件与数据库建立连接
     * 调用无参构造的同时实例化了queryRunner工具类
     */
    public UserDaoImpl() {
        // 通过反射获取类加载器将德鲁伊资源文件读入流中、
        InputStream inputStream = UserDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");

        // 实例化资源文件对象
        Properties properties = new Properties();
        try {
            // 从流中获取资源信息
            properties.load(inputStream);
            // 通过德鲁伊数据源工厂创建数据源
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            // 调用有参狗仔实例化queryRunner，将数据源注入到queryRunner对象
            queryRunner = new QueryRunner(dataSource);
            // 通过数据源获取连接
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录功能接口实现
     *
     * @param userId   用户id
     * @param password 用户密码
     * @return 登录对象
     */
    @Override
    public User userLoad(String userId, String password) {
        // 0.声明一个 user 引用，用于存储登录对象
        User user = null;

        // 1.编写查询 sql
        String sql = String.format("select uid, username from user where uid = %S and password = %s", userId, password);
        log.info("查询登录sql：" + sql);

        // 2.执行sql
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3.响应数据
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * @param currentPage  当前页码
     * @param everyPageRow 每页显示条数
     * @return Page<Map < String, Object>> 将获取的商品信息存入页面对象中
     */
    @Override
    public Page<Map<String, Object>> getPage(int currentPage, int everyPageRow) {
        // 0.声明一个集合用于接收查询到的商品信息
        Page<Map<String, Object>> page = new Page<>();

        // 1.初始化页面信息 当前页码，每页显示条数，总页数，页面数据
        page.setCurrentPage(currentPage);
        page.setEveryPageRow(everyPageRow);
        page.setPageSize(getPageSize(everyPageRow));
        page.setData(getPageDate(currentPage, everyPageRow));

        return page;
    }

    /**
     * @param pid   商品id
     * @param pname 商品名称
     * @return 返回一个商品信息集合包含商品类别
     */
    @Override
    public List<Map<String, Object>> selectProductMess(String pid, String pname) {
        // 0.声明一个集合用于存储查询到商品信息
        List<Map<String, Object>> proMess = null;

        // 1.编写查询商品信息的sql 分两种情况
        // a.只通过pid查询
        if (pid != null && !"".equals(pid)) {
            String sql1 = String.format("select * from (select pid, pname, cname from product left join category on product.cid = category.cid) as ppc  where pid = %s", pid);
            log.info("通过pid查询商品信息sql" + sql1);
            try {
                proMess = queryRunner.query(sql1, new MapListHandler());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return proMess;
        } else if (pname != null && !"".equals(pname) && "".equals(pid)) {
            String sql2 = "select * from (select pid, pname, cname from product left join category on product.cid = category.cid) as ppc  where  pname like '%" + pname + "%'";
            try {
                proMess = queryRunner.query(sql2, new MapListHandler());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return proMess;
        } else {
            return null;
        }
        // b.通过pid和pname查询
    }

    public int getPageSize(int everyPageRow) {
        // a.查询商品总个数sql
        String sql = "select count(*) from product";
        // b.执行sql  获取总记录数
        long count = 0;
        try {
            count = (long) queryRunner.query(sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // c.获取总页数
        long pageSize = (long) Math.ceil((double) count / everyPageRow);
        log.info("总页数：" + pageSize);
        return (int) pageSize;
    }

    public List<Map<String, Object>> getPageDate(int currentPage, int everyPageRow) {
        // 查询商品和类别信息
        String sql = String.format("select pid, pname, cname from product left join category on product.cid = category.cid limit %s, %s", (currentPage - 1) * everyPageRow, everyPageRow);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            list = queryRunner.query(sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据商品id删除商品条目
     *
     * @param pid 商品id
     * @return true: 删除成功 false: 删除失败
     */
    @Override
    public boolean deleteProductByPid(String pid) {
        // 0.编写删除商品sql
        String sql = String.format("delete from product where pid = %s", pid);

        // 1.执行sql
        int result = 0;
        try {
            result = queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 2.根据结果响应信息
        return result != 0;
    }

    /**
     * 根据商品id删除商品条目
     *
     * @param allPid 商品id
     * @return true: 删除成功 false: 删除失败
     */
    @Override
    public boolean deleteAllProductById(String allPid) {
        boolean flag = false;
        // sql
        String sql = String.format("delete from product where pid in ( %s )", allPid);
        System.out.println("批量删除sql" + sql);
        //
        int update = 0;
        try {
            update = queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库更新结果" + update);
        return (update > 0);
    }

    /**
     * 根据 pid 展示商品信息
     *
     * @param pid 商品pid
     * @return 返回是否成功展示
     */
    @Override
    public Product showCheckedMess(String pid) {
        // 0.声明一个Product引用变量
        Product product = null;

        // 1.编写 showCheckMess 的sql
        String sql = String.format("select pid, pimage, market_price from product where pid = %s", pid);
        System.out.println("展示勾选的商品信息sql：" + sql);

        // 2.执行sql
        try {
            product = queryRunner.query(sql, new BeanHandler<>(Product.class));
            System.out.println("需要展示的商品信息:" + product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 2.响应信息
        return product;
    }

    @Override
    public boolean addProducts(Product product) {
        // 0.编写 addProduct 的 sql
        String sql = String.format("insert into product (pid, pname, pimage, cid) values ('%s', '%s', '%s', '%s')", product.getPid(), product.getPname(), product.getPimage(),product.getCid());
        System.out.println(sql);
        // 1.执行sql
        int update = 0;
        try {
            update = queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 2.响应结果
        return update > 0;
    }

    @Override
    public List<Category> getCategory() {
        // 0.编写查询所有类别
        String sql = "select * from category";

        // 1.执行sql
        Category category = null;
        List<Category> categories = null;
        try {
            categories = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
