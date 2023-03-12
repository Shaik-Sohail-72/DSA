/*Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100*/
class Solution {
    public int binsearch(int arr[]){
        int l=0;
        int r=arr.length-1;
        int res=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=0){
                l=mid+1;
            }else if(arr[mid]<0){
                res+=r-mid+1;
                r=mid-1;
            }
        }
        return res;
    }
    public int countNegatives(int[][] grid) {
        int sum=0;
       for(int i=0;i<grid.length;i++){
            sum+=binsearch(grid[i]);
       } 
        return sum;
    }
}