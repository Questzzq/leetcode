package my_tree;

import java.util.*;

// [3,9,20,null,null,15,7],
public class MyTreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> list = getNums(root);
        for(List<Integer> li: list) {
            for(Integer i: li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(list.size());
        System.out.println(getDepth(root));
    }

    private static int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
    }

    private static List<List<Integer>> getNums(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        if(root == null) {
            return list;
        }
        queue.offer(root);
        TreeNode cur;
        while(!queue.isEmpty()) {
            while(!queue.isEmpty()) {
                cur = queue.peek();
                queue.remove();
                if(cur!=null) {
                    tmpQueue.offer(cur);
                    tmpList.add(cur.val);
                }
            }
            while(!tmpQueue.isEmpty()) {
                TreeNode p = tmpQueue.peek();
                tmpQueue.remove();
                queue.offer(p.left);
                queue.offer(p.right);
            }
            if(!tmpList.isEmpty()) {
                list.add(new ArrayList<>(tmpList));
                tmpList.clear();
            }
        }
        return list;
    }
}
