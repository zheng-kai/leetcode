package leetcode92;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode pre = null;
        int count = 1;
        ListNode subHead = null;
        ListNode subTail = null;
        ListNode h = null;
        ListNode t = null;
        while (node != null) {
            if (count == left - 1) {
                subHead = node;
            }
            if (count == right + 1) {
                subTail = node;
                break;
            }
            if (count == left) {
                h = node;
            }
            if (count == right) {
                t = node;
            }
            if (count >= left && count <= right) {
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            } else {
                node = node.next;
            }
            count++;
        }
        if (subHead != null) {
            subHead.next = t;
        }
        if (h != null) {
            h.next = subTail;
        }
        if (subHead == null) {
            return t;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode();
        ListNode node = h;
        int[] values = new int[]{1, 2, 3, 4, 5};
        for (int value : values) {
            node.next = new ListNode();
            node = node.next;
            node.val = value;
        }
        Solution s = new Solution();
        ListNode head = s.reverseBetween(h.next, 2, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}