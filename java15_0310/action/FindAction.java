package java15_0310.action;

import java15_0310.book.Book;
import java15_0310.book.BookList;

import java.util.Scanner;

//查找书
public class FindAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("执行查找图书操作");
        // 根据名字来找到对应的书籍信息
        System.out.println("请输入要查找的书籍名字: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
            }
        }
        if(i==bookList.getSize()){
            System.out.println("没有找到符合要求的书籍!");
        }
    }
}
