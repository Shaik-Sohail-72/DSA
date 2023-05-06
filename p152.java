/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.*/
class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    c++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return c;
    }
    public static boolean isValid(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length ||j<0 ||j>=grid[0].length){
            return false;
        }
        return true;
    }
    public static void dfs(char[][] grid,boolean vis[][],int r,int c){
        vis[r][c]=true;
        if(isValid(grid,r-1,c) && vis[r-1][c]==false && grid[r-1][c]=='1'){
            dfs(grid,vis,r-1,c);
        }
        if(isValid(grid,r,c+1) && vis[r][c+1]==false && grid[r][c+1]=='1'){
            dfs(grid,vis,r,c+1);
        }
        if(isValid(grid,r+1,c) && vis[r+1][c]==false && grid[r+1][c]=='1'){
            dfs(grid,vis,r+1,c);
        }
        if(isValid(grid,r,c-1) && vis[r][c-1]==false && grid[r][c-1]=='1'){
            dfs(grid,vis,r,c-1);
        }
    }
}