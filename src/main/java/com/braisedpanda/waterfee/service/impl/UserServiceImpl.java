package com.braisedpanda.waterfee.service.impl;

import com.braisedpanda.waterfee.mapper.UserMapper;
import com.braisedpanda.waterfee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 10:17
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
}
