package java15_0524;


//优化版本

public class SequencePrint1 {
    private static void print2(){
        //注意 i<Print2.ARRAY.length 要用Print2. 操作才能访问到数组
        for(int i=0;i<Print2.ARRAY.length;i++){
            new Thread(new Print2(i)).start();
        }
    }

   private static class Print2 implements Runnable{
        private int index;
        public static String[] ARRAY={"A","B","C","D","E"};
        private static  int INDEX;

        public Print2(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                for(int i=0;i<10;i++){
                    synchronized (ARRAY){

                        //注意此处使用while进行判断
                       while (index!=INDEX){
                            ARRAY.wait();
                        }
                        System.out.print(ARRAY[index]);
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
