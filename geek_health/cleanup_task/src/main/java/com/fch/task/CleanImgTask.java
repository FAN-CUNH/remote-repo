package com.fch.task;

import com.fch.constant.RedisConstant;
import com.fch.utils.QiNiuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @packageName com.fch.task
 * @ClassName CleanImgTask
 * @Description 自定义定时任务，实现定时清理七牛云中的垃圾图片
 * @Author Fan-CUNH
 * @Date 2023/7/12 18:51
 * @Version 1.0
 */
@Slf4j
@Component
public class CleanImgTask {
    @Resource
    private JedisPool jedisPool;

    public void cleanImg() {
        log.info("----clean task----");

        // 根据 redis 中保存的两个 set 集合进行差值计算， 获得垃圾图片名称集合
        Set<String> set = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if (set != null) {
            set.forEach(s -> {
                // 删除云端服务器上的图片
                boolean flag = QiNiuUtil.deleteFromQiNiu(s);
                if (flag) {
                    // 删除redis中的图片
                    jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES, s);
                    log.info("自定义执行任务，清理垃圾图片:" + s);
                }
            });
        }
    }
}
