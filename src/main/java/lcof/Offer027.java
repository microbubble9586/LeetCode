package lcof;

public class Offer027  {
    public static TreeNode mirrorTree(TreeNode root) {
        if (root ==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
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
        TreeNode mirrorTree = mirrorTree(root);
        System.out.println(mirrorTree);
    }
}
