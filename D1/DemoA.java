package D1;

// 1
public class DemoA {
    public boolean Find(int target, int[][] array) {
        int a = 0;    //行
        int b = array[0].length - 1;    //列
        while (a <= array.length - 1 && b >= 0) {
            if (array[a][b] > target) {
                b--;
            }
            else if (array[a][b] < target) {
                a++;
            }else {
                return true;
            }
        }
        return false;
    }
}
