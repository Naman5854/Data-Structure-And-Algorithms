// Reversal of Linked List Using Recursion
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        node.next=null;
        tail=node;
        size++;
    }
 public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value +" -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }
    // reversal of ll using recursion
    public void reverse(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
 public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertFirst(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);
        list.display();
        list.reverse(list.head);
        list.display();
}
}
/* Output:-
  10 -> 20 -> 30 -> 40 -> 50 -> End
50 -> 40 -> 30 -> 20 -> 10 -> End
*/
/* Conclusion
This Java program demonstrates the reversal of a linked list using recursion. The key idea is to traverse the list recursively until the last node, then update the references to reverse the links.

Key Takeaways:

The reverse() method leverages recursion to reach the last node and reverses the connections while backtracking.
The display() method helps visualize the linked list before and after reversal.
The program successfully reverses the linked list without using extra space, maintaining an efficient recursive approach.
*/

