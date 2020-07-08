package day16;
//        源二叉树
//           8
//         /   \
//        6    10
//      / \   /  \
//     5   7 9   11
//       镜像二叉树
//          8
//        /   \
//       10    6
//      / \   / \
//     11  9 7   5
//  镜像二叉树: 递归操作.
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class DemoB {
    public void Mirror(TreeNode root) {
        // 节点为null时不处理.
        if (root == null) {
            return;
        }
        // 即节点为叶子节点时,同样不处理.
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
