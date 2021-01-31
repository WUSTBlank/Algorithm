package chapter1;

import common.InitData;
import common.ListNode;

/**
 * @author Sharon
 * @date 2021-01-29
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Section05LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Section05LinkedListCycle test = new Section05LinkedListCycle();
		System.out.println(test.hasCycle(InitData.cycleLinkedList()));
		System.out.println(test.hasCycle(InitData.linkedList()));
	}

}
