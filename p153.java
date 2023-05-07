/*Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((3N^2)).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1*/
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean vis[][]=new boolean[n][n];
        ArrayList<String> ls=new ArrayList<>();
        ArrayList<String> errls=new ArrayList<>();
        errls.add("-1");
        dfs(m,vis,0,0,"",n-1,n-1,ls);
        if(ls.size()==0){
            return errls;
        }else{
            return ls;
        }
    }
    public static boolean isValid(int mat[][],int i,int j){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || (mat[i][j]==0 && i==0 && j==0)){
            return false;
        }
        return true;
    }
    public static void dfs(int mat[][],boolean vis[][],int i,int j,String path,int tr,int tc,ArrayList<String> ls){
        if(mat[i][j]==0 && i==0 && j==0){
            return;
        }
        if(i==tr && j==tc){
            if(!ls.contains(path)){
                ls.add(path);
            }
            return;
        }
        if(isValid(mat,i-1,j) && vis[i-1][j]==false && mat[i-1][j]==1){
            vis[i][j]=true;
            dfs(mat,vis,i-1,j,path+"U",tr,tc,ls);
            vis[i][j]=false;
        }
        if(isValid(mat,i,j+1) && vis[i][j+1]==false && mat[i][j+1]==1){
            vis[i][j]=true;
            dfs(mat,vis,i,j+1,path+"R",tr,tc,ls);
            vis[i][j]=false;
        }
        if(isValid(mat,i+1,j) && vis[i+1][j]==false && mat[i+1][j]==1){
            vis[i][j]=true;
            dfs(mat,vis,i+1,j,path+"D",tr,tc,ls);
            vis[i][j]=false;
        }
        if(isValid(mat,i,j-1) && vis[i][j-1]==false && mat[i][j-1]==1){
            vis[i][j]=true;
            dfs(mat,vis,i,j-1,path+"L",tr,tc,ls);
            vis[i][j]=false;
        }
    }
}