package leetcode19;


import java.util.HashMap;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        ListNode node = newHead;

        while (node != null) {
            map.put(i++, node);
            node = node.next;
        }
        int index = i - n;
        ListNode pre = map.get(index - 1);
        node = map.get(index);

        pre.next = node.next;
        return newHead.next;
    }
}