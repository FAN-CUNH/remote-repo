package javase.day1.work2;

public class MainApp {
    public static void main(String[] args) {
        // 创建教师和课程的实例化对象
        Teacher myTeacher1 = new Teacher();
        Teacher myTeacher2 = new Teacher();
        Teacher myTeacher3 = new Teacher();
        Course myCourse1 = new Course();
        Course myCourse2 = new Course();

        myTeacher1.setTeaNo("t001");myTeacher1.setTeaName("薛之谦");myTeacher1.setTeaSex("男");myTeacher1.setTeaAge(26);myTeacher1.setTeaCourse("Java");
        myTeacher2.setTeaNo("t002");myTeacher2.setTeaName("张碧晨");myTeacher2.setTeaSex("女");myTeacher2.setTeaAge(24);myTeacher2.setTeaCourse("IOS");
        myTeacher3.setTeaNo("t003");myTeacher3.setTeaName("张杰");myTeacher3.setTeaSex("男");myTeacher3.setTeaAge(28);myTeacher3.setTeaCourse("Java");
        myCourse1.setCouNo("s001");myCourse1.setCouName("Java");myCourse1.setCouName("2007-02-08");myCourse1.setCouDescrption("Java学科包含javaSE和javaEE");
        myCourse2.setCouNo("s002");myCourse2.setCouName("IOS");myCourse2.setCouName("2007-02-09");myCourse2.setCouDescrption("IOS系统开发");

        System.out.println(myTeacher1.getTeaNo()+" "+myTeacher1.getTeaName()+" "+myTeacher1.getTeaSex()+" "+myTeacher1.getTeaAge()+" "+myTeacher1.getTeaCourse());
        System.out.println(myTeacher2.getTeaNo()+" "+myTeacher2.getTeaName()+" "+myTeacher2.getTeaSex()+" "+myTeacher2.getTeaAge()+" "+myTeacher2.getTeaCourse());
        System.out.println(myTeacher3.getTeaNo()+" "+myTeacher3.getTeaName()+" "+myTeacher3.getTeaSex()+" "+myTeacher3.getTeaAge()+" "+myTeacher3.getTeaCourse());
        System.out.println(myCourse1.getCouNo()+" "+myCourse1.getCouName()+" "+myCourse1.getCouTime()+" "+myCourse1.getCouDescrption());
        System.out.println(myCourse2.getCouNo()+" "+myCourse2.getCouName()+" "+myCourse2.getCouTime()+" "+myCourse2.getCouDescrption());


    }
}
