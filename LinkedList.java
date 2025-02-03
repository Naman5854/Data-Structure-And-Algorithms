//Custom Implementation Of Linked List in Java
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
    public int deleteFromFirst(){
        int val=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFromFirst();
        }
        int val=tail.value;
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deleteFromFirst();
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
        while(temp!=null){
            System.out.print(temp.value +" -> ");
            temp=temp.next;
        }
        System.out.println("End");
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
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertLast(5);
        list.display();
        list.insert(2,25);
        list.display();
        list.deleteFromFirst();
        list.display();
        list.deleteLast();
        list.display();
        list.delete(1);
        list.display();

    }
}

// Output:- 40 -> 30 -> 20 -> 10 -> 5 -> End
// 40 -> 30 -> 25 -> 20 -> 10 -> 5 -> End
// 30 -> 25 -> 20 -> 10 -> 5 -> End
// 30 -> 25 -> 20 -> 10 -> End
// 30 -> 20 -> 10 -> End
/*
🔍 Conclusion:
This program implements a **Singly Linked List** with insertion, deletion, and display functionalities.

🕒 Time Complexity:
- Insert at Beginning: **O(1)**
- Insert at End: **O(1)** (when tail is tracked)
- Insert at Index: **O(n)**
- Delete from Beginning: **O(1)**
- Delete from End: **O(n)**
- Delete at Index: **O(n)**

🚀 Key Takeaways:
- **Efficient Insertions & Deletions:** Fast at the beginning, slower at the end.
- **No Fixed Size:** Unlike arrays, linked lists grow dynamically.
- **Sequential Access:** Searching takes **O(n)** time, making index-based access slower than arrays.

📢 Final Thoughts:
Linked lists are useful when frequent insertions and deletions are required, but they lack fast random access. This implementation is a foundation for more advanced structures like Doubly Linked Lists and Circular Linked Lists.
*/
