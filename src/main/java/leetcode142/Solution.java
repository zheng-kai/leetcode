package leetcode142;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2 != null) {
            n1 = n1.next;
            n2 = n2.next;
            if (n2 != null) {
                n2 = n2.next;
            }
            if (n1 == n2) {
                break;
            }
        }
        if (n1 != n2 || n2 == null) {
            return null;
        }
        while (head != n1) {
            head = head.next;
            n1 = n1.next;
        }
        return head;
    }
}