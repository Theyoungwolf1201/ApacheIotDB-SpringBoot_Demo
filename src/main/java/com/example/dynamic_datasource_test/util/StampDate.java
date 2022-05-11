package com.example.dynamic_datasource_test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/07 13:14
 **/

public class StampDate {

    /**
     * 将时间转换为时间戳
     * @param s
     * @return res
     * @throws
     */
    public static String dateToStamp(String s) throws Exception {
        String res;//设置时间格式，将该时间格式的时间转换为时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long time = date.getTime();
        res = String.valueOf(time);
        return res;
    }

    /**
     * 将时间戳转换为时间
     * @param s
     * @return res
     * @throws
     */
    public static String stampToTime(String s) throws Exception{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long lt = new Long(s);//将时间戳转换为时间
        Date date = new Date(lt);//精确到毫秒,调整格式
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 采集系统当前时间，用于统计Apache IoTDB操作数据效率
     * @param
     * @return now
     * @throws
     */
    public String now(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String now = formatter.format(date);
        return now;
    }
}
