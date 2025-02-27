package Package;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 5;
    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        data = new int[size];
    }

    public boolean enqueue(int value){
        if (isFull()) {
            return false;
        }
        data[end++] = value;
        return true;
    }

    public int dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Cannot be dequeued,as queue is Empty.");
        }
        int removed=data[0];
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int front()throws Exception{
        if(isEmpty()) {
            throw new Exception("Cannot be peeked,as queue is Empty.");
        }
        return data[0];
    }
    public boolean isFull(){
        return end== data.length;
    }
    public boolean isEmpty(){
        return end==0;
    }
public void display(){
        for(int i=0;i<end;i++){
            System.out.print(data[i] +"<-");
        }
    System.out.println("end");
}
public static void main(String[] args) throws Exception{
      CustomQueue queue=new CustomQueue(5);
      queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);
    queue.display();
    System.out.println(queue.dequeue());
    System.out.println(queue.front());
     queue.display();
     queue.enqueue(60);
     queue.display();
}  }
/*Output:-10<-20<-30<-40<-50<-end
10
20
20<-30<-40<-50<-end
20<-30<-40<-50<-60<-end
Conclusion:-This CustomQueue implementation in Java is a simple fixed-size queue using an array.
It supports basic queue operations: enqueue, dequeue, front, isFull, isEmpty, and display. 
The implementation correctly shifts elements on dequeue, though this makes it less efficient for large queues. 
The test cases demonstrate proper functioning, but an optimization using a circular queue would improve performance.
*/

