package hot100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class Solution_94 {
    //非递归中序遍历为什么要这么写啊
    //我之前写的为什么超出内存限制？？？
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node= node.right;
        }
        return ans;
//        while(root!=null||!stack.isEmpty()){
//            while (root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            ans.add(root.val);
//            root = root.right;
//        }
//        return ans;
    }
}
