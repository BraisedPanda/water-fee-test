package com.braisedpanda.waterfee.service.impl;

import com.braisedpanda.waterfee.mapper.WaterFeeCategoryMapper;
import com.braisedpanda.waterfee.model.dto.WaterFeeCategoryDto;

import com.braisedpanda.waterfee.service.WaterFeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 15:07
 **/
@Service
public class WaterFeeCategoryImpl implements WaterFeeCategoryService{

    @Autowired
    private WaterFeeCategoryMapper waterFeeCategoryMapper;

    @Override
    public List<WaterFeeCategoryDto> selectByFactory(int factoryId) {

        return waterFeeCategoryMapper.selectByFactory(factoryId);
    }
}
