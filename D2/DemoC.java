package D2;

//4 根据二叉树的前序和中序构造二叉树
public class DemoC {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode restore(int[] pre, int[] mid) {
        if (pre == null || mid == null) {
            return null;
        }

        return handle(pre, 0, pre.length, mid, 0, mid.length);
    }

    private static TreeNode handle(int[] pre, int begin1, int end1, int[] in, int begin2, int end2) {
        if (begin1 > end1 || end1 >= pre.length || begin1 < 0) {
            return null;
        }

        int val = pre[begin1];
        int mid = begin2;
        for (int i = begin2; i < end2; i++) {
            if (val == in[i]) {
                mid = i;
                break;
            }
        }

        TreeNode result = new TreeNode(val);
        result.left = handle(pre, begin1 + 1, begin1 + (mid - begin2), in, begin2, mid - 1);
        result.right = handle(pre, end1 - (end2 - mid) + 1, end1, in, mid + 1, end2);
        return result;
    }

}
