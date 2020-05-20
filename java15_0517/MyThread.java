package java15_0517;

//创建一个线程
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
