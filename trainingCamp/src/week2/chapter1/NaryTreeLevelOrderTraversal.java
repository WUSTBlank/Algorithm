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
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (null == root) {
			return result;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if(null != node){
					list.add(node.val);
					if (null != node.children) {
						queue.addAll(node.children);
					}
				}
			}
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		NaryTreeLevelOrderTraversal test = new NaryTreeLevelOrderTraversal();
		System.out.println(test.levelOrder(InitData.tree()));
	}

}
