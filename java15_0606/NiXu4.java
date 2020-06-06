package oj;

public class NiXu4 {
    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
       int[] arr={9,5,2,7};
        System.out.println(count(arr,4));
    }
}
