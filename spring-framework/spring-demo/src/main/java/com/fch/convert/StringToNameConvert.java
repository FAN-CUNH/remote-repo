package com.fch.convert;

import com.fch.bean.Name;
import org.springframework.core.convert.converter.Converter;


/**
 * @packageName com.fch.convert
 * @ClassName StringToNameConvert
 * @Description 类型转换器 将String类型数据转换成自定义的Name类型
 * @Author Fan-CUNH
 * @Date 2023/6/30 9:42
 * @Version 1.0
 */
public class StringToNameConvert implements Converter<String, Name> {
    @Override
    public Name convert(String s) {
        String[] name = s.split("-");
        return new Name(name[0], name[1]);
    }
}
