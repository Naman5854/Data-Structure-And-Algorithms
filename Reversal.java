 //Inplace Reversal of Linked List
    public void reverse(){
      if(head==null){
        return;}
        Node prev=null;
        Node pres=head;
        Node next=pres.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
            next=next.next;}
        }
        head=prev;
    }
 public static void main(String[] args) {
     LinkedList list=new LinkedList();
        for(int i=7;i>0;i--){
            list.insertLast(i);
        }
   list.display();
        list.reverse();
        list.display();
}
/*Output:-7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> End
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> End
Conclusion:-The given Java program demonstrates the in-place reversal of a singly linked list using an iterative approach. The key takeaways are:
# Efficient Reversal: The reverse() method modifies the list in-place without using extra space, making it space-efficient (O(1) auxiliary space).
# Iterative Approach: It follows a three-pointer technique (prev, pres, and next) to reverse the links between nodes.
# Preserving Data Integrity: The method ensures that no node is lost during the reversal process
# Edge Cases: It handles cases like an empty list or a single-node list effectively.
*/
