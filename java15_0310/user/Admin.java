package java15_0310.user;

import java15_0310.action.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        this.name = name;
        actions = new IAction[] {
                new ExitAction(),
                new AddAction(),
                new DelAction(),
                new FindAction(),
                new DisplayAction()
        };
    }

    @Override
    public int menu() {
        System.out.println("==========================");
        System.out.println(this.name + " 欢迎使用图书馆管理系统, 您是管理员");
        System.out.println(" 1. 新增图书");
        System.out.println(" 2. 删除图书");
        System.out.println(" 3. 查找图书");
        System.out.println(" 4. 显示所有图书");
        System.out.println(" 0. 退出");
        System.out.println("==========================");
        Scanner scanner = new Scanner(System.in);
        int choice =  scanner.nextInt();
        return choice;
    }
}
