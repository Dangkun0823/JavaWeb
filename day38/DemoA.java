package day38;

// 找公共节点
public class DemoA {
    public int getLCA(int a, int b) {
        while (a!=b){
            if(a>b){
                a/=2;
            }else {
                b/=2;
            }
        }
        return a;
    }
}
