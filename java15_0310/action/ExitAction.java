package java15_0310.action;

import java15_0310.book.BookList;

//退出
public class ExitAction implements IAction {

    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye!!!");
        System.exit(0);
        //status 表示状态.
        //输出一个0 然后结束程序
    }
}
