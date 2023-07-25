package com.fch.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.Objects;

/**
 * @packageName com.fch.utils
 * @ClassName LuaUtil
 * @Description 加载Lua秒杀脚本工具
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:41
 * @Version 1.0
 */
public class LuaUtil {
    /**
     * @param jedisPool jedis连接池
     * @param luaName lua脚本名称
     * @param count 参数个数
     * @param params 参数
     * @param <T> 泛型
     * @return 返回lua脚本
     */
    public static <T> T loadScript(JedisPool jedisPool, String luaName, Integer count, String... params) {
        // 加载脚本
        String luaPath = Objects.requireNonNull(LuaUtil.class.getResource("/")).getPath() + luaName;
        System.out.println("luaPath = " + luaPath);

        // 通过IO流读取脚本，转换成字符串
        BufferedReader bufferedReader = null;
        Jedis jedis;
        T o = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(luaPath)));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

            // 获取 jedis 对象
            jedis = jedisPool.getResource();
            // 转成sha脚本
            String sha = jedis.scriptLoad(stringBuilder.toString());
            o  = (T) jedis.evalsha(sha, count, params);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("o = " + o);
        return o;
    }
}
