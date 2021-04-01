package edu.hebeu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 与日期相关的工具类
 */
public class DateUtil {

    /**
     * 将Date通过指定的String类型转换为 指定的String字符串
     * @param date
     * @param formatStr
     * @return
     */
    public static String dateToString(Date date, String formatStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
        return dateFormat.format(date);
    }

    /**
     * 将特定的字符串转换为 指定日期
     * @param dateStr
     * @param formatStr
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr, String formatStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        return simpleDateFormat.parse(dateStr);
    }
}
