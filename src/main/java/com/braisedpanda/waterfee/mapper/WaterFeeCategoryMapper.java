package com.braisedpanda.waterfee.mapper;

import com.braisedpanda.waterfee.model.dto.WaterFeeCategoryDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WaterFeeCategoryMapper {

    List<WaterFeeCategoryDto> selectByFactory(int factoryId);
}
