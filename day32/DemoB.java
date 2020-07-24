package day32;

// 给定一个数字n,求2出现的次数.
public class DemoB {
    public int countNumberOf2s(int n) {
        if (n < 0) {
            return 0;
        }
        int round = n, base = 1, weight;
        int cnt = 0;
        while (round > 0) {
            weight = round % 10;
            round /= 10;
            cnt += round * base;
            if (weight == 2) {
                cnt += (n % base) + 1;
            }
            if (weight > 2) {
                cnt += base;
            }
            base *= 10;
        }
        return cnt;
    }
}
