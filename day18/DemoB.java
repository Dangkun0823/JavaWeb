package day18;


// 一个字符串数组p中每一个元素是否是字符串s的子串，
// 将字符串数组p中每个元素遍历判断的结果true或者false组成数组返回.
// 定义一个boolean类型的数组来解决.
public class DemoB {
    public boolean[] chkSubStr(String[] p, int n, String s) {
         boolean[] b=new boolean[p.length];
         for(int i=0;i<p.length;i++){
             if(s.contains(p[i])){
                 b[i]=true;
             }else {
                 b[i]=false;
             }
         }
         return b;
    }
}
