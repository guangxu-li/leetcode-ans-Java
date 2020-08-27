/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        ListNode h = head;
        int size = 0;
        while (h != null) {
            size++;
            h = h.next;
        }

        int mid = size / 2;
        h = head;
        ListNode prev = null;
        while (mid-- > 0) {
            ListNode next = h.next;
            h.next = prev;
            prev = h;
            h = next;
        }

        if (size % 2 == 1) {
            h = h.next;
        }

        while (h != null && prev != null) {
            if (h.val != prev.val) {
                return false;
            }

            h = h.next;
            prev = prev.next;
        }

        return true;
    }
}
// @lc code=end

