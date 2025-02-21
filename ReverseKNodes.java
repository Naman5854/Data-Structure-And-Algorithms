 // reverse k nodes
    public Node reverseknodes(Node head,int k){
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
            if(current==null){
                break;
            }
            prev=newEnd;
        }
        return head;
    }
 public void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value +" -> ");
            temp=temp.next;
        }
        System.out.println("End");
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
        list.display(list.head);
        list.head=list.reverseknodes(list.head,3);
        list.display(list.head);
}
/*Output:-1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> End
3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> End
Conclusion:-The reverseKNodes method successfully reverses nodes in groups of k within a linked list while maintaining an O(N) time complexity and O(1) space complexity. 
The implementation correctly handles edge cases such as when k <= 1 or when the number of nodes is not a multiple of k. 
The test case demonstrates that the function correctly reverses the first two complete groups of three nodes while leaving the remaining node unchanged.
This approach is efficient for applications requiring in-place linked list modifications without using extra memory. 
*/

