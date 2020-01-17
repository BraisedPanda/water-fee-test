package com.braisedpanda.waterfee.model.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 10:03
 **/
@Data
@Table(name = "fee")
public class Fee {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "fee")
    private Double fee;
    @Column(name = "out_date")
    private String outDate;

}
