package java15_0518;


//停止一个线程
public class StopThreadTest {
    private volatile static boolean IS_STOP;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                while (!IS_STOP) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100000000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        //特殊情况出现,要中断子线程
        IS_STOP = true;
    }

    //比如这种情况就会无法完成中断,因为子线程产生了阻塞
}
