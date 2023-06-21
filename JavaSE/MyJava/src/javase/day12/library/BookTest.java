package javase.day12.library;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookUtils bookUtils = new BookUtils();
        bookUtils.init();


        /*更新书籍*/


        while (true){
            System.out.println("欢迎进入图书管理系统！");
            System.out.println("请选择：1 图书查看 2 图书删除 3 图书更新 4 图书添加 5 退出" );
            int choose = scanner.nextInt();
            switch (choose){
                case 1:{
                    bookUtils.printAllBooks();
                    break;
                }
                case 2:{
                    System.out.println("请录入你要删除的类目或图书：");
                    String del = scanner.next();
                    bookUtils.deleteBook(del);
                    break;
                }
                case 3:{
                    System.out.println("请录入你要更新的书名和价格：");
                    String bookName = scanner.next();
                    Double bookPrice = scanner.nextDouble();
                    Book book = new Book(bookName,bookPrice);
                    bookUtils.updateBook(book);
                    break;
                }
                case 4:{
                    bookUtils.print();
                    System.out.println("\n"+"请录入你要添加的类目,书名和价格：");
                    String bookType = scanner.next();
                    String bookName = scanner.next();
                    Double bookPrice = scanner.nextDouble();
                    Book book = new Book(bookName,bookPrice);
                    bookUtils.addBook(bookType,book);
                    break;
                }
                case 5:{
                    break;
                }
                default:{
                    System.out.println("没有该服务！");
                }
            }
        }
    }
}
