package java15_0524;

/**
 * 这种写法是把synchronized代码块中的 if else改成while
 * 这种写法更常见,推荐使用该写法
 */
public class SignalTest1 {
    private static int SUM;

    public static void main(String[] args) {
        //5个面包师傅，同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest1.class) {

                            //此处while是让当前条件满足之后才能继续执行
                            //也就是获取锁之后又释放锁,获取之后又释放,直到满足条件才能继续执行
                            while (SUM + 5 > 100) {
                                SignalTest1.class.wait();
                            }
                            SUM += 5;
                            System.out.println(Thread.currentThread().getName() + "生产了面包，库存：" + SUM);
                            Thread.sleep(500);
//                                SignalTest.class.notify();//随机通知一个wait方法阻塞的线程
                            SignalTest1.class.notifyAll();//通知全部wait方法阻塞的线程
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "面包师傅【" + i + "】").start();
        }
        //20个消费者，同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest1.class) {
                            while (SUM - 3 < 0) {
                                SignalTest1.class.wait();
                            }
                            SUM -= 3;
                            System.out.println(Thread.currentThread().getName() + "消费了面包，库存：" + SUM);
                            Thread.sleep(500);
//                                SignalTest.class.notify();
                            SignalTest1.class.notifyAll();
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "消费者【" + i + "】").start();
        }
    }
}
