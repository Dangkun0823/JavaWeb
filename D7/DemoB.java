package D7;

//25
public class DemoB {
    public int FindGreatestSumOfSubArray(int[] array) {
        //定义状态  f(i): 以i下标结尾的最大连续子序列的和
        //状态递推  f(i) = max(f(i-1)+array[i], array[i])
        //状态初始化 f(0)=array[0], max=array[0]
        //确立容器 dp[]
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
