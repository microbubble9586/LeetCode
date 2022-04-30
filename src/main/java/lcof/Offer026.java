package lcof;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer026 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if (B==null){return false;}
        Deque<TreeNode> deque1 = new ArrayDeque(){{add(A);}};
        while (!deque1.isEmpty()){
            TreeNode node = deque1.pollFirst();
            if (node.left!=null){
                deque1.addLast(node.left);
            }
            if (node.right!=null){
                deque1.addLast(node.right);
            }
            if (node.val== B.val){
                //递归找对应
                res = recur(node,B);
            }
        }
        return res;
    }
    private boolean recur(TreeNode node, TreeNode b) {
        if (b==null){
            return true;
        }
        if (node==null||node.val!=b.val){
            return false;
        }
        return recur(node.left,b.left)&&recur(node.right,b.right);
    }
}
