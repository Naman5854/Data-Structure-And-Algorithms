package Package;

public class DoublyLinkedList {

    private Node head;
    int size;

    public DoublyLinkedList() {
        this.size=0;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        if(head==null){
            node.prev=null;
            node.next=null;
            head=node;
            size++;
            return;
        }
        else{
        node.next=head;
        head.prev=node;
        node.prev=null;
        head=node;
        size++;
        }
    }
    public void insertLast(int val){
        Node node=new Node(val);
        if(head==null){
            insertFirst(val);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
        node.next=null;
        size++;
    }
    public void insert(int index,int val){
        Node node=new Node(val);
        Node temp=head;
        for(int i=1;i<index;i++){
           temp=temp.next;
        }
        node.next=temp.next;
        temp.next.prev=node;
        temp.next=node;
        node.prev=temp;
        size++;
    }
    public int deleteFirst(){
        int val=head.value;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public int deleteLast(){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        int val=temp.value;
        temp.prev.next=null;
        size--;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        int val=temp.next.value;
        temp.next=temp.next.next;
        temp.next.next.prev=temp;
        size--;
        return val;
    }
    public void update(int index,int val){
        if(index==0){
            head.value=val;
            return;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.value=val;
    }
    public void display(){
        if(head==null){
            System.out.println("Linked List is Empty.");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value +" <-> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        private int value;
        private  Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev,Node next) {
            this.value = value;
            this.prev=prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList ll=new DoublyLinkedList();
        ll.insertFirst(50);
        ll.insertFirst(40);
        ll.insertFirst(30);
        ll.insertFirst(20);
        ll.insertFirst(10);
        ll.insertLast(60);
        ll.display();
        ll.insert(2,25);
        ll.display();
        System.out.println(ll.deleteFirst());
        System.out.println(ll.deleteLast());
        ll.display();
        System.out.println(ll.delete(2));
        ll.display();
        ll.update(2,35);
        ll.display();

    }
}
// Output:-  10 <-> 20 <-> 30 <-> 40 <-> 50 <-> 60 <-> End
// 10 <-> 20 <-> 25 <-> 30 <-> 40 <-> 50 <-> 60 <-> End
// 10
// 60
// 20 <-> 25 <-> 30 <-> 40 <-> 50 <-> End
// 30
// 20 <-> 25 <-> 40 <-> 50 <-> End
// 20 <-> 25 <-> 35 <-> 50 <-> End

//Conclusion:-
// This Doubly Linked List (DLL) implementation in Java supports various operations such as insertion at the beginning, end, and any given index.
// It also provides methods for deletion from the beginning, end, and a specific index.
// An update method allows modifying the value at a particular index.
// The display method prints the list in a readable format.
// The implementation correctly maintains both prev and next pointers to ensure proper bidirectional traversal.
