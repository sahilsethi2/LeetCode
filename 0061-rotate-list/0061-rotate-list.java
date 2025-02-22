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
    ListNode findNthNode(ListNode temp, int k){
        int cnt = 1;
        while(temp!=null){
            if(cnt==k) return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0) return head;
        ListNode temp = head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        if(k%count == 0) return head;

        k = k%count;

        temp.next = head;
        ListNode newLastNode = findNthNode(head, count-k);

        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }
}