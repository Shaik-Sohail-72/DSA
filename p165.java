/*Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 6 5 4 3 2 1
Explanation: After reversing the list, 
elements are 6->5->4->3->2->1.
Example 2:

Input:
LinkedList: 2->7->8->9->10
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
Your Task:
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104*/


/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}*/


class Solution{
    // Extra Space
    Node reverseList(Node head)
    {
        List<Integer> ls=new ArrayList<>();
        Node curr=head;
        while(curr!=null){
            ls.add(curr.data);
            curr=curr.next;
        }
        Node temp=head;
        for(int i=ls.size()-1;i>=0;i--){
            temp.data=ls.get(i);
            temp=temp.next;
        }
        return head;
    }
    
    // Without extra space optimized way
    /* Approach 
    Initialize two pointers prev as NULL, curr as head.
    Iterate through the linked list. In a loop, do the following:
    Before changing the next of curr, initialize temp node and store the next node 
    temp = curr -> next
    Now update the next pointer of curr to the prev 
    curr -> next = prev 
    Update prev as curr and curr as next 
    prev = curr 
    curr = temp */
    Node reverseList(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
