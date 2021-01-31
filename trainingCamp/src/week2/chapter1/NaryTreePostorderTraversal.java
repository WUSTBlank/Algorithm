package week2.chapter1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.InitData;
import common.Node;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {

	public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<>();
		if (null == root) {
			return list;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		postorder(root, list);
		return list;
	}

	private void postorder(Node root, List<Integer> list) {
		if (null != root.children) {
			for (Node node : root.children) {
				postorder(node, list);
			}
		}
		list.add(root.val);
	}

	public static void main(String[] args) {
		NaryTreePostorderTraversal test = new NaryTreePostorderTraversal();
		System.out.println(test.postorder(InitData.tree()));
	}

}
