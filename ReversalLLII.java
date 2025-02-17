    // Reversal Linked List II
    public void reversal2(int l,int r) {
        if (head == null || l == r) {
            return;
        }
        Node prev = null;
        Node pres = head;
        Node next = null;
        Node last = null;
        if (l > 1) {
            last = head;
            for (int i = 1; i < l - 1 && last != null; i++) {
                last = last.next;
            }
        }
        Node newEnd = (l == 1) ? head : last.next;
        pres = newEnd;
        next = (pres != null) ? pres.next : null;
        for (int i = l; i <= r && pres != null; i++) {
            next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
        }
        if (l > 1) {
            last.next = prev;
        } else {
            head = prev;
        }

        if (newEnd != null) {
            newEnd.next = pres;
        }
    }
 public static void main(String[] args) {
   LinkedList list=new LinkedList();
   list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.display();
        list.reversal2(2,4);
        list.display();
 }
/*Output:-1 -> 2 -> 3 -> 4 -> 5 -> End
1 -> 4 -> 3 -> 2 -> 5 -> End
Conclusion:-This implementation of Reversal of a Sublist in a Singly Linked List reverses the elements between two given positions l and r in-place.
The algorithm efficiently modifies the list without using extra space, achieving a time complexity of O(n) where n is the length of the list. 
The solution ensures that the reversed sublist is properly reconnected to the rest of the list, and handles edge cases such as when l == 1.
This approach provides an optimal solution for modifying a linked list, showcasing fundamental linked list operations such as traversal, node reversal, and reconnection.
*/


  
