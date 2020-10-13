/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode sp = headA;
        ListNode lp = headB;

        while (lp.next != null && sp.next != null) {
            lp = lp.next;
            sp = sp.next;
        }

        ListNode s = headA;
        ListNode l = headB;

        if (sp.next != null) {
            s = headB;
            l = headA;

            ListNode tmp = sp;
            sp = lp;
            lp = tmp;
        }

        sp = lp.next;
        lp = l;
        while (sp != null) {
            lp = lp.next;
            sp = sp.next;
        }

        sp = s;
        while (sp != null && lp != null) {
            if (sp == lp) {
                return sp;
            }

            sp = sp.next;
            lp = lp.next;
        }

        return null;
    }
}
// @lc code=end

