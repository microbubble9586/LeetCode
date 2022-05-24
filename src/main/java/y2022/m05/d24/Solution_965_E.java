package y2022.m05.d24;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution_965_E {
    //递归方法与非递归方法
//    int val = -1;
//    public boolean isUnivalTree(TreeNode root) {
//        if (val == -1) val = root.val;
//        if (root == null) return true;
//        if (root.val != val) return false;
//        return isUnivalTree(root.left) && isUnivalTree(root.right);
//    }
    public boolean isUnivalTree(TreeNode root) {
        if (root.left == null & root.right == null) {
            return true;
        }
        int value = root.val;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (value != node.val) {
                return false;
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return true;
    }
}
