package common;

/**
 * @author Sharon
 * @date 2021-01-29
 */
public class TreeNode {

	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this(val, null, null);
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
