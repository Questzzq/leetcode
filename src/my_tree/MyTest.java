package my_tree;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, new ArrayList<>());
        for(List<Integer> li: list) {
            for(Integer i: li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        boolean flag = false;
        int sum = 0;
        dfs1(root, flag, targetSum, sum);
        return flag;
    }

    private static void dfs1(TreeNode root, boolean flag, int target, int sum) {
        if(root != null && !flag) {
            sum += root.val;
            if(root.left == null && root.right == null && target == sum) {
                flag = true;
                System.out.println(sum);
            }
            dfs1(root.left, flag, target, sum);
            dfs1(root.right, flag, target, sum);
            sum -= root.val;
        }
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, List<Integer> path) {
        if(root != null) {
            path.add(root.val);
            if(root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
            }
            dfs(root.left, res, path);
            dfs(root.right, res, path);
            path.remove(path.size()-1);
        }
    }
}
