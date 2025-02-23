 // rotate list
    public Node rotate(Node head,int k){
        if(head==null || head.next==null || k<1){
            return head;
        }
        Node origlast=head;
        int size=0;
        while(origlast.next!=null) {
            size++;
            origlast=origlast.next;
        }
        size++;
        origlast.next=head;
        Node newLast=head;
        for(int i=0;i<(size-(k%size))-1;i++){
            newLast=newLast.next;
        }
        head=newLast.next;
        newLast.next=null;
        return head;
    }
public static void main(String[] args) {
   LinkedList list=new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.display(list.head);
  Node node=list.rotate(list.head, 3);
        list.display(node);
    }
/*Output:-1 -> 2 -> 3 -> 4 -> 5 -> 6 -> End
4 -> 5 -> 6 -> 1 -> 2 -> 3 -> End
Conclusion:-This Java program demonstrates how to rotate a singly linked list by a given number of positions. The rotate method achieves this by:
# Finding the Length: It traverses the list to determine its size and identifies the last node.
# Making the List Circular: The last node’s next pointer is set to the head, temporarily forming a circular linked list.
# Identifying the New Head: The new last node is found based on the rotation count, and its next pointer becomes the new head.
# Breaking the Loop: The new last node’s next is set to null to restore a singly linked structure.
# The program includes a main method that initializes a linked list, inserts elements, and rotates it by 3 positions. The output confirms that the list is correctly rotated.
This implementation efficiently handles edge cases like an empty list, a single-node list, and rotations greater than the list length.
*/
