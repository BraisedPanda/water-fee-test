package com.braisedpanda.waterfee.utils;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 11:15
 **/
public  class StepWaterFeeUtil {
    
    /** 
    * @Description: 阶梯水费计算
    * @Param: [fee] 传入的用水量
    * @Date: 2020/1/16 0016 
    */ 
    public static double getStepWaterFee(double consumption){
        double fee = 0;
        if(consumption<=10 && consumption>0){
            fee = consumption*2;
        }if(consumption>10 && consumption<=20){
            fee = (consumption-10)*2.5 + 20;
        }else if(consumption>20 ){
            fee = 20 +25 + (consumption-20)*3;
        }
        return fee;

    }
}
