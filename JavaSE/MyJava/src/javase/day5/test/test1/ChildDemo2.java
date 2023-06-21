package javase.day5.test.test1;

public class ChildDemo2 implements  ParentDemo{
    //独有的属性
    private int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "ChildDemo2{" +
                "b=" + b +
                '}';
    }
}
