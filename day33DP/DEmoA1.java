package day33DP;

//股市问题：https://www.nowcoder.com/questionTerminal/9370d298b8894f48b523931d40a9a4aa
//动态规划
public class DEmoA1 {
    public int calculateMax(int[] prices) {
        int fb = Integer.MAX_VALUE;   // 第一次买入最好的价格，越低越好
        int fs = 0;                   // 第一次卖出后的最高收益，越高越好
        int sb = Integer.MIN_VALUE;   // 第二次买入时还剩余的最高收益，越高越好
        int ss = 0;                   // 第二次卖出时总的最高收益，越高越好
        for (int price : prices) {
            fb=Math.min(fb,price);
            fs=Math.max(fs,price-fb);
            sb=Math.max(sb,fs-price);
            ss=Math.max(ss,sb+price);
        }
        return ss;
    }
}
