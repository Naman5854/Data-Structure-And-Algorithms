//Reorder list
    public void reorder(Node head){
        if(head==null||head.next==null){
            return;
        }
        Node hf=head;
        Node mid=middle(head);
        Node hs=reverse(mid);
        while(hf!=null && hs!=null){
            Node temp=hf.next;
            hf.next=hs;
            hf=temp;
            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }
        if(hf!=null){
            hf.next=null;
        }
    }
 public Node reverse(Node head){
        if(head==null){
            return head;
        }
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
        return prev;
    }
public  static Node middle(Node head){
        if(head==null || head.next==null){
            return head;
        }
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
        list.insertLast(5);
        list.display();
        list.reorder(list.head);
        list.display();
}
/*output:-1 -> 2 -> 3 -> 4 -> 5 -> End
1 -> 5 -> 2 -> 4 -> 3 -> End
Conclusion:-This Java program reorders a linked list in a specific pattern. The reordering follows these steps:
# Find the Middle Node:
The middle() function uses the slow and fast pointer approach to find the middle node of the linked list.
# Reverse the Second Half:
The reverse() function reverses the second half of the list.
# Merge Both Halves Alternately:
The reorder() function merges the first half and the reversed second half alternately.
# Time Complexity:
Finding the middle node: O(n)
Reversing the second half: O(n)
Merging both halves: O(n)
Overall complexity: O(n)
