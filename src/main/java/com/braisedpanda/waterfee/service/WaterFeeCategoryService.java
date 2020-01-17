package com.braisedpanda.waterfee.service;

import com.braisedpanda.waterfee.model.dto.WaterFeeCategoryDto;


import java.util.List;

public interface WaterFeeCategoryService {
    List<WaterFeeCategoryDto> selectByFactory(int factoryId);
}
