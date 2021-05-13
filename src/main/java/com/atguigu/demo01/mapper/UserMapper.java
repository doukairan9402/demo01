package com.atguigu.demo01.mapper;

import com.atguigu.demo01.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper extends BaseMapper<User> {
}
