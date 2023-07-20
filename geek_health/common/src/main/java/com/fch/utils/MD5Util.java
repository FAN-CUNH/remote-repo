package com.fch.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @packageName com.fch.utils
 * @ClassName MD5Util
 * @Description 使用MD5的算法对密码进行加密
 * @Author Fan-CUNH
 * @Date 2023/7/18 14:46
 * @Version 1.0
 */
public class MD5Util {
    /**
     * 密码加密
     *
     * @param plainText 需要加密的内容
     * @return 返回加密后的字符串
     */
    public static String md5(String plainText) {
        byte[] secretBytes;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有MD5这个算法!");
        }
        StringBuilder md5Code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));

        // 不满32位 补0
        for (int i = 0; i < 32 - md5Code.length(); i++) {
            md5Code.insert(0, "0");
        }

        return md5Code.toString();
    }
}
