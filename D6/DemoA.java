package D6;


import java.util.ArrayList;

//21
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class DemoA {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // result是 结果集
        ArrayList<Integer> list = new ArrayList<>();
        // list是 待选结果
        FindPathDFS(root, target, result, list);
        return result;
    }

    private void FindPathDFS(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        // 将当前值放入 list 待选结果集中
        list.add(root.val);
        target -= root.val;

        // 待选结果是否符合条件, 是就添加到 结果集result 中.
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<>(list));
        }
        // DFS 深度优先
        FindPathDFS(root.left, target, result, list);
        FindPathDFS(root.right, target, result, list);

        // 回溯. (检测 上一个节点 的右子树)
        list.remove(list.size() - 1);
    }
}
