package javase.day5.work.Firm;

public class Test {
    public static void main(String[] args) {
        Person person = new Employee("张三","无锡市新吴区极客营","008",8000,2); // 实例化员工对象
        Person person1 = new Manager("李四","无锡市新吴区极客营","001",18000,5,"经理"); // 实例化经理对象
        AddInterface addInterface = new AddDao();
        System.out.println("涨薪前：");
        System.out.println(person);
        System.out.println(person1);
        System.out.println("涨薪后：");
        addInterface.addWage(person);
        addInterface.addWage(person1);
        System.out.println(person);
        System.out.println(person1);

    }

}
