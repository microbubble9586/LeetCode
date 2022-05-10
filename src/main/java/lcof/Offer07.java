package lcof;

import java.util.HashMap;

public class Offer07 {
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int left, int right) {
        if (left > right) {
            // 递归终止
            return null;
        }
        // 建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 划分根节点、左子树、右子树
        int i = map.get(preorder[root]);
        // 开启左子树递归
        node.left = recur(root + 1, left, i - 1);
        // 开启右子树递归
        node.right = recur(root + i - left + 1, i + 1, right);
        // 回溯返回根节点
        return node;
    }
}
