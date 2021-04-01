package edu.hebeu.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类实现SpringMVC提供的Converter接口，
 * 实现String类型转换为Date类型
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("edu.hebeu.utils.StringToDateConverter.convert()方法，要转换的类型不能为空！");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 指定字符串的日期格式
        try {
            return dateFormat.parse(s); // 将字符串按照指定的格式转换为日期
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("edu.hebeu.utils.StringToDateConverter.convert()方法异常，类型转换失败！");
        }
    }
}
