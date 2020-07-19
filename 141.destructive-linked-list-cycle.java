/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode();

        while (head != null) {
            if (head == dummyHead) {
                return true;
            }

            ListNode next = head.next;
            head.next = dummyHead;
            head = next;
        }

        return false;
    }
}
// @lc code=end

