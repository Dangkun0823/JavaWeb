package day33DP;

// 非递归算法, 空间换时间.
// 小孩一次可以上1阶、2阶、3阶楼梯, 输出n阶楼梯的最多种上法.
public class DemoB {
    public int countWays(int n) {
        // 当n=1 2 3阶楼梯时的最多上法.
        int a = 1;
        int b = 2;
        int c = 4;
        int temp = 0;
        if (n < 1) return 0;
        if (n == 1) return a;
        if (n == 2) return b;
        if (n == 3) return c;
        for (int i = 4; i <= n; i++) {
            temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return temp;
    }
}
