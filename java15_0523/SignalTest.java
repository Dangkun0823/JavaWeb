package java15_0523;

/**
 * 假设面包店有师傅生产面包,消费者消费面包
 * 1.面包师傅有5个,可以一直生产面包.每次生产3个
 * 2.消费者有20个,可以一直消费面包,每次消费1个
 * 3.面包店库存的上限是100,下限是0.
 */
public class SignalTest {

    //库存
    private static int SUM;

    public static void main(String[] args) {
        //五个面包师傅同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM + 3 > 100) {
                                SignalTest.class.wait();
                            } else {
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName() + "生产了面包,库存: " + SUM);
                                Thread.sleep(500);
                                SignalTest.class.notify(); //随即通知一个wait方法阻塞的线程
                                // SignalTest.class.notifyAll();  //通知全部wait方法阻塞的线程
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "面包师傅[" + i + "]").start();
        }

        //20个消费者,同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM == 0) {
                                SignalTest.class.wait();
                            } else {
                                SUM--;
                                System.out.println(Thread.currentThread().getName() + "消费了面包,库存: " + SUM);
                                Thread.sleep(500);
                                SignalTest.class.notify();
                                // SignalTest.class.notifyAll();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "消费者[" + i + "]").start();
        }
    }
}
