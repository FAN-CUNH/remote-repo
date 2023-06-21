package javase.day16.studentmanage;

import javautils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StuLoad
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/25 21:03
 * @Version 1.0
 */
public class StuLoad {
    public void load(String stuNo) {
        /**/
        FileUtils fileUtils = new FileUtils();
        /*创建一个集合读取学生文件中学生信息*/
        List<String> strOfStuMess = fileUtils.bufferedReaderFile("java\\src\\JavaSE\\day16\\studentmanage\\student.txt");
        /*创建一个stuMess用于保存学生信息*/
        boolean isExist = false; // 假设学生不存在集合中
        String stuMess = null;
        for (String everyStuMess : strOfStuMess
        ) {
            if (everyStuMess.contains(stuNo + ",")) {
                isExist = true; // 匹配成功
                stuMess = everyStuMess;
                break;
            }
        }
        if (isExist) {
            System.out.println("登录成功！");
            try {
                Class c = Class.forName("javase.day16.studentmanage.Student");
                Map<String, String> targerMess = new HashMap<>();
                if (stuNo.equals("001")) {
                    targerMess.put("stuNo", stuNo);
                    targerMess.put("stuName", "zhangsan");
                    fileUtils.propertiesWrite(targerMess, "java\\src\\JavaSE\\day16\\studentmanage\\student.properties");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(stuMess);
        } else {
            System.out.println("该学生未注册！");
        }

    }
}
