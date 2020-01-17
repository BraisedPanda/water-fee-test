package com.braisedpanda.waterfee.service;

import com.braisedpanda.waterfee.model.po.StepWater;

import java.util.List;

public interface StepWaterService {
    List<StepWater> selectAll(Integer userId);
}
