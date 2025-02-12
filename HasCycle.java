public boolean hasCycle(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
            return true; // Cycle detected
        }
    }
    return false; // No cycle
}
/*
This algorithm efficiently detects cycles in a linked list using O(n) time and O(1) space.
It works by having two pointers move at different speeds—if they meet, a cycle exists. 
Otherwise, the list is acyclic.
*/
