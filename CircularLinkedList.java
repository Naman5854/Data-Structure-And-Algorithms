package Package;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        if(head==null){
            node.next=node;
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next=node;
        node.next=head;
        head=node;
        size++;
    }
    public void insertLast(int val){
        Node node=new Node(val);
        if(head==null){
            insertFirst(val);
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        size++;
    }
    public void insert(int index,int val){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public int deleteFirst(){
        int val=head.value;
        tail.next=head.next;
        head=head.next;
        size--;
        return val;
    }
    public int deleteLast(){
        int val=tail.value;
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        tail=temp;
        tail.next=head;
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
        size--;
        return val;
    }

    public void display(){
        Node temp=head;
        do{
            System.out.print(temp.value +" -> ");
            temp=temp.next;
        }
        while(temp!=head);
        System.out.println("Head");
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
        CircularLinkedList list=new CircularLinkedList();
        list.insertFirst(50);
        list.insertFirst(40);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        list.display();
        list.insertLast(60);
        list.display();
        list.insert(2,25);
        list.display();
        list.insert(list.size, 70);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
    }
}
/*
Output:-
10 -> 20 -> 30 -> 40 -> 50 -> Head
10 -> 20 -> 30 -> 40 -> 50 -> 60 -> Head
10 -> 20 -> 25 -> 30 -> 40 -> 50 -> 60 -> Head
10 -> 20 -> 25 -> 30 -> 40 -> 50 -> 60 -> 70 -> Head
10
20 -> 25 -> 30 -> 40 -> 50 -> 60 -> 70 -> Head
70
20 -> 25 -> 30 -> 40 -> 50 -> 60 -> Head
30
20 -> 25 -> 40 -> 50 -> 60 -> Head
*/
/*
Conclusion:-
The program efficiently demonstrates the working of a Circular Linked List.
It correctly maintains the circular property by ensuring the tail node points back to the head.
It supports dynamic insertion and deletion at any position.
The display() function correctly prints the circular nature of the list.
*/
