package javase.day5.work.school;

public class Test {
    public static void goToSport(Sprot s){
        s.playBasketball();
    }
    public static void goToRestaurant(Person p){
        p.eat();
    }
    public static void main(String[] args) {
        // 实例化老师对象
        SportTeacher sp = new SportTeacher("周晓斌",30);
        SportStudent ss = new SportStudent("叶知秋",18);
        Test.goToSport(sp); // 向上转型
        Test.goToSport(ss);
        Test.goToRestaurant(sp);
        Test.goToRestaurant(ss);
    }
}
