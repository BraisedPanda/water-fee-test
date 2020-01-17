package com.braisedpanda.waterfee.service.impl;

import com.braisedpanda.waterfee.mapper.FeeMapper;
import com.braisedpanda.waterfee.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 10:16
 **/
@Service
public class FeeServiceImpl implements FeeService{

    @Autowired
    private FeeMapper feeMapper;
}
