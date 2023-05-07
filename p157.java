/*Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.*/
class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(vis[i][0]==false && board[i][0]=='O'){
                dfs(board,vis,i,0);
            }
            if(vis[i][n-1]==false && board[i][n-1]=='O'){
                dfs(board,vis,i,n-1);
            }
        }
        for(int j=0;j<n;j++){
            if(vis[0][j]==false && board[0][j]=='O'){
                dfs(board,vis,0,j);
            }
            if(vis[m-1][j]==false && board[m-1][j]=='O'){
                dfs(board,vis,m-1,j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
    public static boolean isValid(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        return true;
    }
    public static void dfs(char[][] grid,boolean vis[][],int i,int j){
		vis[i][j]=true;
		if(isValid(grid,i-1,j) && vis[i-1][j]==false && grid[i-1][j]=='O'){
			dfs(grid,vis,i-1,j);
		}
		if(isValid(grid,i,j+1) && vis[i][j+1]==false && grid[i][j+1]=='O'){
			dfs(grid,vis,i,j+1);
		}
		if(isValid(grid,i+1,j) && vis[i+1][j]==false && grid[i+1][j]=='O'){
			dfs(grid,vis,i+1,j);
		}
		if(isValid(grid,i,j-1) && vis[i][j-1]==false && grid[i][j-1]=='O'){
			dfs(grid,vis,i,j-1);
		}
	}
}