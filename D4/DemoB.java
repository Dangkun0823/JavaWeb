package D4;

//20
public class DemoB {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return BSTHelp(sequence, 0, sequence.length - 1);
    }

    public boolean BSTHelp(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int i = 0;
        while (i < end && sequence[i] < root) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        return BSTHelp(sequence, 0, i - 1) && BSTHelp(sequence, i, end - 1);
    }
}
