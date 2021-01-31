package week2.chapter1;

import java.util.ArrayList;
import java.util.List;

import common.InitData;
import common.TreeNode;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorderTraversal(root, list);
		return list;
	}

	private void preorderTraversal(TreeNode root, List<Integer> list) {
		if (null == root) {
			return;
		}
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal test = new BinaryTreePreorderTraversal();
		System.out.println(test.preorderTraversal(InitData.binaryTree()));
	}

}
