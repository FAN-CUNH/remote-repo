package javase.day18.student_manage_system;

/**
 * @ClassName Sex
 * @Description 性别枚举模板类
 * @Author Cunhao Fan
 * @Date 2023/4/28 10:19
 * @Version 1.0
 */
public enum Sex {
    男("BOY", 1), 女("GIRL", 0);
    private String sexName;
    private int sexValue;

    Sex(String sexName, int sexValue) {
        this.sexName = sexName;
        this.sexValue = sexValue;
    }
}
