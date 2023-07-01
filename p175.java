/*Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes in the given circular linked list then out of the resulting two halved lists, first list should have one node more than the second list. The resultant lists should also be circular lists and not linear lists.

 

Example 1:

Input:
Circular LinkedList: 1->5->7
Output:
1 5
7
 

Example 2:

Input:
Circular LinkedList: 2->6->1->5
Output:
2 6
1 5

Your Task:
Your task is to complete the given function splitList(), which takes 3 input parameters: The address of the head of the linked list, addresses of the head of the first and second halved resultant lists and Set the head1_ref and head2_ref to the first resultant list and second resultant list respectively.


Expected Time Complexity: O(N)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 100*/
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class gfg{
    void splitList(circular_LinkedList list){
         //DO NOT REMOVE THESE 3 LINES
         Node head=list.head;
         Node head1=null;
         Node head2=null;
         //Modify these head1 and head2 here, head is the starting point of our original linked list.    
         Node mid=findmid(head);
         Node curr=mid.next;
         while(curr.next!=head){
             curr=curr.next;
         }
         curr.next=mid.next;
         head2=mid.next;
         head1=head;
         mid.next=head;
         //DO NOT REMOVE THESE 2 LINES
         list.head1=head1;
         list.head2=head2;
 }
 public static Node findmid(Node head){
     Node slow=head;
     Node fast=head;
     while(fast.next!=head && fast.next.next!=head){
         slow=slow.next;
         fast=fast.next.next;
     }
     return slow;
 }
}