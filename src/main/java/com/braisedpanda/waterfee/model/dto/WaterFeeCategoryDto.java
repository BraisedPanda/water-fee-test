package com.braisedpanda.waterfee.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 14:57
 **/
@Data

public class WaterFeeCategoryDto {

    private Integer level;

    private double waterFee;

    private double ziFee;

    private double sewageTreatmentFee;

    private Integer endNumber;


}
