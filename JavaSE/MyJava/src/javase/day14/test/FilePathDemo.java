package javase.day14.test;

import java.io.File;

public class FilePathDemo {
    public static void main(String[] args) {
        String filePAth = "D:"+ File.separator+"A"+File.separator+"B"+File.separator+"c.txt";
        System.out.println(filePAth);
    }
}
