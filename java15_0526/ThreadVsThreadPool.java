package java15_0526;

import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadVsThreadPool {

    public static void main(String[] args) {
        //1 没使用线程,送快递
        //2 我自己送快递,再干自己的活.
        System.out.println("送快递到北京");  //模拟送快递,可能送快递比较耗时
        System.out.println("送快递到上海");
        System.out.println("处理自己的业务");

        //1 多线程的创建会比较消耗时间和资源
        //2 当要执行的任务比较重时创建多线程才有必要
        //3 要先执行后面的代码就可以创建多线程
        //手动创建线程,雇佣了两个人送快递,同时我也干自己的事
        new Thread(()->{
            System.out.println("送快递到北京");
        }).start();
        new Thread(()->{
            System.out.println("送快递到上海");
        }).start();
        System.out.println("处理自己的业务");

        /**
         * 使用JDK的线程池来送快递
         */
        //创建线程池对象：开了一家快递公司，专门处理送快递的任务
        ThreadPoolExecutor pool=new ThreadPoolExecutor(
                4, //核心线程数:快递公司的正式员工-----线程
                10, //最大线程数: 总员工(正式工+临时工)----线程
                //临时工+空闲时间：正式员工数量不够处理任务时，招聘临时工，临时工超过空闲时间，就解雇
                60, //空闲时间数
                TimeUnit.SECONDS, //时间单位
                new ArrayBlockingQueue<>(1000), //阻塞队列:快递公司的仓库，保存快递包裹
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {//线程的工厂类：快递公司招聘标准————创建线程的方式
                        return newThread(r);
                    }
                },
                //拒绝策略:接收到新快递单,但此时仓库的容量不够存放快递包裹.
//                new ThreadPoolExecutor.AbortPolicy()
                //抛异常的方式 RejectedExecutionException
//                new ThreadPoolExecutor.CallerRunsPolicy()
                //谁把包裹交给我,就让它自己去送(execute代码行自己执行)
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                //把仓库中最旧的包裹丢弃
                new ThreadPoolExecutor.DiscardPolicy()
                //把仓库中最新的包裹丢弃
        );
        //执行任务 execute
        pool.execute(()->{ //创建了一个送快递的任务,把快递包裹交给快递公司
            System.out.println("送快递到北京");
        });
        pool.execute(()->{
            System.out.println("送快递到上海");
        });
        System.out.println("干自己的事");

        //其它创建线程池的方法.
        //单线程池：只有1个正式工，没有临时工，仓库是无边界的
        ExecutorService pool2=Executors.newSingleThreadExecutor();
        //固定大小的线程池：只有给定数量的正式工，没有临时工，仓库是无边界的
        ExecutorService pool3 =Executors.newFixedThreadPool(4);
        //缓存的线程池：只有临时工，没有正式工，临时工数量不限，空闲时间60秒
        ExecutorService pool4=Executors.newCachedThreadPool();
        //计划任务线程池：给定数量的正式工，没有临时工。使用自己的创建线程的方式（ 定时任务线程 ）
        ExecutorService pool5 = Executors.newScheduledThreadPool(4);
    }
}
