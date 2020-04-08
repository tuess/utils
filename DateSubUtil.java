package com.epnce.ads.ticket.data.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DataSubUtil
 * @Description 时间差工具类
 * @Author tuess
 * @Version 1.0
 **/
public class DateSubUtil {

    /**
     * 功能描述:
     * 计算传入时间与当前时间差
     *
     * @param date 传入时间
     * @return : 时间差
     * @author : tuess
     */
    public static String DateSub(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = date;
            Date d2 = new Date();
            long diff = d1.getTime() - d2.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            return (days + "天" + hours + "小时" + minutes + "分");
        } catch (Exception e) {
            throw new RuntimeException("计算时间差异常");
        }
    }

    /**
     * 功能描述:
     * 计算第一位时间与第二位时间的时间差
     *
     * @param date1 第一位时间
     * @param date2 第二位时间
     * @return : 时间差
     * @author : tuess
     */
    public static String DateSubDate(Date date1, Date date2) {
        try {
            long diff = date1.getTime() - date2.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            if (days == 0) {
                if (minutes == 0) {
                    return (hours + "小时");
                }
                return (hours + "小时" + minutes + "分");
            } else if (minutes == 0) {
                return (days + "天" + hours + "小时");
            }
            return (days + "天" + hours + "小时" + minutes + "分");
        } catch (Exception e) {
            throw new RuntimeException("计算时间差异常");
        }
    }

    public static String SetBlockType(Date date1, Date date2) {
        try {
            long diff = date1.getTime() - date2.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            if (days == 0 && hours <= 1) {
                return "短时封锁";
            } else if (days == 0 && hours <= 24) {
                return "长时封锁";
            }
            return "长期封锁";
        } catch (Exception e) {
            throw new RuntimeException("计算封锁类型异常异常");
        }
    }
}
