/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
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
    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode intersect = getIntersect(head);

        if (intersect == null) {
            return null;
        }

        while (head != intersect) {
            head = head.next;
            intersect = intersect.next;
        }

        return head;
    }
}
// @lc code=end

