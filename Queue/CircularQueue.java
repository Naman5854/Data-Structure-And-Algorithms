package Package;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=5;
    private int front=0;
    private int end=0;
    protected int size=0;

    public CircularQueue(int size) {
        data=new int[size];
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }
    public boolean enqueue(int value){
        if(isFull()){
            return false;
        }
        data[end++]=value;
        end=end% data.length;
        size++;
        return true;
    }
    public int dequeue()throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot be dequeued as queue is empty");
        }
        int removed=data[front++];
        front=front% data.length;
        size--;
        return removed;
    }
    public int front()throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot be peeked as queue is empty");
        }
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i=i% data.length;
        }while(i!=end);
        System.out.println("End");

    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) throws Exception{
        CircularQueue queue=new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        queue.display();
    }
}
/*Output:-10 -> 20 -> 30 -> 40 -> 50 -> End
10
20
20 -> 30 -> 40 -> 50 -> End
Conclusion:-The CircularQueue implementation correctly manages a fixed-size circular queue using an array. 
The enqueue() method inserts elements at end, wrapping around when necessary, while dequeue() removes elements from front, also wrapping around. 
The queue maintains its size and prevents overwriting when full.
In the test case, the queue fills up with 5 elements, displays them correctly, dequeues the first element (10), updates the front, and continues functioning as expected.
*/
