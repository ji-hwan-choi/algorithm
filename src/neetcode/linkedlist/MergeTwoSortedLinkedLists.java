package neetcode.linkedlist;

import java.util.*;

/**
 * 문제 : Merge Two Sorted Linked Lists
 * https://neetcode.io/problems/merge-two-sorted-linked-lists?list=neetcode150
 */
public class MergeTwoSortedLinkedLists {

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

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))));

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println("listNode = " + listNode);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergerNode = new ListNode();
        ListNode tail = mergerNode;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return mergerNode.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        List<Integer> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list);

        ListNode mergeNode = new ListNode();
        ListNode tail = mergeNode;
        for (Integer i : list) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        return mergeNode.next;
    }
}
