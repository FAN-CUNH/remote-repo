package javase.day15.work2;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/24 18:25
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.writerFile("151收发室11方式","D:\\d.txt",false);
        fileUtil.writerFile(fileUtil.readerFile("D:\\d.txt"),"D:\\d.txt",false);
    }
}
