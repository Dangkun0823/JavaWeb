package day33DP;

public class DemoB1 {
    // 斐波那契数列的非递归
    int Fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int last2 = 1;    // 第i-2项
        int last1 = 1;    // 第i-1项
        int cur = 0;      // 当前项
        for (int i = 3; i <= n; i++) {
            cur = last1 + last2;     // 每次循环都要更新 前一项与前两项的值
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }

    // 阶乘的非递归
    int Fac(int num) {
        int k = 1;
        while (num > 0) {
            k *= num;
            num--;
        }
        return k;
    }

    //错排(错位排序)算法. 计算概率问题时可以使用.
    public static float count(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return (n - 1) * (count(n - 1) + count(n - 2));
        }
    }
}
