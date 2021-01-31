package week2.chapter1;

import java.util.ArrayList;
import java.util.List;

import common.InitData;
import common.TreeNode;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderTraversal(root, list);
		return list;
	}

	private void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
	}

	public static void main(String[] args) {
		BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
		System.out.println(test.inorderTraversal(InitData.binaryTree()));
	}

}
