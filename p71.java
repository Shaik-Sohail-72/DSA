/*Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1*/
class Solution {
    public int closedIsland(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    if(help(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean help(int[][]arr,int i,int j){
        if( i<0 || j<0 || i>=arr.length || j>=arr[0].length ||(arr[i][j]==0 && (i==0 || j==0 || i==arr.length || j == arr[0].length))){
            return false;
        }
        if(arr[i][j]==1){
            return true;
        }
        arr[i][j]=1;
        boolean a =help(arr,i+1,j);boolean b= help(arr,i,j+1); boolean c= help(arr,i-1,j);boolean d = help(arr,i,j-1);
        return a && b && c && d;
    }
}