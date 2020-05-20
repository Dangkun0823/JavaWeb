package java15_0517;

//标记守护线程(后台线程)或者用户线程
//守护线程(JVM后台自动启动的一些线程)
//非守护线程(用户线程)
//进程没有用户线程存活,进程就退出,而不管是否存在守护线程
public class DaemonTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "第一滴血");
        t.setDaemon(true);
        t.start();
    }
}

