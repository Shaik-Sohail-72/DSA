/*Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

 

Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List
Example 2:

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation: 

4              5
|              |
1              6
 \             /
  8   -----  1 
   |
   4
   |
  5
  |
  NULL       
Your Task:
You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
Challenge : Try to solve the problem without using any extra space.

 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N + M ≤ 2*105
-1000 ≤ value ≤ 1000*/


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect{
	int intersectPoint(Node head1, Node head2){
        int c1=count(head1);
        int c2=count(head2);
        int diff=Math.abs(c1-c2);
        
        Node curr1=head1;
        Node curr2=head2;
        if(c1>c2){
            for(int i=0;i<diff;i++){
                curr1=curr1.next;
            }
        }
        else if(c2>c1){
            for(int i=0;i<diff;i++){
                curr2=curr2.next;
            }
        }
        while(curr1!=null && curr2!=null){
            if(curr1==curr2){
                return curr1.data;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return -1;
	}
	public static int count(Node head){
	    Node curr=head;
	    int c=0;
	    while(curr!=null){
            c++;
            curr=curr.next;
        }
        return c;
	}
}


