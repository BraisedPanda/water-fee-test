package com.braisedpanda.waterfee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: water-fee-test
 * @description:
 * @author: chenzhen
 * @create: 2020-01-16 11:50
 **/
public class DateUtil {

    public static final String  OutDate= "yyyyMMdd";

    public static String getOutDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(OutDate);
        return simpleDateFormat.format(date);
    }
}
