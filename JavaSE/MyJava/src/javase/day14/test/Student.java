package javase.day14.test;

public  class Student{
    private int age;
    private String stuNo;

    public Student() {
    }

    public Student(int age, String stuNo) {
        this.age = age;
        this.stuNo = stuNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", stuNo='" + stuNo + '\'' +
                '}';
    }
}