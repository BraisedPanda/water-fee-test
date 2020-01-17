package com.braisedpanda.waterfee.model.po;

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
@Table(name = "water-fee-category")
public class WaterFeeCategory {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "factory_id")
    private  Integer factoryId;
    @Column(name = "water_fee")
    private double waterFee;
    @Column(name = "zi_fee")
    private double ziFee;
    @Column(name = "sewage_treatment_fee")
    private double sewageTreatmentFee;
    @Column(name = "level")
    private Integer level;
    @Column(name = "end_number")
    private Integer endNumber;


}
