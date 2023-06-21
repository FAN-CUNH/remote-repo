package javase.day1.work4;

public class Coder {
    // 声明3个私有成员变量
    private String coderName;
    private String coderId;
    private double coderSalary;
    // 无参构造方法
    public Coder() {

    }
    // 有参构造方法
    public Coder(String coderName, String coderId, double coderSalary) {
        this.coderName = coderName;
        this.coderId = coderId;
        this.coderSalary = coderSalary;
    }

    public String getCoderName() {
        return coderName;
    }

    public void setCoderName(String coderName) {
        this.coderName = coderName;
    }

    public String getCoderId() {
        return coderId;
    }

    public void setCoderId(String coderId) {
        this.coderId = coderId;
    }

    public double getCoderSalary() {
        return coderSalary;
    }

    public void setCoderSalary(double coderSalary) {
        this.coderSalary = coderSalary;
    }
    // 行为：工作（）
    public void work(){
        System.out.println(this.getCoderName()+"工号为"+this.getCoderId()+"基本工资为"+this.getCoderSalary()+"的程序员正在努力的写着代码......");
    }
}

