import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> vals = new ArrayList<>();

        for (ListNode l : lists) {
            while (l != null) {
                vals.add(l.val);
                l = l.next;
            }
        }

        Collections.sort(vals);

        ListNode head = new ListNode(-1);
        ListNode h = head;

        for (int i : vals) {
            h.next = new ListNode(i);
            h = h.next;
        }

        h.next = null;
        return head.next;
    }
}
// @lc code=end
