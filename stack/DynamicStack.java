package Package;

import java.util.Arrays;
class StackException extends Exception{
    public StackException(String message) {
        super(message);
    }
}
public class DynamicStack {
    protected int[] data;
    static final int DEFAULT_SIZE = 5;

    public DynamicStack() {
        this(DEFAULT_SIZE);
    }

    public DynamicStack(int size) {
        data = new int[size];
    }

    int top = -1;

    public boolean push(int value) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            int i;
            for (i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        top++;
        data[top] = value;
        return true;
    }

    public int pop()throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot be popped as stack is empty.");
        }
        int removed=data[top];
        top--;
        return removed;
    }
    public int peek()throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot peek from empty stack.");
        }
        return data[top];
    }

    @Override
    public String toString() {
        return "DynamicStack{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public boolean isFull(){
        return top== data.length-1;
    }
    public boolean isEmpty() {
        return top==-1;
    }
    public static void main(String[] args) throws StackException{
            DynamicStack stack=new DynamicStack(2);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
}
}
/*
Output:-5
4
DynamicStack{data=[2, 3, 4,5]} 
Conclusion:-The DynamicStack class implements a dynamically resizable stack in Java. 
It starts with a default or user-defined size and doubles its capacity when full. 
The class supports push, pop, and peek operations with appropriate error handling using a custom StackException. 
The toString method provides a readable representation of the stack's contents. 
The test case in main demonstrates the dynamic resizing functionality and correct stack operations.
*/
