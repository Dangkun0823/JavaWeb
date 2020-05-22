package java15_0518;

//线程不安全
//有一个共享变量，初始0，启动20个线程，每个线程循环10000，每次循环将共享变量++
public class UnsafeThread {
    private static int SUM;
    public static void increment(int n){
        SUM++;
    }

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++){
                    increment(j);
                }
            }).start();
        }

        //下面代码保证了所有子线程执行完毕之后，打印SUM的值
        //activeCount() 判断当前线程的存活数量
        while (Thread.activeCount()>1){
            //idea使用debug运行，run运行的话，>2(idea run运行时会默认启动一个线程)。
            Thread.yield();
            //线程让步
            //当前线程(main线程)由运行态转变为就绪态
        }
        System.out.println(SUM);
    }
}
