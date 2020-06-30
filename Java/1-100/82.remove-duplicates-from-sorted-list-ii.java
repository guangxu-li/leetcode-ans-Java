/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (head != null && head.next != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }

            if (prev.next == head) {
                prev = head;
            } else {
                prev.next = head.next;
            }
            head = head.next;
        }

        return dummyHead.next;
    }
}
// @lc code=end

