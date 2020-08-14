package D1;

// 5
public class DemoB {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        while (left < right) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            if (array[left] == array[right] && array[left] == array[mid]) {
                int result = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (result > array[i]) {
                        result = array[i];
                    }
                }
            }
            mid = (left + right) / 2;
            if (array[mid] >= array[left]) {
                //说明最小数在中间值左边
                left = mid;
            } else {
                //说明最小数在中间值右边
                right = mid;
            }
        }
        return array[mid];
    }
}
