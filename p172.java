/*Given two linked lists sorted in increasing order, create a new linked list representing the intersection of the two linked lists. The new linked list should be made with its own memory the original lists should not be changed.
Note: The linked list elements are not necessarily distinct.

Example 1:

Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.
Example 2:

Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40
Your Task:
The task is to complete the function intersection() which should find the intersection of two linked list and add all the elements in intersection to the third linked list and return the head of the third linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)
Note: n,m are the size of the linked lists.

Constraints:
1 <= size of linked lists <= 5000
1 <= Data in linked list nodes <= 104*/

/*Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}*/

class Sol{
   public static Node findIntersection(Node head1, Node head2){
        Node res=null;
        Node curr=null;
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=null && curr2!=null){
            if(curr1.data<curr2.data){
                curr1=curr1.next;
            }else if(curr2.data<curr1.data){
                curr2=curr2.next;
            }else{
                Node temp=new Node(curr1.data);
                if(res==null){
                    res=temp;
                    curr=temp;
                }else{
                    curr.next=temp;
                    curr=temp;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            }
        }
        return res;
    }
}