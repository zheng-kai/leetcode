package leetcode25;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int count = 0;
        ListNode lastGroupHead = null;
        ListNode lastNode = null;
        ListNode groupHead = null;
        ListNode groupTail = null;
        ListNode newHead = head;
        while (head != null) {
            count++;
            ListNode next = head.next;
            head.next = lastNode;
            if (count % k == 1) {
                groupHead = head;
            }
            if (count % k == 0) {
                if (count == k) {
                    newHead = head;
                }
                groupTail = head;
                if (lastGroupHead != null) {
                    lastGroupHead.next = groupTail;
                }
                lastGroupHead = groupHead;
                groupHead = null;
            }
            lastNode = head;
            head = next;
        }
        if (lastGroupHead != null) {
            lastGroupHead.next = groupHead;
        }
        ListNode node = lastNode;
        lastNode = null;
        while (count % k > 0) {
            count--;
            ListNode next = node.next;
            node.next = lastNode;
            lastNode = node;
            node = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        int[] arr = new int[]{1, 2,3,4,5};
        for (int i : arr) {
            listNode.next = new ListNode();
            listNode = listNode.next;
            listNode.val = i;
        }
        Solution solution = new Solution();
        ListNode node = solution.reverseKGroup(head.next, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}