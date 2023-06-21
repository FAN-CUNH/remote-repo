package javase.day3.work.readbook;

public class Book {
    // 属性
    private String bookName;
    // 构造方法

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }
    // setget行为
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
