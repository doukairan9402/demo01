package com.atguigu.demo01.entity;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class UserObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐)
        this.strictInsertFill(metaObject,"createTime", Date.class, new Date());
        this.strictInsertFill(metaObject,"updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject,"version", Integer.class, 1);
//        this.setFieldValByName("createTime",new Date(),metaObject);
//        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

//        this.setFieldValByName("updateTime",new Date(),metaObject);
        if (this.getFieldValByName("updateTime",metaObject) != null){
            metaObject.setValue("updateTime",null);
            /*起始版本 3.3.0(推荐)  使用该方法，获取回来的字段值 不是 null 的时候，无法更新，需要先手动
            把值设置为null*/
            this.strictUpdateFill(metaObject,"updateTime", Date.class, new Date());
        }else{
            this.strictUpdateFill(metaObject,"updateTime", Date.class, new Date());
        }

    }
}
