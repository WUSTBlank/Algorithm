package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon
 * @date 2021-01-28
 */
public class InitData {

    public static TreeNode binaryTree() {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(4, null, node1);
        TreeNode node3 = new TreeNode(2, node2, null);
        TreeNode node4 = new TreeNode(5, null, null);
        TreeNode node5 = new TreeNode(6, null, null);
        TreeNode node6 = new TreeNode(3, node4, node5);
        return new TreeNode(1, node3, node6);
    }

    public static TreeNode binarySearchTree() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3, null, node1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2, node3, node2);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, null, node5);
        return new TreeNode(5, node4, node6);
    }

    public static TreeNode fullBinaryTree() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1, node1, node2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node4, node5);
        return new TreeNode(5, node3, node6);
    }

    public static TreeNode completeBinaryTree() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1, node1, node2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6, node4, null);
        return new TreeNode(5, node3, node6);
    }

    public static Node tree() {
        Node node1 = new Node(5);
        Node node2 = new Node(6);
        List<Node> nodes1 = new ArrayList<>();
        nodes1.add(node1);
        nodes1.add(node2);
        Node node3 = new Node(3, nodes1);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        List<Node> nodes2 = new ArrayList<>();
        nodes2.add(node3);
        nodes2.add(node4);
        nodes2.add(node5);
        return new Node(1, nodes2);
    }

    public static ListNode linkedList() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        return new ListNode(1, node2);
    }

    public static ListNode cycleLinkedList() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node2;
        return node1;
    }

    public static String linkedListToString(ListNode head) {
        StringBuilder sbf = new StringBuilder();
        if (head != null) {
            sbf.append(head.val);
            head = head.next;
        }
        while (head != null) {
            sbf.append("->").append(head.val);
            head = head.next;
        }
        return sbf.toString();
    }

}
