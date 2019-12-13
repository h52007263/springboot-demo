package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hezhensheng
 * @version 1.0
 * @description DateUtil
 * @date 2019/11/27 2:09
 */

public class DateUtil {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /**
     * 日期转时间
     * @param date
     * @return
     */
    public static String date2String(Date date){
        return sdf.format(date);
    }

    /**
     * 时间戳转字符串
     * @param timestap
     * @return
     */
    public static String timestamp2String(Long timestap) {
        Date date = new Date(timestap);
        return sdf.format(date);
    }


    public static void main(String[] args) {
        // 1574791969881
        System.out.println(timestamp2String(1574791969881L));
    }

}
