package javase.day14.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        int[] numbers = {11, 22, 33};
        //遍历数组的每一个元素，统计数组中元素长度等于2的元素个数
        //1 获取数组的流对象
        Stream arrayStream = Stream.of(numbers);
        //2 把改数组转换List
        List listNumbers = Arrays.asList(numbers);
        //获取集合的Stream
        Stream stream = listNumbers.stream();
        //3 将List转换Set
        Set setNumers = new TreeSet();
        setNumers.addAll(listNumbers);
        //获取set的Stream
        Stream stream1 = setNumers.stream();
    }
}
