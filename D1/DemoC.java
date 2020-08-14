package D1;

// 10
public class DemoC {
    public void reOrderArray(int[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int tmp = array[i];
                int j = i;
                while (j > k) {               //注意判断的条件
                    array[j] = array[j - 1];  //将该奇数之前的内容(偶数序列), 整体后移一个位置
                    j--;
                }
                array[k++] = tmp;
            }
        }
    }
}
