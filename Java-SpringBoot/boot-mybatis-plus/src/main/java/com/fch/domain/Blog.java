package com.fch.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @packageName com.fch.domain
 * @ClassName Blog
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 10:28
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "blog")
public class Blog {
    @TableId(value = "id", type = IdType.AUTO) // 主键自增
    private Integer id;
    private String title;
    private String content;

    // 逻辑删除（0 正常 1 已删除）
    @TableLogic
    private Integer deleted;

    // 新增自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 插入和更新时自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 乐观锁版本号
    @TableField(fill = FieldFill.INSERT)
    @Version
    private Integer version;
}
