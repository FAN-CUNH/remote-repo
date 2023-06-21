package javase.day15.work4;

import java.io.*;

/**
 * @ClassName Serialize
 * @Description 序列化 序列流
 * @Author Cunhao Fan
 * @Date 2023/4/24 20:18
 * @Version 1.0
 */
public class Serialize {
    public static void main(String[] args)  {
        Student student1 = new Student("001", "张三");
        Student student2 = new Student("002", "李四");
        /*实例化文件字节输出流*/
        try(OutputStream outputStream = new FileOutputStream("D:\\student.txt");
            /*实例化序列化流对象，并将字节型输出流传入*/
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            /*写入2个学生信息*/
            objectOutputStream.writeObject(student1);
            objectOutputStream.writeObject(student2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*读入学生信息*/
        Student student = null;
        Student student0 = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\student.txt"))) {
            student = (Student) objectInputStream.readObject();
            student0 = (Student) objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(student);
        System.out.println(student0);
    }
}
