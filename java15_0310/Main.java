package java15_0310;

import java15_0310.book.BookList;
import java15_0310.user.Admin;
import java15_0310.user.NormalUser;
import java15_0310.user.User;

import java.util.Scanner;

public class Main {
    //不使用继承的话就比较麻烦
    public static void main_bak(String[] args) {
//        // 1. 先把数据准备好
//        BookList bookList = new BookList();
//        // 2. 创建用户, 并进行登录
//        // 假如不使用继承的方式, 把两种类型的用户统一在一起, 此时代码就需要比较大的改动
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" 请登录系统!!!!");
//        System.out.println(" 请输入您的姓名: ");
//        String name = scanner.next();
//        System.out.println(" 请输入您的身份: 1 表示管理员, 2 表示普通用户 ");
//        int who = scanner.nextInt();
//        if (who == 1) {
//            Admin admin = new Admin();
//            while (true) {
//                int choice = admin.menu();
//                admin.doAction(choice, bookList);
//            }
//        } else {
//            NormalUser user = new NormalUser(name);
//            while (true) {
//                // 4. 循环内部调用 menu 方法显示用户菜单
//                int choice = user.menu();
//                // 5. 根据用户输入的选项来决定执行哪个 IAction 完成操作
//                user.doAction(choice, bookList);
//            }
//        }
    }

    public static void main(String[] args) {
        // 1. 创建数据
        BookList bookList = new BookList();
        // 2. 用户登陆
        // 此处因为User是抽象类无法直接实例化.
        User user = login();
        // 3. 进入主循环
        // menu 在父类中存在, 在子类中也存在, 就构成了方法重写
        while (true) {
            // menu 在父类中存在, 在子类中也存在, 就构成了方法重写
            int choice = user.menu();
            user.doAction(choice,bookList);
        }
    }

    public static User login() {
        // 提示用户进行登录
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请登录系统!!!!");
        System.out.println(" 请输入您的姓名: ");
        String name = scanner.next();
        System.out.println(" 请输入您的身份: 1 表示管理员, 2 表示普通用户 ");
        int who = scanner.nextInt();
        if (who == 1) {
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }
}
