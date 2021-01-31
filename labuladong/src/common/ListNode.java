package common;

/**
 * @author Sharon
 * @date 2021-01-28
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
