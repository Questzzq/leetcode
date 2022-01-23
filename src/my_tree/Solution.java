package my_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        boolean f = isSymmetric(root);
        System.out.println(f);
    }

    public static boolean isSymmetric(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) {
            return true;
        }
        inOrder(root, list);
        int l = 0;
        int r = list.size()-1;
        while(l<=r) {
            if(list.get(l)!=list.get(r)) {
                return false;
            } else{
                l++;
                r--;
            }
        }
        return true;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if(root==null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
