package java15_0524;

/**
 * 三个线程并发执行
 * 第一个只能打印A,第二个只能打印B,第三个只能打印C
 * 要求打印结果:ABC
 */
public class SequencePrint {

//    public static void print1() {
//        Thread t1 = new Thread(new Print("A", null));  //new一个自定义的类(对象)
//        Thread t2 = new Thread(new Print("B", t1));
//        Thread t3 = new Thread(new Print("C", t2));
//        t1.start();
//        t3.start();
//        t2.start();
//    }
//
//    public static void main(String[] args) {
//        print1();
//    }
//
//    //静态内部类实现Runnable接口
//    private static class Print implements Runnable {
//        private String content;
//        private Thread t;
//
//        public Print(String content, Thread t) {
//            this.content = content;
//            this.t = t;
//        }
//
//        @Override
//        public void run() {
//            try {
//                //t2和t3的t都不为null,t1的t为null
//                //t2依赖t1先执行完,t3依赖t2先执行完才能执行
//                //也可以把t1的t换为new Thread()
//                if (t != null)
//                    t.join();
//                System.out.println(content);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public static void main(String[] args) {
//        int arr[] = new int[3];
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                //注意这个加锁操作,保证线程安全(顺序性)
//                synchronized (SequencePrint.class) {
//                if (arr[0] == 0) {
//                    System.out.println("A");
//                    arr[0] = 1;
//                } else if (arr[1] == 0) {
//                    System.out.println("B");
//                    arr[1] = 1;
//                } else if (arr[2] == 0) {
//                    System.out.println("C");
//                }
//            }
//            }).start();
//        }
//    }

    /**
     * 升级版要求：
     * （1）同时执行
     * （2）打印结果：
     * ABC
     * ABC
     * 循环打印共计10次
     * 思路：
     * 每个线程循环10次来打印A、B、C
     * 每次打印之后，等待其余线程打印完，再往下执行
     */

    public static void print2() {
        Thread t1 = new Thread(new Print2("A"));  //new一个自定义的类(对象)
        Thread t2 = new Thread(new Print2("B"));
        Thread t3 = new Thread(new Print2("C"));
        t1.start();
        t3.start();
        t2.start();
    }

    private static class Print2 implements Runnable{
        private String content;
        private static String[] ARRAY={"A","B","C"};
        private static  int INDEX;

        public Print2(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            try {
                for(int i=0;i<10;i++){
                    synchronized (ARRAY){

                        //注意此处使用while进行判断
                        while (!ARRAY[INDEX].equals(content)){
                            ARRAY.wait();
                        }
                        System.out.print(content);
                        if(INDEX==ARRAY.length-1){
                            System.out.println();
                        }
                        INDEX=(INDEX+1)%ARRAY.length;
                        ARRAY.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        print2();
    }
}
