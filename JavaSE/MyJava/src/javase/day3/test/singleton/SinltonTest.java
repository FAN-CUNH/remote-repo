package javase.day3.test.singleton;

public class SinltonTest {
    public static <Singlton> void main(String[] args) {
        javase.day3.test.singleton.Singlton singlton = javase.day3.test.singleton.Singlton.newInstance();
        javase.day3.test.singleton.Singlton singlton1 = javase.day3.test.singleton.Singlton.newInstance();

        System.out.println(singlton == singlton1);
    }
}
