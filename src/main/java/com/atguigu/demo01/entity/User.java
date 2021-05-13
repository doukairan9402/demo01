package com.atguigu.demo01.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String mname;
    private Integer age;
    private String email;
    // 命名  在库里 对应  create_time
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(updateStrategy = FieldStrategy.IGNORED,fill = FieldFill.INSERT)
    private Integer version;

}
