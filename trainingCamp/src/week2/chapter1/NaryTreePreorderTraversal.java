package week2.chapter1;

import java.util.ArrayList;
import java.util.List;

import common.InitData;
import common.Node;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {

	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<>();
		if (null == root) {
			return list;
		}
		preorder(root, list);
		return list;
	}

	private void preorder(Node root, List<Integer> list) {
		if (null == root) {
			return;
		}
		list.add(root.val);
		if (null != root.children) {
			for (Node node : root.children) {
				preorder(node, list);
			}
		}
	}

	public static void main(String[] args) {
		NaryTreePreorderTraversal test = new NaryTreePreorderTraversal();
		System.out.println(test.preorder(InitData.tree()));
	}

}
