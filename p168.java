/*A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 1021*/

/* class Node{
    int data;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
} */


/*
Approach : we have to check three conditions. case-1: 999,case-2: 119,case-3: 456
first reverse the linkedlist.
then it become : 999,911,654
if number==9 and root==null then make that number as 1 and add new node 0 at the end.
else if number==9 then make it as 0 and move the pointer
else number!=9 then add 1 to the number and break;
then reverse the linkedlist.
then it will become: 1000,120,457.*/


class Solution{
    public static Node addOne(Node head) { 
        head=rev(head);
        boolean f=true;
        Node curr=head;
        while(curr!=null && f==true){
            if(curr.data==9 && curr.next==null){
                curr.data=1;
                Node temp=new Node(0);
                temp.next=head;
                head=temp;
                curr=curr.next;
            }
            else if(curr.data==9){
                curr.data=0;
                curr=curr.next;
            }else{
                curr.data=curr.data+1;
                curr=curr.next;
                f=false;
            }
        }
        head=rev(head);
        return head;
    }
    public static Node rev(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
