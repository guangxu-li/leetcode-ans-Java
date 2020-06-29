/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        ListNode headNext = null;
        ListNode prev = null;

        while (head != null) {
            headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }

        return head = prev;
    }
}
// @lc code=end
