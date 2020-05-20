package java15_0517;

public class StartVSRun {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        },"子线程Thread Baby").start();

        //lamda表达式
        new Thread(()->{
            System.out.println("第二滴血");
        },"子线程Thread Baby").start();

        System.out.println("main");
//此时"第一滴血"可能先于main打出来,因为一旦新的线程创建,系统就会就行资源调度,
//可能就会先将"第一滴血"打印

        for(int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
