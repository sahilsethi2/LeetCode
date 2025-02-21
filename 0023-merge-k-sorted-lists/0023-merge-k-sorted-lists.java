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
    ListNode convert(List<Integer> arr){
        if(arr==null || arr.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(arr.get(0));
        ListNode temp = head;
        for (int i = 1; i < arr.size(); i++){
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];
            while(temp!=null){
                arr.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(arr);
        ListNode head = convert(arr);
        return head;
    }
}