 //find length of linked list cycle
    public int findLength(Node head){
        Node fast=head;
        Node slow=head;
        int count=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node temp=slow;
                do{
                    temp=temp.next;
                    count++;
                }while(temp!=slow);
                return count;
            }
        }
        return 0;
    }
/*Conclusion:
Cycle Detection Using Floyd’s Algorithm – The method utilizes the Tortoise and Hare approach to detect a cycle.
Counting the Cycle Length – Once a cycle is detected, a temporary pointer (temp) traverses the cycle until it reaches the starting node again, counting the steps.
Returns Length of the Cycle – If a cycle exists, it returns its length; otherwise, it returns 0.
Key Points:
#Efficient O(n) time complexity.
#Uses only O(1) extra space.
#Exits early upon detecting the cycle length.
*/
