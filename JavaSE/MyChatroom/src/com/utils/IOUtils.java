package com.utils;

import java.io.*;

public class IOUtils {
    //使用序列流操作文件集合对象
    public Object readFile(String path){
        Object studentsList = null;
        try(InputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
             studentsList = objectInputStream.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return studentsList;
    }
    //写文件，每次从头写入
    public void writerFile(Object studentList,String path,boolean append){
     try(OutputStream outputStream = new FileOutputStream(path,append);ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
            objectOutputStream.writeObject(studentList);
     }
     catch (Exception e){
         e.printStackTrace();
     }
    }

}
