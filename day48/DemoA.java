package day48;

public class DemoA {
    public int findMaxGap(int[] A, int n) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) max = A[i];
        }
        int ans1 = max - A[0];
        int ans2 = max - A[n - 1];
        if (ans1 > ans2)
            return ans1;
        else
            return ans2;
    }
}
