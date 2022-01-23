package my_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ToTheNodePath {
    private boolean flag = false;


//    private static TreeNode createTreePreOrder(int i, List<Integer> list) {
//        if(i >= list.size()) {
//            return null;
//        }
//        Integer num = list.get(i);
//        if(num == null) {
//            return null;
//        }
//        TreeNode node = new TreeNode(num);
//        node.left = createTreePreOrder(i+1, list);
//        node.right = createTreePreOrder(i+1, list);
//    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);list.add(5);list.add(1);list.add(6);
        list.add(2);list.add(0);list.add(8);list.add(null);
        list.add(null);list.add(7);list.add(4);

//        ToTheNodePath toTheNodePath1 = new ToTheNodePath();
//        ToTheNodePath toTheNodePath2 = new ToTheNodePath();
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(9);
//        root.right.left.right = new TreeNode(5);
//        root.right.left.right.left = new TreeNode(51);
//        root.right.left.right.right = new TreeNode(53);
//        root.right.left.right.right.left = new TreeNode(45);
//        root.right.left.right.right.right = new TreeNode(68);
//        TreeNode p = root.right.left.right.left; // 51
//        TreeNode q = root.right.right;//left.right.right.right;  // 68 , 9
//        System.out.println(p.val);
//        Deque<TreeNode> stack1 = new ArrayDeque<>();
//        toTheNodePath1.getPath(root, p, stack1);
//        while(!stack1.isEmpty()) {
//            System.out.print(stack1.pop().val + " ");
//        }
//        System.out.println();
//        System.out.println(q.val);
//        Deque<TreeNode> stack2 = new ArrayDeque<>();
//        toTheNodePath2.getPath(root, q, stack2);
//        while(!stack2.isEmpty()) {
//            System.out.print(stack2.pop().val + " ");
//        }
//        System.out.println();
    }

    private boolean getPath(TreeNode root, TreeNode node, Deque<TreeNode> stack) {
        if(root == null) {
            return false;
        }
        stack.push(root);
        System.out.println("过程: " + root.val);
        if(root == node) {
            return true;
        }
        boolean isExist = getPath(root.left, node, stack) || getPath(root.right, node, stack);
        if(!isExist) {
            stack.pop();
        }
        return isExist;
    }
}
