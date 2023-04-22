/*Given a binary matrix your task is to find all unique rows of the given matrix.

Example 1:

Input:
row = 3, col = 4 
M[][] = {{1 1 0 1},{1 0 0 1},{1 1 0 1}}
Output: 1 1 0 1 $1 0 0 1 $
Explanation: Above the matrix of size 3x4
looks like
1 1 0 1
1 0 0 1
1 1 0 1
The two unique rows are 1 1 0 1 and
1 0 0 1 .
Your Task:
You only need to implement the given function uniqueRow(). The function takes three arguments the first argument is a matrix M and the next two arguments are row and col denoting the rows and columns of the matrix. The function should return the list of the unique row of the martrix. Do not read input, instead use the arguments given in the function.

Note: The drivers code print the rows "$" separated.

Expected Time Complexity: O(row * col)
Expected Auxiliary Space: O(row * col)

Constraints:
1<=row,col<=40
0<=M[][]<=1*/
class TrieNode{
    TrieNode children[];
    boolean eor;
    TrieNode(){
        children=new TrieNode[2];
        for(int i=0;i<2;i++){
            children[i]=null;
        }
        eor=false;
    }
}
class GfG{
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c){
        ArrayList<ArrayList<Integer>> mainls=new ArrayList<>();
        TrieNode root=new TrieNode();
        for(int i=0;i<r;i++){
            if(!search(a[i],root)){
                insert(a[i],root);
                ArrayList<Integer> ls=new ArrayList<>();
                for(int ele:a[i]){
                    ls.add(ele);
                }
                mainls.add(ls);
            }
        }
        return mainls;
    }
    public static void insert(int arr[],TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<arr.length;i++){
            if(curr.children[arr[i]]==null){
                curr.children[arr[i]]=new TrieNode();
            }
            curr=curr.children[arr[i]];
        }
        curr.eor=true;
    }
    public static boolean search(int arr[],TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<arr.length;i++){
            if(curr.children[arr[i]]==null){
                return false;
            }
            curr=curr.children[arr[i]];
        }
        return curr.eor;
    }
}