package com.fch.utils;

import java.util.Random;

/**
 * @packageName com.fch.utils
 * @ClassName ValidateCodeUtil
 * @Description 随机验证码
 * @Author Fan-CUNH
 * @Date 2023/7/15 14:14
 * @Version 1.0
 */
public class ValidateCodeUtil {
    /**
     * 随机生成4或6位的验证码
     *
     * @param length 随机生成的验证码长度
     * @return 返回4 or 6位的纯数组验证码
     */
    public static Integer generateValidateCode4Number(Integer length) {
        int code;
        if (length == 4) {
            code = new Random().nextInt(1000) + 9000;
        } else if (length == 6) {
            code = new Random().nextInt(100000) + 900000;
        } else {
            throw new RuntimeException("只能生成4位或6位的数组验证码");
        }
        return code;
    }

    /**
     * 随机生成指定长度字符串验证码
     *
     * @param length 随机生成的验证码长度
     * @return 返回字符串验证码
     */
    public static String generateValidateCode4String(Integer length) {
        Random random = new Random();
        String hash1 = Integer.toHexString(random.nextInt());
        return hash1.substring(0, length);
    }
}
