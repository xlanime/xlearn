package com.xlearn.util;

import java.math.BigDecimal;

/**
 * BigDecimal数据类型计算工具类
 *
 * @Author Richard
 */
public class BigDecimalUtil {

    /**
     * 私有化构造方法
     */
    private BigDecimalUtil(){

    }

    /**
     * 加add
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    /**
     * 减subtract
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal subtract(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    /**
     * 乘multiply
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal multiply(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    /**
     * 除divide
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal divide(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2);
    }

}
