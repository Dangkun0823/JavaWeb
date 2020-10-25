package java15_0315;

public class Test {
    public static void main(String[] args) {
        //这种ip地址的表示方法为“点分十进制”
        //.在正则表达式是一种特殊符号，需进行转义（两个\\，一个是Java中进行转义，一个是在正则中进行转义)
        //这种转义是大坑，java13已经修复了
//        String str="192.168.1.0";
//        String[] result=str.split("\\.");
//        for(String x:result){
//            System.out.println(x);
//        }
//        String str="name=zhangsan&age=18&sex=male";
//        //1.先按照&切分
//        String[] result=str.split("&");
//        for(String tmp:result){
//            //2.再按照=进行切分
//            String[] tokens=tmp.split("=");
//            if(tokens.length!=2){
//                continue;
//            }
//            System.out.println(tokens[0]+": "+tokens[1]);
//        }

//        String string="hello world";
//        System.out.println(string.substring(5));
//        //[beg,end] 前闭后开区间
////        System.out.println(string.substring(5,7));

//        String str="      hello world    ";
//        System.out.println("["+str.trim()+"]");

//        String string="hello world";
//        System.out.println(string.toUpperCase());
//        System.out.println(string.toLowerCase());
//        //如何让一个字符串首字母大写，其他字母小写
//        //先处理首字母
//        String result= string.substring(0,1).toUpperCase()+string.substring(1).toLowerCase();
//        System.out.println(result);

//        String str=null;
//        System.out.println(str.isEmpty());
//        String s="hello";
//        s+="x";
//        System.out.println(s);

        //写代码时变量名尽量不要使用缩写
        //StringBuilder是可变对象，append拼接字符串的时候修改对象本身
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append("hello");
//        stringBuilder.append("x");
//        stringBuilder.append("x");
//        stringBuilder.append("x");
//        stringBuilder.append("x");

        //stringBuilder.append支持链式调用方法（支持链式调用核心在于append返回值是this）
//        stringBuilder.append("hello").append("x").append("x").append("x").append("x");
//        System.out.println(stringBuilder);

        //逆置一个字符串
//        StringBuilder stringBuilder=new StringBuilder("abcd");
//        stringBuilder.reverse().reverse();
//        System.out.println(stringBuilder);

//        //插入操作
//        StringBuilder stringBuilder=new StringBuilder("abcd");
//        stringBuilder.insert(1,"hehe");
//        System.out.println(stringBuilder);

        //删除操作
//        StringBuilder stringBuilder=new StringBuilder("abcd");
//        stringBuilder.delete(1,2);
//        System.out.println(stringBuilder);

        //针对String往下标为1的地方插入一个hehe
//        String str="abcd";
//        String result=str.substring(0,1)+"hehe"+str.substring(1);
//        System.out.println(result);

        //针对String删除[1,2)范围内的内容
//        String str="abcd";
//        String result=str.substring(0,1)+str.substring(2);
//        System.out.println(result);

    }
}
