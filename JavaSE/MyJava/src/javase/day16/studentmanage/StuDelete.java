package javase.day16.studentmanage;

import javautils.FileUtils;

import java.util.List;

/**
 * @ClassName stuDelete
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/25 21:53
 * @Version 1.0
 */
public class StuDelete {
    public void stuDelete(String stuNo) {
        FileUtils fileUtils = new FileUtils();
        /*创建集合存储读取到的学生信息*/
        List<String> strOfStuMess = fileUtils.bufferedReaderFile("java\\src\\JavaSE\\day16\\studentmanage\\student.txt");
        int isDelete = -1;
        for (int i = 0; i < strOfStuMess.size(); i++) {
            if (strOfStuMess.get(i).contains(stuNo+",")) {
                isDelete = i;
            }
        }
        if (isDelete != -1) {
            strOfStuMess.remove(isDelete);
            fileUtils.bufferedWriterFile(strOfStuMess,"java\\src\\JavaSE\\day16\\studentmanage\\student.txt",false);
            System.out.println("删除成功！");
        } else {
            System.out.println("该学生不存在！");
        }
    }
}
