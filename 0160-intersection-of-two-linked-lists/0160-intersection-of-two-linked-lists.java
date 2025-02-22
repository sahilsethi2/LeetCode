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
        ListNode temp = headA;
        Map<ListNode, Integer> mpp = new HashMap<>();
        while(temp != null){
            mpp.put(temp, 1);
            temp = temp.next;
        }
        temp = headB;

        while(temp != null){
            if(mpp.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
        
        // int lengthA = 0;
        // ListNode tempA = headA;
        // while (tempA != null) {
        //     lengthA++;
        //     tempA = tempA.next;
        // }

        // int lengthB = 0;
        // ListNode tempB = headB;
        // while (tempB != null) {
        //     lengthB++;
        //     tempB = tempB.next;
        // }

        // // Adjust the starting point for the longer list
        // if (lengthA > lengthB) {
        //     int steps = lengthA - lengthB;
        //     for (int i = 0; i < steps; i++) {
        //         headA = headA.next;
        //     }
        // } else {
        //     int steps = lengthB - lengthA;
        //     for (int i = 0; i < steps; i++) {
        //         headB = headB.next;
        //     }
        // }

        // // Traverse both lists until an intersection is found
        // while (headA != null && headB != null) {
        //     if (headA == headB) {
        //         return headA; // Intersection point
        //     }
        //     headA = headA.next;
        //     headB = headB.next;
        // }

        // return null; // No intersection
    }
}
