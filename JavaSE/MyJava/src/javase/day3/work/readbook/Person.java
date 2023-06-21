package javase.day3.work.readbook;

public class Person {
    // 属性
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public Person() {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }


    // 看书行为
    public void readBook(Book book){
        System.out.println(this.personName+"正在看"+book.getBookName()+"小说");
    }
}
