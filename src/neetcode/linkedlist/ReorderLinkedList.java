package neetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 : Reorder Linked List
 * https://neetcode.io/problems/reorder-linked-list?list=neetcode150
 */
public class ReorderLinkedList {

    public static class ListNode {
        int val;
        private ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10)))));
        reorderList(node);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode reverseNode = reverse(slow);

        merge(head, reverseNode);
    }

    private static ListNode reverse(ListNode node) {
        ListNode head = null;
        ListNode current = node;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = head;
            head = current;
            current = nextTemp;
        }
        return head;
    }

    private static void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;

            if (l1_next == null) {
                break;
            }

            l2.next = l1_next;

            l1 = l1_next;
            l2 = l2_next;
        }

    }

    public static void reorderList2(ListNode head) {

        ListNode headBack = head;
        List<Integer> list = new ArrayList<>();
        while (headBack != null) {
            list.add(headBack.val);
            headBack = headBack.next;
        }

        ListNode temp = new ListNode();
        ListNode tail = temp;
        int size = list.size();
        int index = 0;
        int minusValue = 1;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {

                tail.next = new ListNode(list.get(index));
                index++;
            } else {

                tail.next = new ListNode(list.get(size - minusValue));
                minusValue++;
            }

            tail = tail.next;
        }

        head.val = temp.next.val;
        head.next = temp.next.next;
    }
}
