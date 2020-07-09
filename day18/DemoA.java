package day18;

//幂函数.
public class DemoA {
    public static void main(String[] args) {
       int x=0,y=0;
       for(int i=1;i<=30;i++){
           x+=10;
           y=y+(int)Math.pow(2,i-1);
       }
        System.out.println(x+" "+y);
    }
}
