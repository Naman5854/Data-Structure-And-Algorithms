package Package;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }
    public void add(int item){
        first.push(item);
    }
    public int remove()throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed=second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
    public int peek()throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked=second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }
    public boolean isEmpty(){
        return first.isEmpty();
    }
    public void display(){
        System.out.println(first);
    }

    public static void main(String[] args) throws Exception{
        QueueUsingStack queue=new QueueUsingStack();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.display();
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        queue.display();
    }
}
/*Output:-[10, 20, 30, 40, 50]
10
20
[20, 30, 40, 50]
Conclusion:-The given implementation correctly simulates a queue using two stacks and maintains FIFO (First In, First Out) order. 
The approach effectively utilizes stack operations to implement queue behavior, ensuring correct functionality. 
This solution is simple, easy to understand, and works well for small datasets.
It follows the enqueue (add) operation in O(1) time and the dequeue (remove) operation in O(n) time because all elements are transferred from first to second and back.
*/
