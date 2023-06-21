package javase.day5.work.Firm;

public class Employee extends Person{ // 员工子类继承人父类
    // 声明私有属性
    private String id; // 工号
    private double wage; // 工资
    private int Seniority; // 工龄

    // 构造方法

    public Employee(String name, String address, String id, double wage, int seniority) {
        super(name, address);
        this.id = id;
        this.wage = wage;
        Seniority = seniority;
    }

    public Employee() {
    }
    // setget方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getSeniority() {
        return Seniority;
    }

    public void setSeniority(int seniority) {
        Seniority = seniority;
    }

    // 重写toString方法


    @Override
    public String toString() {
        return "员工信息{" +
                "  姓名：" + this.getName() +
                ", 地址：" + getAddress() +
                ", 工号：" + id +
                ", 工资：" + wage +
                ", 工龄：" + Seniority +
                '}';
    }

}
