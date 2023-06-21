package com.dao;

import com.bean.Student;
import com.utils.IOUtils;
import com.utils.ResourcePath;


import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 * @ClassName StudentDao
 * @Description 业务实现层
 * @Author Cunhao Fan
 * @Date 2023/5/9 15:52
 * @Version 1.0
 */
public class StudentDao {
    /*实例化工具类*/
    IOUtils ioUtils;
    /*存储学生对象*/
    ArrayList<Student> students = null;

    public StudentDao() {
        students = new ArrayList<>();
        ioUtils = new IOUtils();
    }
    /**
     * @Description 登录
     * @param stuNo 学号
     * @param stuPassword 密码
     * @return Student
     * @Author Cunhao Fan
     * @Date 2023/5/9 15:49
     */
    public Student login(String stuNo, String stuPassword){
        /*声明一个学生，用来表示当前登录学生*/
        Student loginStu = null;
        /*文件为空*/
        if (new File(ResourcePath.STUDENT_MESS_PATH).length() == 0) {
            /*登录失败*/
        }
        /*文件不为空*/
        else {
            /*读取学生文件信息,存储到学生结合中*/
            students = (ArrayList<Student>) ioUtils.readFile(ResourcePath.STUDENT_MESS_PATH);
            System.out.println(students);
            /*根据学号和密码判断学生是否已注册*/
            for (Student student : students) {
                if (student != null && student.getStuNo().equals(stuNo) && student.getStuPass().equals(stuPassword)) {
                    loginStu =  student;
                }
            }
        }
        return  loginStu;
    }

    /**
     * @Description 注册
     * @param stuNo 学号
     * @param stuPassword 密码
     * @return Student
     * @Author Cunhao Fan
     * @Date 2023/5/9 15:50
     */
    public Student register(String stuNo, String stuPassword){
        /*注册的学生对象，假设不存在*/
        Student registerStudent = null;
        /*遍历集合查看当前学生是否存在*/
        for (Student student : students) {
            if (student.getStuNo().equals(stuNo) && student.getStuPass().equals(stuPassword)) {
                /*已注册*/
                registerStudent = student;
                break;
            }
        }
        /*未注册*/
        if (registerStudent == null) {
            registerStudent = new Student(stuNo, stuPassword);
            /*读取学生文件信息,存储到学生结合中*/
            students = (ArrayList<Student>) ioUtils.readFile(ResourcePath.STUDENT_MESS_PATH);
            students.add(registerStudent);
            ioUtils.writerFile(students, ResourcePath.STUDENT_MESS_PATH, false);
        }
        return  registerStudent;
    }


    /**
     * @Description 发送聊天信息
     * @param mess 信息
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/9 15:50
     */
    public void sendMess(String mess)  {
        /*创建发送端的发送对象 -> 用来发送或者接收数据包，端口号为8000*/
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        /*实现连续发送效果*/

        /*标记 假设发送端不停发送*/
        boolean isExit = false;
        /*当接收到的信息为exit，则停止发送*/
        if (mess.equals("exit")) {
            isExit = true;
        }
        /*持续发送*/
        if (!isExit) {
            /*创建数据包对象 参数 -> 发送的信息， 发送的信息长度， ip地址， 接收端口号*/
            DatagramPacket datagramPacket = null;
            try {
                datagramPacket = new DatagramPacket(mess.getBytes(), mess.getBytes().length, InetAddress.getLocalHost(), 8081);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            /*利用套接字发送数据包*/
            try {
                datagramSocket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(mess);
        }
        /*通知接收端，发送端已停止发送，让接收端停止接收*/
        else {
            DatagramPacket datagramPacket = null;
            try {
                datagramPacket = new DatagramPacket("exit".getBytes(), mess.getBytes().length, InetAddress.getLocalHost(), 8081);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            try {
                datagramSocket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*关闭发送端对象，并释放接口*/
        datagramSocket.close();
    }

    public String receiveMess() {
        /*创建接收端的接收对象*/
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8081);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer("");
        while (true) {
            /*定义一个byte类型数组，用于存储每次接收到的信息*/
            byte[] messOfReceive = new byte[1024];
            /*创建接收端数据包 参数： 接收的信息， 接收的信息长度*/
            DatagramPacket datagramPacket = new DatagramPacket(messOfReceive, messOfReceive.length);
            /*接收信息*/
            try {
                datagramSocket.receive(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*定义一个int类型的变量len，表示byte数组中的有效信息长度*/
            int len = datagramPacket.getLength();
            /*读取接收到的信息*/
            String mess = new String(messOfReceive, 0, len);
            /*判断接收到信息是否是有效信息，exit信息不需要打印*/
            if ("exit".equals(mess)) {
                break;
            }
            System.out.println(mess);
            stringBuffer.append(mess);
        }
        /*关闭接收端，并释放接口*/
        datagramSocket.close();
        return stringBuffer.toString();
    }
}
