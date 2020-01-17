package com.braisedpanda.waterfee.service.impl;

import com.braisedpanda.waterfee.mapper.StepWaterMapper;
import com.braisedpanda.waterfee.model.po.StepWater;
import com.braisedpanda.waterfee.service.StepWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 10:17
 **/
@Service
public class StepWaterServiceImpl implements StepWaterService{

    @Autowired
    private StepWaterMapper stepWaterMapper;

    @Override
    public List<StepWater> selectAll(Integer userId) {
        return stepWaterMapper.selectAll(userId);
    }
}
