   //reverse k nodes and leave next k nodes
    public Node reversealternateknodes(Node head,int k){
        if(head==null || k<=1){
            return head;
        }
        Node prev=null;
        Node current=head;
        while(true) {
            Node last=prev;
            Node newEnd=current;
            Node next=current.next;
            for (int i = 0; current!=null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if(next!=null){
                    next = next.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }
            else{
                head=prev;
            }
            newEnd.next=current;
            for(int i=0;current!=null && i<k;i++){
                prev=current;
                current=current.next;

            }
            if(current==null){
                break;
            }
        }
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
        list.insertLast(7);
        list.insertLast(8);
        list.display(list.head);
        list.head=list.reversealternateknodes(list.head,2);
        list.display(list.head);
}
/*Output:-1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> End
2 -> 1 -> 3 -> 4 -> 6 -> 5 -> 7 -> 8 -> End
Conclusion:-This Java program implements a linked list reversal algorithm that reverses every k nodes and leaves the next k nodes unchanged. 
The solution is optimized for O(N) time complexity and O(1) space complexity.
Key Features:
# Reverses k nodes and skips the next k nodes
# Handles edge cases (e.g., list length not a multiple of 2k, k > remaining nodes)
# Uses an iterative approach with efficient pointer manipulation
# Maintains proper connections between reversed and non-reversed segments
*/
