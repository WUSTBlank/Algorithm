package chapter1.Section04;

import java.util.LinkedList;
import java.util.Queue;

import common.InitData;
import common.TreeNode;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return depth + 1;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
        System.out.println(test.minDepth(InitData.binaryTree()));
    }

}
