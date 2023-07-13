package com.fch.constant;

import lombok.Data;

/**
 * @packageName com.fch.constant
 * @ClassName RedisConstant
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/12 16:43
 * @Version 1.0
 */

public class RedisConstant {
    // 云端存储的套餐图片名称  redis数据库中的KEY名 用于表示所有上传至OSS中的图片
    public static final String SETMEAL_PIC_RESOURCES = "setmealPicResources";

    // 云端存储的套餐图片名称  redis数据库中的KEY名 用于表示所有上传至OSS中的图片
    public static final String SETMEAL_PIC_DB_RESOURCES = "setmealPicDbResources";
}
