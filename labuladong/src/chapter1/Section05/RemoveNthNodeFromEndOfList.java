package chapter1.Section05;

import common.InitData;
import common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author Sharon
 * @date 2021-01-31
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualHead = new ListNode(-1, head);
        while (n-- > 0) {
            head = head.next;
        }
        ListNode beforeDelete = virtualHead;
        while (head != null) {
            head = head.next;
            beforeDelete = beforeDelete.next;
        }
        beforeDelete.next = beforeDelete.next.next;
        return virtualHead.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode node = InitData.linkedList();
        System.out.println(InitData.linkedListToString(node));
        node = test.removeNthFromEnd(InitData.linkedList(), 5);
        System.out.println(InitData.linkedListToString(node));
    }

}
