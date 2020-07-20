/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode h = head;

        while (left != null || right != null) {
            int x = left == null ? Integer.MAX_VALUE : left.val;
            int y = right == null ? Integer.MAX_VALUE : right.val;

            if (x <= y) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        return head.next;
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
// @lc code=end

