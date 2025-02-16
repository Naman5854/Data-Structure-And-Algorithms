// bubble sort list
    public void bubblesort(){
        if(head==null || head.next==null){
            return;
        }
        bubblesort(size-1,0);
    }
public Node get(int index){
    Node node=head;
    for(int i=0;i<index;i++){
        node=node.next;
    }
    return node;
}
    private void bubblesort(int row ,int col){
        if(row==0){
            return;
        }
        if(col<row){
            Node first=get(col);
            Node second=first.next;
            if(first.value>second.value){
                if(first==head){
                    head=second;
                    first.next=second.next;
                    second.next=first;
                }
                else if(second==tail){
                    Node prev=get(col-1);
                    prev.next=second;
                    tail=first;
                    first.next=null;
                    second.next=first;
                }
                else{
                    Node prev=get(col-1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;

                }
            }
            bubblesort(row,col+1);
        }
        else{
            bubblesort(row-1,0);
        }
    }
/*Output:- 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> End
           1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> End
Conclusion:-The recursive Bubble Sort implementation for a singly linked list correctly sorts the elements in ascending order. 
  It uses a recursive approach to perform adjacent swaps while handling edge cases for the head and tail nodes. 
  However, the approach has a time complexity of O(n²) and space complexity of O(n) due to recursive calls.
*/
