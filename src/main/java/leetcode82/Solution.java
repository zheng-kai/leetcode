package leetcode82;

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode node = head;
        ListNode pre = newHead;
        ListNode lastNode = pre;
        ListNode newNode = node;
        while (true) {

            if (node == null || pre.val != node.val) {
                if (newNode != pre) {
                    lastNode.next = node;
                    newNode = node;
                } else {
                    newNode = node;
                    lastNode = pre;
                }

            }
            if (node == null) {
                break;
            }
            pre = node;
            node = node.next;
        }
        return newHead.next;
    }
}