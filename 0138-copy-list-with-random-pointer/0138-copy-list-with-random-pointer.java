/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node temp = head;
        while(temp!=null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp!=null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }

        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        temp = head;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }

        return dummyNode.next;









        // Node temp = head;
        // HashMap<Node, Node> map = new HashMap<>();
        // while (temp != null){
        //     Node newNode = new Node(temp.val);
        //     map.put(temp, newNode);
        //     temp = temp.next;
        // }
        // temp = head;
        // while (temp != null){
        //     Node copyNode = map.get(temp);
        //     copyNode.next = map.get(temp.next);
        //     copyNode.random = map.get(temp.random);
        //     temp = temp.next;
        // }
        // return map.get(head);
    }
}