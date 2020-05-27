package java15_0310.action;

import java15_0310.book.Book;
import java15_0310.book.BookList;

import java.util.Scanner;

//删除书
public class DelAction implements IAction{

    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书名:");
        String name = scanner.next();
        // 先找到对应书名的位置
        int i=0;
        for(;i<bookList.getSize();i++){
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("删除失败! 没有匹配的书名!");
            return;
        }
        // 循环结束的时候, i 对应的值, 就是要删除图书的下标
        // 顺序表中, 删除尾部元素最简单, size--即可. 删除中间元素, 需要搬运
        // 把删除中间元素转换成删除尾部元素
        // 也可以按照遍历的方法删除,比较麻烦
        int size=bookList.getSize();
        bookList.setBook(i,bookList.getBook(size-1));
        bookList.setSize(size-1);
    }
}
