 //Finding start node in Linked list cycle
        public Node findNode(Node head){
            Node fast=head;
            Node slow=head;
            int len=findLength(head);//Function defined in previous file
            if(len==0){
                return null;
            }
            for(int i=0;i<len;i++){
                slow=slow.next;
            }
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
/*Conclusion:
Detecting a Cycle Efficiently – The algorithm uses Floyd’s Cycle Detection (Tortoise & Hare) method to detect if a cycle exists in the linked list.
Finding the Cycle Length – Once a cycle is detected, the algorithm counts the number of nodes in the cycle.
Locating the Start of the Cycle – By moving one pointer ahead by the cycle length and then advancing both pointers, we find the exact starting node of the cycle.
Efficiency – The approach runs in O(n) time complexity and uses O(1) space, making it optimal for cycle detection in linked lists.
Proper Output Handling – Instead of printing the memory reference of the node, we ensure that the actual node value where the cycle starts is displayed.
*/
