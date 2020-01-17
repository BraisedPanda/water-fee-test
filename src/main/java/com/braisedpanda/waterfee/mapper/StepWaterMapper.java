package com.braisedpanda.waterfee.mapper;


import com.braisedpanda.waterfee.model.po.StepWater;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StepWaterMapper  {
    List<StepWater> selectAll(Integer userId);
}
