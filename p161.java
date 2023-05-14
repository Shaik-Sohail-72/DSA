// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

/*Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that returns an array containing the nodes that are in the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 100
1 <= Data of a node <= 1000*/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree{
    ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> ls=new ArrayList<>();
        leftRecur(root,0,ls);
        return ls;
    }
    public static void leftRecur(Node root,int level,ArrayList<Integer> ls){
        if(root==null){
            return;
        }
        if(ls.size()==level){
            ls.add(root.data);
        }
        leftRecur(root.left,level+1,ls);
        leftRecur(root.right,level+1,ls);
    }
}