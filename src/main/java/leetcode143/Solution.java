package leetcode143;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

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

class Solution {
    public void reorderList(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        ListNode tail = node1;
        ListNode pre = node1;
        ListNode node = node1;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        while (head != tail && pre != tail) {
            ListNode next = head.next;
            ListNode preNext = pre.next;
            head.next = pre;
            pre.next = next;
            head = next;
            pre = preNext;
        }
        tail.next = null;
    }
}