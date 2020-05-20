package java15_0514;

public class lesson1 {
    //InterruptedException异常,说明该方法是可能会花一点时间，但是可以取消的方法。
    public static void main(String[] args) throws InterruptedException {
////        1.观察让main线程阻塞 (main线程阻塞)
////        sleep的参数是毫秒 1秒=1000毫秒;
//       Thread.sleep(999999999999L);
//
////        2.观察在子线程中让子线程阻塞 (main线程已经结束,子线程"第一滴血"阻塞)
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血").start();
//
////        3.子线程和main线程都阻塞 (main线程和"第一滴血"都阻塞)
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(99999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血").start();
//        Thread.sleep(99999999999L);
//
////        4.main线程调用run方法 (main线程被阻塞,字线程没有start启动,不会执行)
//        Thread t=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血");
//        t.run();

//        5.main线程和子线程同时运行,打印观察执行顺序
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        }, "血滴").start();
        //Thread.sleep(999L);
        //如果加上这一行代码就先打印"第一滴血",然后打印"main".
        //它会产生阻塞,然后时间片又在上面已经经过的进程中间进行轮转
        //此时就会把"第一滴血"打印出来
        System.out.println("main");

        //下面这5个线程的名称也是随机打印的,因为他们是new出来的线程
        for(int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }

    }
}
