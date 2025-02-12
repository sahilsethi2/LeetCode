class Node {
    String data;
    Node next;
    Node prev;
    Node(String x) {
        data = x;
        next = null;
        prev = null;
    }
}

class BrowserHistory {
    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        newNode.prev = current; // Link back to the current node
        current.next = newNode; // Set next of current node
        current = newNode; // Move to the new node
    }
    
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.data;
    }
    
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.data;
    }
}