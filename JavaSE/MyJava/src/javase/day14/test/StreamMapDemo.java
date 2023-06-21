package javase.day14.test;

import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMapDemo {
    public static void main(String[] args) {
        //数组中的所有纯数字字符串的前3位字符获取出来转换成整数，放入集合
        String[] allMess = {"14245","326475","37547568"};
        //1 获取Stream
        Stream stream = Stream.of(allMess);
        //map
        Function<String,Integer> function = (string1)->{
            return  Integer.parseInt(string1.substring(0,3));
        };

        stream = stream.map(function);
        stream.forEach((everyInt)-> System.out.println(((Integer) everyInt) + 1));
    }
}
