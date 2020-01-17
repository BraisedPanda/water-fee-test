package com.braisedpanda.waterfee.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 10:08
 **/
@Data
@Table(name = "step_water")
public class StepWater {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "consumption")
    private Double consumption;
    @Column(name = "record_date")
    private String recordDate;

}
