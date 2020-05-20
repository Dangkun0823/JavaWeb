package java15_0517;

//等待一个线程死亡或者时间到就自动退出

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Thread Baby");
            try {
                Thread.sleep(3000);
                System.out.println("Thread Baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        //不传参数,等待这个线程死亡,然后打印main
        t.join();
        //等1秒打印main,然后等2秒打印第二个baby.
        t.join(1000);
        //等三秒直接打印main.
        t.join(5000);
        System.out.println("main");
    }
}
