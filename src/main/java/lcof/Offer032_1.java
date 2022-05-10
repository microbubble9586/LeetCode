package lcof;


import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Offer032_1 {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root ==null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if (node.left!=null){
                deque.addLast(node.left);
            }
            if (node.right!=null){
                deque.addLast(node.right);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}
