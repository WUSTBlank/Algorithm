package chapter1.Section05;

import common.InitData;
import common.ListNode;

/**
 * @author Sharon
 * @date 2021-01-29 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

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
        MiddleOfTheLinkedList test = new MiddleOfTheLinkedList();
        System.out.println(test.middleNode(InitData.linkedList()).val);
    }

}
