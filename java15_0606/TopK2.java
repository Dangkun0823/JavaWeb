package oj;


//快速排序思想.
public class TopK2 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return search(a,0,a.length-1,K);
    }
    private int search(int[] a, int left, int right, int K){
        int i = left;
        int j = right;

        int base = a[i];
        while(i < j){
            while(i<j && base<a[j])
                j--;
            if(i<j)
                a[i++] = a[j];
            while(i<j && base>a[i])
                i++;
            if(i<j)
                a[j--] = a[i];
        }
        a[i] = base;
        if(a.length - K == i)//// 第K大 就是递增序列从后向前数第K个位置的数
            return a[i];
        else if(i > a.length - K)
            return search(a,left,i-1,K);
        else
            return search(a,i+1,right,K);
    }
}
