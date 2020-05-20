package java15_0517;

//多线程VS单线程
public class MultiThreadVsSingleThread {
    private static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                SUM++;
            }).start();
        }

        //此时创建了这么多线程他的效率问题就产生了,不一定比下面的单线程执行效率更高
        //因为每次创建一个线程以及申请系统调度都会有时间消耗

        for(int i=0;i<20;i++){
            SUM++;
        }
    }
}
