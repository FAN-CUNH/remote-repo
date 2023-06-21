package com.fch.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.utils
 * @ClassName XmlParserUtils
 * @Description XML解析工具来
 * @Author CunHao Fan
 * @Date 2023/6/3 16:06
 * @Version 1.0
 */
public class XmlParserUtils {

    public static <T> List<T> parse(String file, Class<T> targetClass) {
        // 封装解析出来的数据
        ArrayList<T> list = new ArrayList<>();
        try {
            // 1.获取一个解析器对象
            SAXReader saxReader = new SAXReader();
            // 2.利用解析器把xml文件加载到内存中，并返回一个文档对象
            Document document = saxReader.read(new File(file));
            // 3.获取根标签
            Element rootElement = document.getRootElement();
            // 4.根据根标签获取 user 标签
            List<Element> elements = rootElement.elements("emp");
            // 5.遍历集合，得到每一个 user 标签
            elements.forEach(element -> {
                // 获取 name 属性
                String name = element.element("name").getText();
                // 获取 age 属性
                String age = element.element("age").getText();
                // 获取 image 属性
                String image = element.element("image").getText();
                // 获取 gender 属性
                String gender = element.element("gender").getText();
                // 获取 job 属性
                String job = element.element("job").getText();

                //组装数据
                Constructor<T> constructor = null;
                try {
                    constructor = targetClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class, String.class);
                    constructor.setAccessible(true);
                    T object = constructor.newInstance(name, Integer.parseInt(age), image, gender, job);
                    list.add(object);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
