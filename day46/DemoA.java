package day46;

public class DemoA {
    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        if (n == 0) return 0;
        int max = array[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] == max) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                max = array[i];
                cnt = 1;
            }
        }
        cnt=0;
        for(int i=0;i<n;i++){
            if(array[i]==max){
                cnt++;
            }
            if(cnt*2>n){
                return max;
            }
        }
        return 0;
    }
}
