//Palindrome Linked List
    public boolean ispalindrome(Node head){
        Node mid=middle(head);
        Node headsecond=reverse(mid);
        Node reverseHead=headsecond;

        while(head!=null && headsecond!=null) {
            if (head.value != headsecond.value) {
                break;
            }
                head=head.next;
                headsecond=headsecond.next;

        }
        reverse(reverseHead);
        if(head==null || headsecond==null){
            return true;
        }
        else {
            return false;
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
    list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);
        list.display();
        System.out.println(list.ispalindrome(list.head));
}
/*Output:-1 -> 2 -> 3 -> 2 -> 1 -> End
true
Conclusion:-This Java program checks whether a singly linked list is a palindrome. It does so by:
# Finding the Middle Node using the slow and fast pointer approach.
# Reversing the Second Half of the linked list.
# Comparing Both Halves element by element.
# Restoring the Original List after the check.
The program efficiently determines palindrome status in O(n) time complexity and uses O(1) extra space (in-place reversal). 
The approach ensures that the linked list remains unaltered after execution.
*/
