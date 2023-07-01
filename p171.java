/*Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(Max(N,M)) for the resultant list.

Constraints:
1 <= N, M <= 5000*/

/* node for linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    static Node addTwoLists(Node first, Node second) {
        // Reverse both input linked lists
        first = reverseLinkedList(first);
        second = reverseLinkedList(second);

        int carry = 0;
        int sum = 0;
        Node result = null;
        Node current = null;

        while (first != null || second != null) {
            int firstVal = (first != null) ? first.data : 0;
            int secondVal = (second != null) ? second.data : 0;

            sum = carry + firstVal + secondVal;
            carry = sum / 10;
            int digit = sum % 10;

            Node newNode = new Node(digit);
            if (result == null) {
                result = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            Node carryNode = new Node(carry);
            current.next = carryNode;
        }

        // Reverse the result linked list
        result = reverseLinkedList(result);

        return result;
    }

    public static Node reverseLinkedList(Node head) {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
