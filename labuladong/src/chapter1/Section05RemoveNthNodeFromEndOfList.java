package chapter1;

import common.InitData;
import common.ListNode;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Section05RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode virtualHead = new ListNode(-1, head);
		ListNode beforeRemove = virtualHead;
		for (int i = 1; i < n; i++) {
			beforeRemove = head;
			head = head.next;
		}
		beforeRemove.next = head.next;
		return virtualHead.next;
	}

	public static void main(String[] args) {
		Section05RemoveNthNodeFromEndOfList test = new Section05RemoveNthNodeFromEndOfList();
		ListNode node = InitData.linkedList();
		System.out.println(InitData.linkedListToString(node));
		node = test.removeNthFromEnd(InitData.linkedList(), 1);
		System.out.println(InitData.linkedListToString(node));
	}

}
