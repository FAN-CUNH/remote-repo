package com.fch.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.ListPosition;

import java.util.HashMap;
import java.util.Map;

/**
 * @packageName com.fch.test
 * @ClassName JedisTest
 * @Description 测试Redis
 * @Author Fan-CUNH
 * @Date 2023/7/22 14:27
 * @Version 1.0
 */
public class JedisTest {
    /**
     * 测试 连接客户端 此时需要开启本地Redis的服务器
     */
    @Test
    public void testPing() {
        // 创建jedis对象
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            // 权限认证
            jedis.auth("fch981112");

            // 调用 ping 方法，输入PONG,表示连接成功
            System.out.println(jedis.ping());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Redis五大数据类型之String
     * 1:增 set ,mset(批量增加), setnx(set with no exist 不存在该键值对再增加) , setex(set with expire 新增键值对并设置销毁时间（秒级）)
     * 2:删 del
     * 3:改 set , append
     * 4:查 get ,mget(批量查询), getset(获取旧值，并设置新值)
     */
    @Test
    public void testString() {
        Jedis jedis = getJedis();

        System.out.println("--------------------------- 增 分割线 ----------------------------------");
        // 增 + 查
        // set
        System.out.println("jedis.set(\"k1\", \"v1\") => " + jedis.set("k1", "v1"));
        System.out.println("jedis.set(\"k2\", \"v2\") => " + jedis.set("k2", "v2"));
        System.out.println("jedis.set(\"k3\", \"v3\") => " + jedis.set("k3", "v3"));
        System.out.println("jedis.get(\"k1\") = " + jedis.get("k1"));
        System.out.println("jedis.get(\"k1\") = " + jedis.get("k2"));
        System.out.println("jedis.get(\"k1\") = " + jedis.get("k3"));
        // mset + mget
        System.out.println("jedis.mset(\"k11\", \"v11\", \"k22\", \"v22\", \"k33\", \"v33\") => " + jedis.mset("k11", "v11", "k22", "v22", "k33", "v33"));
        System.out.println("jedis.mget(\"k11\", \"k22\", \"k33\") = " + jedis.mget("k11", "k22", "k33"));
        // setnx
        System.out.println("jedis.setnx(\"k2\", \"v22\") => " + jedis.setnx("k2", "v22"));
        System.out.println("jedis.setnx(\"k2\", \"v22\") => " + jedis.setnx("k4", "v4"));
        System.out.println("jedis.get(\"k2\") = " + jedis.get("k2"));
        System.out.println("jedis.get(\"k2\") = " + jedis.get("k4"));
        // setex
        System.out.println("jedis.setex(\"k5\", 2, \"v5\") => " + jedis.setex("k5", 2, "v5"));
        System.out.println("jedis.get(\"k5\") = " + jedis.get("k5"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("jedis.get(\"k5\") = " + jedis.get("k5"));

        System.out.println("--------------------------- 删 分割线 ----------------------------------");
        // 删 + 查
        System.out.println("jedis.del(\"k2\") => " + jedis.del("k2"));
        System.out.println("jedis.get(\"k2\") = " + jedis.get("k2"));

        System.out.println("--------------------------- 改 分割线 ----------------------------------");
        // 改 + 查
        // set
        System.out.println("jedis.set(\"k5\", \"v5\") => " + jedis.set("k5", "v5"));
        System.out.println("jedis.get(\"k5\") = " + jedis.get("k5"));
        // append
        System.out.println("jedis.append(\"k5\", \"v5v5v5v5\") => " + jedis.append("k5", "v5v5v5v5"));
        System.out.println("jedis.get(\"k5\") = " + jedis.get("k5"));

        // 查 getset
        System.out.println("jedis.getSet(\"k5\", \"v5\") = " + jedis.getSet("k5", "v5"));
        System.out.println("jedis.get(\"k5\") = " + jedis.get("k5"));
    }

    private static Jedis getJedis() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("fch981112");
        // 选择第二个数据库
        jedis.select(1);
        // 调用清空当前数据库命令
        jedis.flushDB();
        return jedis;
    }

    /**
     * Redis五大数据类型之List
     * 1:增 lpush(left push 头插) rpush(right push尾插) linsert(list insert 任意键的前后插入)
     * 2:删 lpop(left pop 左弹) rpop(右弹) lrem(移除指定下标对应的值)
     * 3:改 lset(更新指定下标对应的值)
     * 4:查 lrange(查元素) llen(查数组长度) lindex(指定下标对应的元素)
     * 5:截取 ltrim(截取指定区间的元素)
     */
    @Test
    public void testList() {
        Jedis jedis = getJedis();
        System.out.println("--------------------------- 增 + 查 分割线 ----------------------------------");
        // lpush + rpush + lrange + llen + lindex
        System.out.println("jedis.lpush(\"list\", \"1\", \"2\", \"3\") = " + jedis.lpush("list", "1", "2", "3"));
        System.out.println("jedis.lrange(\"list\", 0, -1) = " + jedis.lrange("list", 0, -1));
        System.out.println("jedis.rpush(\"list\", \"x\", \"y\", \"z\") = " + jedis.rpush("list", "x", "y", "z"));
        System.out.println("jedis.lrange(\"list\", 0, -1) = " + jedis.lrange("list", 0, -1));
        System.out.println("jedis.llen(\"list\") = " + jedis.llen("list"));
        System.out.println("jedis.linsert(\"list\", after, 1, \"!\") = " + jedis.linsert("list", ListPosition.AFTER, "1", "!"));
        System.out.println("jedis.lrange(\"list\", 0, -1) = " + jedis.lrange("list", 0, -1));
        System.out.println("jedis.lindex(\"list\", 3) = " + jedis.lindex("list", 3));

        System.out.println("--------------------------- 删 分割线 ----------------------------------");
        System.out.println("jedis.lpop(\"list\") = " + jedis.lpop("list"));
        System.out.println("jedis.rpop(\"list\") = " + jedis.rpop("list"));
        System.out.println("jedis.lrem(\"list\", 1, \"!\") = " + jedis.lrem("list", 1, "!"));
        System.out.println("jedis.lrange(\"list\", 0 ,-1) = " + jedis.lrange("list", 0, -1));

        System.out.println("--------------------------- 改 分割线 ----------------------------------");
        System.out.println("jedis.lset(\"list\", 2, \"X\") = " + jedis.lset("list", 2, "X"));
        System.out.println("jedis.lrange(\"list\", 0, -1) = " + jedis.lrange("list", 0, -1));

        System.out.println("--------------------------- 截取 分割线 ----------------------------------");
        System.out.println("jedis.ltrim(\"list\", 1, 2) = " + jedis.ltrim("list", 1, 2));
        System.out.println("jedis.lrange(\"list\", 0, -1) = " + jedis.lrange("list", 0, -1));
    }

    /**
     * Redis五大数据类型之Set
     * 1:增 sadd
     * 2:删 srem(删除指定元素) spop(随机删除)
     * 3:改 不能改元素，无序集合
     * 4:查 smembers, sismember, scard(查个数)
     * 5:移动 smove
     * 6:交 sinter
     * 7:并 sunion
     * 8:差 sdiff
     */
    @Test
    public void testSet() {
        Jedis jedis = getJedis();
        System.out.println("--------------------------- 增 + 查 分割线 ----------------------------------");
        System.out.println("jedis.sadd(\"set\", \"1\", \"1\", \"2\", \"2\", \"3\", \"4\", \"5\") = " + jedis.sadd("set", "1", "1", "2", "2", "3", "4", "5"));
        System.out.println("jedis.smembers(\"set\") = " + jedis.smembers("set"));
        System.out.println("jedis.sismember(\"set\", \"1\") = " + jedis.sismember("set", "1"));
        System.out.println("jedis.sismember(\"set\", \"11\") = " + jedis.sismember("set", "11"));
        System.out.println("jedis.scard(\"set\") = " + jedis.scard("set"));

        System.out.println("--------------------------- 删 分割线 ----------------------------------");
        System.out.println("jedis.srem(\"set\", \"1\") = " + jedis.srem("set", "1"));
        System.out.println("jedis.spop(\"set\") = " + jedis.spop("set"));
        System.out.println("jedis.smembers(\"set\") = " + jedis.smembers("set"));

        System.out.println("--------------------------- 移动 分割线 ----------------------------------");
        System.out.println("jedis.smove(\"set\", \"set1\", \"5\") = " + jedis.smove("set", "set1", "5"));
        System.out.println("jedis.smembers(\"set\") = " + jedis.smembers("set"));
        System.out.println("jedis.smembers(\"set1\") = " + jedis.smembers("set1"));

        System.out.println("--------------------------- 交 分割线 ----------------------------------");
        System.out.println("jedis.sadd(\"set1\", \"1\", \"2\", \"3\") = " + jedis.sadd("set1", "1", "2", "3"));
        System.out.println("jedis.smembers(\"set\") = " + jedis.smembers("set"));
        System.out.println("jedis.smembers(\"set1\") = " + jedis.smembers("set1"));
        System.out.println("jedis.sinter(\"set\", \"set1\") = " + jedis.sinter("set", "set1"));

        System.out.println("--------------------------- 并 分割线 ----------------------------------");
        System.out.println("jedis.sunion(\"set\", \"set1\") = " + jedis.sunion("set", "set1"));

        System.out.println("--------------------------- 差 分割线 ----------------------------------");
        System.out.println("jedis.sdiff(\"set\", \"set1\") = " + jedis.sdiff("set", "set1"));
    }

    /**
     * Redis五大数据类型之Hash
     * 1:增 hset hmset  hincrBy(指定键的值增加， 存在增加，否则新增)
     * 2:删 hdel
     * 3:改 hset
     * 4:查 hget hmget hgetall hkeys hvals hlen hexists
     */
    @Test
    public void testHash() {
        Jedis jedis = getJedis();

        System.out.println("--------------------------- 增 + 查 分割线 ----------------------------------");
        // hset + hget 单个添加 单个查询
        System.out.println("jedis.hset(\"hash\", \"name\", \"zs\") = " + jedis.hset("hash", "name", "zs"));
        System.out.println("jedis.hget(\"hash\", \"name\") = " + jedis.hget("hash", "name"));

        Map<String, String> map = new HashMap<>(16);
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        // hmset + hmget 批量增加/查询
        System.out.println("jedis.hmset(\"hash\", map) = " + jedis.hmset("hash", map));
        // hkeys 获取所有的键
        System.out.println("jedis.hkeys(\"hash\") = " + jedis.hkeys("hash"));
        // hvals 获取所有的值
        System.out.println("jedis.hvals(\"hash\") = " + jedis.hvals("hash"));
        System.out.println("jedis.hget(\"hash\", \"k1\") = " + jedis.hget("hash", "k1"));
        System.out.println("jedis.hget(\"hash\", \"k2\") = " + jedis.hget("hash", "k2"));
        System.out.println("jedis.hincrBy(\"hash\", \"k5\", 100) = " + jedis.hincrBy("hash", "k5", 100));
        // hgetAll 获取hash的所有键值对
        System.out.println("jedis.hgetAll(\"hash\") = " + jedis.hgetAll("hash"));
        // hlen hash中键值对的个数
        System.out.println("jedis.hlen(\"hash\") = " + jedis.hlen("hash"));
        // hexists 判断指定的键是否存在
        System.out.println("jedis.hexists(\"hash\", \"k5\") = " + jedis.hexists("hash", "k5"));
        System.out.println("jedis.hexists(\"hash\", \"k6\") = " + jedis.hexists("hash", "k6"));

        System.out.println("--------------------------- 删 分割线 ----------------------------------");
        System.out.println("jedis.hdel(\"hash\", \"name\") = " + jedis.hdel("hash", "name"));
        System.out.println("jedis.hgetAll(\"hash\") = " + jedis.hgetAll("hash"));
    }

    /**
     * Redis五大数据类型之Hash
     * 1:增 zadd
     * 2:删 zrem
     * 3:改
     * 4:查 zrange(集合中的所有元素) zrangeWithScores(键值对) zrangeByScore(按照score字段值排序) zrevrangeByScore(按照score字段值逆序)
     * zcard(有序集合中元素的个数) zcount(获取集合中指定区间的元素个数)
     */
    @Test
    public void testZset() {
        Jedis jedis = getJedis();
        System.out.println("--------------------------- 增 + 查 分割线 ----------------------------------");
        System.out.println("jedis.zadd(\"zset\", 1, \"1\") = " + jedis.zadd("zset", 1, "1"));
        System.out.println("jedis.zadd(\"zset\", 2, \"1\") = " + jedis.zadd("zset", 2, "1"));
        System.out.println("jedis.zadd(\"zset\", 3, \"2\") = " + jedis.zadd("zset", 3, "2"));
        System.out.println("jedis.zrange(\"zset\", 0, -1) = " + jedis.zrange("zset", 0, -1));
        System.out.println("jedis.zrangeWithScores(\"zset\", 0, -1) = " + jedis.zrangeWithScores("zset", 0, -1));
        jedis.zadd("zset", 2, "5");
        jedis.zadd("zset", 4, "8");
        jedis.zadd("zset", 5, "7");
        System.out.println("jedis.zrangeByScore(\"zset\", 1, 5) = " + jedis.zrangeByScore("zset", 1, 5));
        System.out.println("jedis.zrevrangeByScore(\"zset\", 5, 1) = " + jedis.zrevrangeByScore("zset", 5, 1));
        System.out.println("jedis.zcard(\"zset\") = " + jedis.zcard("zset"));
        System.out.println("jedis.zrange(\"zset\", 0, -1) = " + jedis.zrange("zset", 0, -1));
        System.out.println("jedis.zcount(\"zset\", 3, 5) = " + jedis.zcount("zset", 3, 5));

        System.out.println("--------------------------- 删 分割线 ----------------------------------");
        System.out.println("jedis.zrem(\"zset\", \"7\", \"8\") = " + jedis.zrem("zset", "7", "8"));
        System.out.println("jedis.zrange(\"zset\", 0, -1) = " + jedis.zrange("zset", 0, -1));

    }
}
