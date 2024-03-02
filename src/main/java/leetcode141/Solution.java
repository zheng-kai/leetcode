package leetcode141;

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
    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        ListNode next = head;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
            if (node == head) {
                return true;
            }
        }
        return false;
    }
}
// 快慢指针
//public class Solution {
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }
//}

