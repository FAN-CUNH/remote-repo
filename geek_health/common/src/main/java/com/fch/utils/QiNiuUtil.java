package com.fch.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

/**
 * @packageName com.fch.utils
 * @ClassName QiNiuUtil
 * @Description 七牛云工具类
 * @Author Fan-CUNH
 * @Date 2023/7/11 14:52
 * @Version 1.0
 */
public class QiNiuUtil {
    /**
     * AK/SK 公钥、私钥
     */
    private static final String ACCESS_KEY = "nQxkFee_ABOa3ub4zJdJP9QMg1fgk1643C3HLXN0";
    private static final String SECRET_KEY = "f4dTdw_3Kak7xO21xCimp_o-M7QJbJKKDR0tNMl_";

    /**
     * 存储空间名称
     */
    private static final String BUCKET = "ssm-geek-health";

    /**
     * 自定义域名，即上传的文件访问路径
     */
    private static final String BUCKET_HOST_NAME = "http://rxmbmvfs1.hd-bkt.clouddn.com";

    /**
     * 获取token
     *
     * @param bucketName 七牛云的存储空间名称
     * @return 返回一个上传文件的token
     */
    public static String token(String bucketName) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        return auth.uploadToken(bucketName);
    }

    /**
     * 获取默认存储空间token
     *
     * @return 返回一个上传文件的token
     */
    public static String token() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        return auth.uploadToken(BUCKET);
    }

    /**
     * 获取存储区域
     *
     * @param zoneName 区域代码 默认/0 -> 华东, 1 -> 华北, 2 -> 华东
     * @return 返回地区
     */
    public static Zone getZone(Integer zoneName) {
        // 默认华东
        Zone zone = Zone.zone0();
        if (null == zoneName || zoneName == 0) {
            return zone;
        }

        // 华北
        if (zoneName == 1) {
            zone = Zone.zone1();
        }

        // 华南
        if (zoneName == 2) {
            zone = Zone.zone2();
        }

        return zone;
    }

    /**
     * 上传文件
     *
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return 上传成功后，返回文件在七牛云中的外链地址
     */
    public static String uploadForQiNiu(String filePath, String fileName) {
        // 构造一个带有执行Zone对象的配置类（华东地区）
        Configuration configuration = new Configuration(Zone.zone0());

        // 创建一个上传对象
        UploadManager uploadManager = new UploadManager(configuration);

        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            // 上传
            Response response = uploadManager.put(filePath, fileName, token());
            // 解析上传成功的结果
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return defaultPutRet.key;
        } catch (QiniuException e) {
            Response response = e.response;
            System.out.println(fileName + "----文件上传失败----" + response.toString());
            try {
                System.err.println(response.bodyString());
                System.out.println(fileName + "----文件上传失败----" + response);
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 通过字节流的形式上传文件
     *
     * @param bytes 字节数组
     * @param fileName 文件名称
     * @return 上传成功后，返回文件在七牛云中外链地址
     */
    public static String uploadForQiNiu(byte[] bytes, String fileName) {
        // 构造一个带有执行Zone对象的配置类（华东地区）
        Configuration configuration = new Configuration(Zone.zone0());

        // 创建一个上传对象
        UploadManager uploadManager = new UploadManager(configuration);

        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            // 上传
            Response response = uploadManager.put(bytes, fileName, token());
            // 解析上传成功的结果
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return defaultPutRet.key;
        } catch (QiniuException e) {
            Response response = e.response;
            System.out.println(fileName + "----文件上传失败----" + response.toString());
            try {
                System.err.println(response.bodyString());
                System.out.println(fileName + "----文件上传失败----" + response);
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 通过输入流的形式上传文件
     *
     * @param inputStream 输入流
     * @param fileName 文件名称
     * @return 上传成功后，返回文件在七牛云中外链地址
     */
    public static String uploadForQiNiu(InputStream inputStream, String fileName) {
        // 构造一个带有执行Zone对象的配置类（华东地区）
        Configuration configuration = new Configuration(Zone.zone0());

        // 创建一个上传对象
        UploadManager uploadManager = new UploadManager(configuration);

        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            try {
                // 上传
                Response response = uploadManager.put(inputStream, fileName, token(), null, null);
                // 解析上传成功的结果
                DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return defaultPutRet.key;
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过fileName删除云端文件
     *
     * @param fileName 文件名称
     * @return 删除状态
     */
    public static boolean deleteFromQiNiu(String fileName) {
        // 构造一个带有执行Zone对象的配置类（华东地区）
        Configuration configuration = new Configuration(Zone.zone0());

        // 鉴权
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth, configuration);

        // 删除
        if (fileName != null) {
            try {
                Response response = bucketManager.delete(BUCKET, fileName);
                if (response.statusCode == 200) {
                    return true;
                }
            } catch (QiniuException e) {
                //如果遇到异常，说明删除失败
                System.out.println(fileName + "----删除失败----" + e.code());
            }
        }
        return false;
    }
}
