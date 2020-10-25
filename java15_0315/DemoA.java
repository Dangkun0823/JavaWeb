package java15_0315;

public class DemoA {
    public static void main(String[] args) {
        try {
            int[] arr={1,2,3};
            //System.out.println(arr[100]);
            String str=null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("捕捉到空指针异常");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("捕捉到数组下标越界异常");
        }finally {
            System.out.println("这是finally中的代码");
            //哪怕try/catch中包含return语句，也能保证finally一定能执行到

        }
        System.out.println("我是一行日志");
        //一旦发生异常程序会中断，就是说一旦发生了前面的数组越界就会中止程序
        //而不会执行下面的代码，也就不会对空指针进行判断
    }
}
