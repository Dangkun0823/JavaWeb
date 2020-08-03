package util;

//在并发编程的时候，成员变量如果不做任何处理其实是线程不安全的，各个线程都在操作同一个变量，显然是不行的.
//变量是同一个，但是每个线程都使用同一个初始值，也就是使用同一个变量的一个新的副本.
//而我们每个线程都需要使用他, 并且各自使用各自的.
public class ThreadLocalHolder {
    //ThreadLocal: 线程局部变量
    private static final ThreadLocal<Integer> COUNT = new ThreadLocal<>();

    public static ThreadLocal<Integer> get(){
        return COUNT;
    }
}
