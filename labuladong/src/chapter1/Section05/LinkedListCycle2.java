package chapter1.Section05;

import common.InitData;
import common.ListNode;

/**
 * @author Sharon
 * @date 2021-01-29 https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        LinkedListCycle2 test = new LinkedListCycle2();
        System.out.println(test.detectCycle(InitData.cycleLinkedList()).val);
    }

}
