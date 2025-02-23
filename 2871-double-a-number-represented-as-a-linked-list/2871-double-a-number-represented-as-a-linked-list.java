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
    public ListNode doubleIt(ListNode head) {
        if (head == null) return null;
        
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }
        
        int carry = 0;
        
        while (!st.isEmpty()) {
            ListNode node = st.pop();
            int newVal = node.val * 2 + carry;
            node.val = newVal % 10;
            carry = newVal / 10;
        }
        
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        
        return head;
    }
}
