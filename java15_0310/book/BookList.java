package java15_0310.book;

//定义一些书的集合
public class BookList {
    //相当于一个顺序表
    private Book[] books = new Book[100];
    //数组中有效元素的个数
    private int size = 0;

    public BookList() {
        //先默认添加几个元素进去
        books[0] = new Book("三国演义", "罗贯中", 100, "古典名著", false);
        books[1] = new Book("西游记", "吴承恩", 120, "古典名著", false);
        books[2] = new Book("金瓶梅", "兰陵笑笑生", 200, "古典名著", false);
        size = 3;
    }

    //设置getter and setter方法
    public Book getBook(int pos) {
        return books[pos];
    }

    public void setBook(int pos,Book book) {
        books[pos]=book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
