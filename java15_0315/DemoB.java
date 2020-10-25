package java15_0315;

import java.util.Scanner;

public class DemoB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //关闭scanner对应的流对象，此处对应的应该是System.in这个对象
        //鼠标放在在try关键字alt+enter也会把上面的代码变成下面的(说明下面的代码更好）
        try {
            //执行一些正常逻辑
            int num=scanner.nextInt();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }

        //这个代码中当try catch执行完毕时，就会自动执行try() 中对象的close方法
//        try(Scanner scanner=new Scanner(System.in)) {
//            int num=scanner.nextInt();
//            System.out.println(num);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
