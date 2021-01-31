package chapter1;

import common.InitData;
import common.ListNode;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Section05MiddleOfTheLinkedList {

	public ListNode middleNode(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}
		ListNode fast = head.next.next, slow = head.next;
		while (null != fast && null != fast.next) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Section05MiddleOfTheLinkedList test = new Section05MiddleOfTheLinkedList();
		System.out.println(test.middleNode(InitData.linkedList()).val);
	}

}
