import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        for (ListNode list : lists) {
            while (list != null) {
                vals.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(vals);

        ListNode head = new ListNode();
        ListNode h = head;
        for (int val : vals) {
            h.next = new ListNode();
            h = h.next;
            h.val = val;
        }

        return head.next;
    }
}
// @lc code=end
