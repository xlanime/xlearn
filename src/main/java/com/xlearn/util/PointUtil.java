package com.xlearn.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 积分计算工具类
 */
@Slf4j
public class PointUtil {

    //默认最低学习时间10分钟
    private static final int LEARN_TIME = 10*60*1000;

    /**
     * 根据开始时间和结束时间计算积分
     * @param beginTime
     * @param endTime
     * @return
     */
    public static Integer getPoint(Date beginTime,Date endTime){
        Long time = getTimeDiff(beginTime,endTime);
        log.info("本次学习时长(毫秒):"+time);

        //如果学习时间小于十分钟，则不计分。
        if(time < LEARN_TIME){
            return 0;
        }
        //计算规则：1小时 = 10积分
        float hours = time/(float)100/60/60;
        int point = (int)Math.ceil(hours);
        log.info("本次学习时长:"+hours+",获得积分："+point);
        return point;
    }

    /**
     * 获取两个时间之间的时间差
     * @param dateStart
     * @param dateEnd
     * @return 两个时间之间的时间差（毫秒）
     */
    public static Long getTimeDiff(Date dateStart,Date dateEnd){
        long interval = (dateEnd.getTime()-dateStart.getTime());
        return interval;
    }

    /**
     * 比较两个日期是否相同（精确到天）
     * 注意是由JDK1.8提供的Java.time方法。
     * @param date1
     * @param date2
     * @return
     */
    public static boolean sameDate(Date date1, Date date2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }

    /**
     * 比较两个时间是否相同（精确到秒）
     * @param date1
     * @param date2
     * @return
     */
    public static boolean sameTime(Date date1, Date date2) {
        Long timeDiff = getTimeDiff(date1,date2);
        if(timeDiff>0){
            return false;
        }
        return true;
    }

    /**
     * 将秒转换成时分秒格式的字符串
     * @return
     */
    public static String secondsToTimeString(Integer seconds){
        StringBuffer sb=new StringBuffer();
        int temp = seconds/3600;
        sb.append((temp<10)?temp+"小时":""+temp+"小时");

        temp=seconds%3600/60;
        sb.append((temp<10)?temp+"分钟":""+temp+"分钟");

        temp=seconds%3600%60;
        sb.append((temp<10)?temp+"秒":""+temp+"秒");

        return sb.toString();
    }
}
