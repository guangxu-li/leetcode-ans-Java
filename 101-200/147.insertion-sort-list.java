/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode();
        h.next = head;
        ListNode sorted = head;
        ListNode node = head.next;
        while (node != null) {
            if (sorted.val <= node.val) {
                sorted = node;
                node = node.next;
                continue;
            }

            ListNode prev = h;
            while (prev.next.val < node.val) {
                prev = prev.next;
            }

            sorted.next = node.next;
            ListNode next = prev.next;
            prev.next = node;
            node.next = next;

            node = sorted.next;
        }

        return h.next;
    }
}
// @lc code=end

