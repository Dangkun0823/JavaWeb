package java15_0310.action;

import java15_0310.book.Book;
import java15_0310.book.BookList;

//展示书
public class DisplayAction implements IAction {
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
