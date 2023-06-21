package javase.day1.work4;

public class Manager {
    // 声明4个私有成员属性
    private String MaName;
    private String MaId;
    private double MaSalary;
    private double MaBonus;
    // 无参构造方法
    public Manager(){

    }
    // 有参构造发法
    public Manager(String maName, String maId, double maSalary, double maBonus) {
        MaName = maName;
        MaId = maId;
        MaSalary = maSalary;
        MaBonus = maBonus;

    }
    // setget方法
    public String getMaName() {
        return MaName;
    }

    public void setMaName(String maName) {
        MaName = maName;
    }

    public String getMaId() {
        return MaId;
    }

    public void setMaId(String maId) {
        MaId = maId;
    }

    public double getMaSalary() {
        return MaSalary;
    }

    public void setMaSalary(double maSalary) {
        MaSalary = maSalary;
    }

    public double getMaBonus() {
        return MaBonus;
    }

    public void setMaBonus(double maBonus) {
        MaBonus = maBonus;
    }
    // 行为：工作（）
    public void work(){
        System.out.println(this.getMaName()+"工号为"+this.getMaId()+"基本工资为"+this.getMaSalary()+"奖金为"+this.getMaBonus()+"的项目经理正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....");
    }
}
