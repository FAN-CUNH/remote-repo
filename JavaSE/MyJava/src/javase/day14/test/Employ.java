package javase.day14.test;

public class Employ {
    private String empNo;
    private double sal;
    private String empName;

    public Employ() {
    }

    @Override
    public String toString() {
        return "Employ{" +
                "empNo='" + empNo + '\'' +
                ", sal=" + sal +
                ", empName='" + empName + '\'' +
                '}';
    }

    public Employ(String empNo, double sal, String empName) {
        this.empNo = empNo;
        this.sal = sal;
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
