package day39;

// 二维数组打印
public class DemoA {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n * n]; // 新数组
        int index = 0;
        int X = 0, Y = n - 1;
        while (X < n) {
            int x = X;
            int y = Y;
            while (x < n && y < n) {
                res[index++] = arr[x++][y++]; // 新数组赋值
            }
            if (Y > 0) {
                Y--; // 新开始的纵坐标
            } else {
                X++; // 新开始的横坐标
            }
        }
        return res;
    }
}
