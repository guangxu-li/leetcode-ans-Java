/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int size = 1; /* size of list */
        ListNode tail = head;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }

        int K = size - k % size;

        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        prev.next = head;

        while (K % size != 0) {
            prev = head;
            head = head.next;
            K--;
        }

        prev.next = tail.next; /* null */
        tail.next = dummyHead.next;

        return head;
    }
}
// @lc code=end

