package y2022.m08.d17;


import datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：MF
 * @date: 2022/8/17
 */

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int depth = 0;
        while (!d.isEmpty()) {
            int sz = d.size();
            while (sz-- > 0) {
                TreeNode node = d.pollFirst();
                map.put(depth, map.getOrDefault(depth, 0) + node.val);
                if (node.left != null) d.addLast(node.left);
                if (node.right != null) d.addLast(node.right);
            }
            depth++;
        }
        return map.get(depth - 1);
    }

}
