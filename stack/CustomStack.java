package Package;

import java.util.Arrays;
import java.util.Stack;
class StackException extends Exception{
    public StackException(String message) {
        super(message);

    }
}
public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=5;

    int top=-1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        data=new int[size];
    }
    public boolean push(int value) throws StackException{
        if(isFull()){
            throw new StackException("Cannot push element as stack is full.");
        }
        top++;
        data[top]=value;
        return true;
    }
    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot pop,as stack is empty.");
        }
        int removed=data[top];
        top--;
        return removed;
    }
    public int peek ()throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot peek from empty stack");
        }
       return data[top];
    }
    private boolean isFull() {
        if(top==data.length-1){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isEmpty(){
        return top==-1;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args) throws StackException{
        CustomStack stack=new CustomStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.push(60);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.push(70);//this will stack is full exception.

    }
}
/* Output:-
  CustomStack{data=[10, 20, 30, 40, 50]}
50
CustomStack{data=[10, 20, 30, 40, 50]}
CustomStack{data=[10, 20, 30, 40, 60]}
60
Exception in thread "main" Package.StackException: Cannot push element as stack is full.
	at Package.CustomStack.push(CustomStack.java:26)
	at Package.CustomStack.main(CustomStack.java:78)
Conclusion:-This Custom Stack implementation efficiently handles fundamental stack operations (push, pop, and peek) while ensuring proper exception handling for overflow and underflow conditions.
The design follows encapsulation principles, keeping helper methods (isFull(), isEmpty()) private for better code structure.
*/
