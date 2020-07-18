package day28;

import java.util.Scanner;

//密码验证合格程序.
//1.长度超过8位
//2.包括大小写字母.数字.其它符号,以上四种至少三种
//3.不能有相同长度大于等于2的子串重复
public class DemoB {
    public static boolean checkLength(String password) {
        if (password == null || password.length() <= 8) return false;
        return true;
    }

    public static boolean checkCharKinds(String password) {
        int Digit = 0, lowercase = 0, uppercase = 0, others = 0;
        char[] ch = password.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                Digit = 1;
                continue;
            } else if (ch[i] >= 'a' && ch[i] <= 'z') {
                lowercase = 1;
                continue;
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                uppercase = 1;
                continue;
            } else {
                others = 1;
                continue;
            }
        }
        int total = Digit + lowercase + uppercase + others;
        return total >= 3 ? true : false;
    }

    public static boolean checkCharRepeat(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String substr1 = password.substring(i, i + 3);
            //判断是否包含a中截取的字符串
            if (password.substring(i + 3).contains(substr1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String psw = sc.next();
            if (checkLength(psw) && checkCharKinds(psw) && checkCharRepeat(psw)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}