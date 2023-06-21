package com.fch.utils;

import java.awt.*;
import java.util.Random;

public class CodeUtils {
    //生成随机字符串
    Random r = new Random();

    //获取随机字符串
    public String getRandomStr() {
        String str = "23456789ABCDEFGHIGKMNPQSTUVWXYZabcdefghgklmnpqstuvwxyz";
        //StringBuilder叫字符串缓存区对象,使用时可以不断添加字符、字符串等已有内容。
        //需要使用时调用toString()获得对象里的所有字符串。
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(str.length());
            char letter = str.charAt(index);
            sb.append(letter);
        }
        return sb.toString();

    }

    //获取随机的背景颜色
    public Color getBackColor() {
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        return new Color(red, green, blue);


    }

    //前景颜色和背景颜色要反差大所以我们的颜色需要相减
    public Color getForeColor(Color bgColor) {

        int red = 255 - bgColor.getRed();
        int green = 255 - bgColor.getGreen();
        int blue = 255 - bgColor.getBlue();


        return new Color(red, green, blue);

    }

}
