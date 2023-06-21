package javase.day2.test.test1;

public class MainApp {
    public static void main(String[] args) {
        Course myJava = new Course("c001","Java","2007-2-18","Java学科包含javaSE和javaEE");
        Course myChinese = new Course("c002","语文","2007-02-09","语文语文");
        Student myStu = new Student("c001","张三","男",177.5,18,myChinese);
        myStu.selCou();
    }

}
