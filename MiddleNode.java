//Middle Node of Linked List
public Node middle(Node head){
       Node f=head;
       Node s=head;
       while(f!=null && f.next!=null){
           f=f.next.next;
           s=s.next;
       }
       return s;
}
public static void main(String[] args) {
   LinkedList list=new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
  Node middleNode=list.middle(list.head);
        System.out.println(middleNode.value);
    }
/* Output:- 3
Conclusion for Middle Node of Linked List:-
This program efficiently finds the middle node of a singly linked list using the slow and fast pointer approach.
Key Highlights:
# Uses two-pointer technique to traverse the list in a single pass (O(n)).
# Works correctly for both even and odd-length lists:
Returns the middle node for an odd-length list.
Returns the second middle node for an even-length list.
# Handles edge cases, such as single-node lists and empty lists.
This approach ensures an optimal and space-efficient solution while keeping the implementation simple and readable.
*/
