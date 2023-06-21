package javase.day12.library;

import java.util.*;

public class BookUtils {
    //key是类目   value是类目下的很多书
    Map<String, ArrayList<Book>> map = new HashMap<String, ArrayList<Book>>();
    //初始化
    public void init(){
        // 创建集合对象，用于存储学生数据
        ArrayList<Book> it = new ArrayList<Book>();
        it.add(new Book("Java入门到精通", 99));
        it.add(new Book("PHP入门到精通", 9.9));
        map.put("it书籍", it);
        ArrayList<Book> mz = new ArrayList<Book>();
        mz.add(new Book("西游记", 19));
        mz.add(new Book("水浒传", 29));
        map.put("名著", mz);
    }
    //完成图书的查看
    public  void printAllBooks(){
        //类目名：
        //   书名   价格
        //1 先获取key
        Set <String> bookType = map.keySet();
        //2 根据key遍历所有集合value
        for (String everyBookType:bookType) {
            /*打印所有类目*/
            System.out.println(everyBookType);
            //3 遍历每个类目下的集合value
            ArrayList<Book> bookArrayList = map.get(everyBookType);
            for (Book everyBook: bookArrayList) {
                System.out.println("\t"+everyBook.getName()+":"+everyBook.getPrice());
            }
        }

    }



    //图书的删除
    public  void deleteBook(String mess){//可以传入类目   可以传入书名
        //展示所有类名和附带后方所有书名
        /*Set <Map.Entry<String, ArrayList<Book>>> bookTypeBookTypeAndBookMess = map.entrySet();
        for (Map.Entry<String, ArrayList<Book>> everyBookTypeAndBookMess: bookTypeBookTypeAndBookMess) {
            String everyBookType = everyBookTypeAndBookMess.getKey();
            ArrayList<Book> everyBookMess = everyBookTypeAndBookMess.getValue();
            System.out.println(everyBookType);
            System.out.println(everyBookMess.toString());
            for (Book everyBook : everyBookMess) {
                System.out.print(everyBook.getName()+" ");
            }

        }*/
        /*假设不可以删除*/
        boolean isdel = false;
        Set <String> bookType = map.keySet();
        for (String everyBookType:bookType) {
            /*打印所有类目*/
            System.out.print(everyBookType);

            //3 遍历每个类目下的集合value
            ArrayList<Book> bookArrayList = map.get(everyBookType);
            for (Book everyBook: bookArrayList) {
                System.out.print(" "+everyBook.getName());
            }
            System.out.println();
        }
        //it    java   c
        //名著    西游记
        //1 获取所有key用key名比较，相等，说明根据类目删除；否则跟书名，相等根据书名删除
        for (int i = 0; i < bookType.size(); i++) {
            if (bookType.contains(mess)){
                /*依据类目删除*/
                bookType.remove(mess);
                System.out.println(mess+"类型书籍删除成功!");
                isdel = true;
                break;
            }
            else {
                /*根据书名删除*/
                for (String everyBookType:bookType) {
                    ArrayList<Book> bookArrayList = map.get(everyBookType);
                        Iterator<Book> iterator = bookArrayList.iterator();
                        while (iterator.hasNext()){
                            Book book = iterator.next();
                            if (book.getName().equals(mess)){
                                iterator.remove();
                                System.out.println(mess+"删除成功！");
                                isdel = true;
                            }
                        }

                }
            }
        }
        if (!isdel){
            System.out.println("找不到无法删除！");
        }

    }


    //图书的修改
    public void updateBook(Book newBook){//newBook原来的书名和现在的价格
        //1 获取所有的key
        Set <String> bookType = map.keySet();
        //2 根据key获取所有类目下的书，每一本书跟newBook的名字比较，找到修改价格
        for (String everyBookType:bookType) {
            //3 遍历每个类目下的集合value
            ArrayList<Book> bookArrayList = map.get(everyBookType);
            for (Book everyBook: bookArrayList) {
                if (everyBook.getName().equals(newBook.getName())){
                    System.out.println("更新前："+everyBook);
                    everyBook.setPrice(newBook.getPrice());
                    System.out.println("更新后："+everyBook);
                }
            }
        }


    }
    public void print(){
        //1 展示类目
        Set <String> bookType = map.keySet();
        for (String everyBookType:bookType) {
            /*打印所有类目*/
            System.out.print(everyBookType+" ");
        }
    }


    //图书的添加
    public  void addBook(String bt,Book book){
        Set <String> bookType = map.keySet();
        for (String everyBookType:bookType) {
            /*打印所有类目*/
            System.out.print(everyBookType+" ");
        }
        //输入类目；类目存在将book加入到改目录下；不存在新建关系放入map
        for (String everyBookType:bookType) {
            if (bt.equals(everyBookType)){
                ArrayList<Book> list = map.get(everyBookType);
                list.add(book);
                System.out.println(book.getName()+"添加成功！");
                break;
            }
            else {
                ArrayList<Book> arrayList = new ArrayList<>(Arrays.asList(book));
                map.put(bt,arrayList);
                System.out.println(book.getName()+"已加入"+bt+"类目中！");
                break;
            }
        }
    }
}
