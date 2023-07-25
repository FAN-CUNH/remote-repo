package com.fch.test;

import org.json.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @packageName com.fch.test
 * @ClassName JedisTransactionTest
 * @Description Redis 事务处理
 * @Author Fan-CUNH
 * @Date 2023/7/22 17:51
 * @Version 1.0
 */
public class JedisTransactionTest {
    @Test
    public void testJedisTransaction() {
        // 创建 jedis 对象
        Jedis jedis = new Jedis("localhost", 6379);
        // 权限认证
        jedis.auth("fch981112");

        // 选择第二个redis数据库
        jedis.select(1);

        // 清空数据库
        jedis.flushDB();

        // 测试连接
        System.out.println("jedis.ping() => " + jedis.ping());

        // 创建json对象
        JSONObject object = new JSONObject();
        object.put("name", "zs");
        object.put("age", 18);
        String string = object.toString();
        System.out.println("string = " + string);

        // 开启事务
        Transaction multi = jedis.multi();

        try {
            // 命令入队
            multi.set("user1", string);
            // int i = 10 / 0;
            multi.set("user2", string);

            // 执行事务
            multi.exec();
        } catch (Exception e) {
            // 放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println("jedis.get(\"user1\") = " + jedis.get("user1"));
            System.out.println("jedis.get(\"user2\") = " + jedis.get("user2"));

            // 关闭连接
            jedis.close();
        }
    }
}
