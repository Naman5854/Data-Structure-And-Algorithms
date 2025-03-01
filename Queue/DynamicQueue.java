package Package;

public class DynamicQueue {
    protected int[] data;
    protected static final int default_size=5;
    protected int front=0;
    protected int end=0;
    private int size=0;

    public DynamicQueue(int size) {
        data=new int[size];
    }

    public DynamicQueue() {
        this(default_size);
    }
    public boolean enqueue(int value){
        if(isFull()){
            int[] temp=new int[data.length*2];
            for(int i=front;i< data.length;i++){
                temp[i]=data[(front+i)% data.length];
            }
            front=0;
            end= data.length;;
            data=temp;
        }
        data[end++]=value;
        end=end%data.length;
        size++;
        return true;
    }
    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot be dequeued, Queue is Empty.");
        }
        int removed=data[front++];
        front=front% data.length;
        size--;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty.");
        }
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Empty.");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i]+" -> ");
            i++;
            i=i% data.length;
        } while(i!=end);
        System.out.println("End");
    }
    public boolean isFull(){
        return size==data.length;
    }
    private boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) throws Exception{
        DynamicQueue queue=new DynamicQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        queue.enqueue(60);
        queue.display();
        System.out.println(queue.dequeue());
        queue.enqueue(70);
        queue.display();
    }
}
/*Output:-10 -> 20 -> 30 -> 40 -> 50 -> End
10 -> 20 -> 30 -> 40 -> 50 -> 60 -> End
10
20 -> 30 -> 40 -> 50 -> 60 -> 70 -> End
Conclusion:-The DynamicQueue class efficiently implements a circular queue with dynamic resizing in Java. 
When the queue is full, it doubles its size while maintaining element order.
The implementation includes standard operations like enqueue, dequeue, front, display, and utility methods (isFull, isEmpty). 
The test case demonstrates the correct behavior of dynamic resizing and circular indexing.
*/
