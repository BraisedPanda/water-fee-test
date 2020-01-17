package com.braisedpanda.waterfee.controller;

import com.braisedpanda.waterfee.model.dto.WaterFeeCategoryDto;
import com.braisedpanda.waterfee.model.po.Fee;
import com.braisedpanda.waterfee.model.po.StepWater;
import com.braisedpanda.waterfee.model.po.WaterFeeCategory;
import com.braisedpanda.waterfee.service.FeeService;
import com.braisedpanda.waterfee.service.StepWaterService;
import com.braisedpanda.waterfee.service.WaterFeeCategoryService;
import com.braisedpanda.waterfee.utils.DateUtil;
import com.braisedpanda.waterfee.utils.StepWaterFeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 10:21
 **/
@RestController
@RequestMapping("/fee")
public class FeeController {

    @Autowired
    private FeeService feeService;
    @Autowired
    private StepWaterService stepWaterService;
    @Autowired
    private WaterFeeCategoryService waterFeeCategoryService;

    @RequestMapping("/test/{userId}")
    public void testFee(@PathVariable("userId") Integer userId){
        List<StepWater> stepWaterList = stepWaterService.selectAll(userId);
        List<Fee> feeList = new ArrayList<>();
        List<WaterFeeCategoryDto> waterFeeCategoryList = waterFeeCategoryService.selectByFactory(1);

        for (StepWater stepWater:
             stepWaterList) {
            Fee fee = new Fee();
            double consumption = stepWater.getConsumption();
            double waterFee = getStepWaterFee(waterFeeCategoryList, consumption);
//            double waterFee = StepWaterFeeUtil.getStepWaterFee(consumption);
            fee.setUserId(stepWater.getUserId());
            fee.setFee(waterFee);
            fee.setOutDate(DateUtil.getOutDate());
            feeList.add(fee);

        }

    }

    public double getStepWaterFee(List<WaterFeeCategoryDto> waterFeeCategoryList, Double consumption){
        //1.确定当前用水量的阶数
        int jieshu = 1;
        for(int i=0; i<waterFeeCategoryList.size();i++){
            if(consumption > waterFeeCategoryList.get(i).getEndNumber()){
                jieshu++ ;
            }
        }
        //2.阶数确定后，分成两部计算：（1）计算此前阶数-1的固定消费[阶数必定大于1]   （2）计算当前阶的阶数消费
        if(jieshu > waterFeeCategoryList.size()){
            jieshu = waterFeeCategoryList.size();
        }

        double fee = 0;
        if(jieshu == 1){
            WaterFeeCategoryDto dto = waterFeeCategoryList.get(0);
            double waterFee = dto.getWaterFee();
            double sewageTreatmentFee= dto.getSewageTreatmentFee();
            double ziFee = dto.getZiFee();
            fee = fee + (waterFee+sewageTreatmentFee+ziFee)*consumption;

        }else{
            for(int i=1; i<jieshu; i++){
                if(i!=jieshu-1){ //当前水费不在对应的阶数，计算之前的水费
                    WaterFeeCategoryDto dto = waterFeeCategoryList.get(i);
                    double waterFee = dto.getWaterFee();
                    double sewageTreatmentFee= dto.getSewageTreatmentFee();
                    double ziFee = dto.getZiFee();
                    double endNumber1 = waterFeeCategoryList.get(i-1).getEndNumber();
                    double endNumber2 = dto.getEndNumber();
                    fee = fee + (waterFee+sewageTreatmentFee+ziFee)*(endNumber2-endNumber1);
                }else{  //当前水费在对应的阶数
                    WaterFeeCategoryDto dto = waterFeeCategoryList.get(i);
                    double waterFee = dto.getWaterFee();
                    double sewageTreatmentFee= dto.getSewageTreatmentFee();
                    double ziFee = dto.getZiFee();
                    double endNumber = waterFeeCategoryList.get(i-1).getEndNumber();
                    fee = fee + (waterFee+sewageTreatmentFee+ziFee)*(consumption-endNumber);
                }

            }
            //最后加上第一阶梯的费用
            WaterFeeCategoryDto dto = waterFeeCategoryList.get(0);
            double waterFee = dto.getWaterFee();
            double sewageTreatmentFee= dto.getSewageTreatmentFee();
            double ziFee = dto.getZiFee();
            double endNumber = dto.getEndNumber();
            fee = fee +(waterFee+sewageTreatmentFee+ziFee)*(endNumber);


        }
        System.out.println("当前的耗水量为："+consumption);
        System.out.println("当前的阶数为："+jieshu);
        System.out.println("当前水费为："+fee);
        System.out.println("------------------------");



        return 0;
    }


}
