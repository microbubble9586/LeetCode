package lcof;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer032_2 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0 ; i--) {
                TreeNode node = deque.pollFirst();
                tmp.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            list.add(tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(5);
        TreeNode l4 = new TreeNode(7);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(6);
        TreeNode r4 = new TreeNode(8);
        l2.left = l4;
        l2.right = r4;
        l1.left = l2;
        l1.right = r2;
        r1.left =  l3;
        r1.right = r3;
        root.left = l1;
        root.right = r1;
        System.out.println(levelOrder(root));
    }
}
