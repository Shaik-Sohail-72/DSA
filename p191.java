/*Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don't need to read input or print anything. The task is to complete the function trappingWater() which takes arr[] and N as input parameters and returns the total amount of water that can be trapped.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
3 < N < 106
0 < Ai < 108*/

class Solution{
    static long trappingWater(int arr[], int n) { 
        int i=0;
        int j=n-1;
        int leftmax=0;
        int rightmax=0;
        long t=0;
        while(i<j){
            if(arr[i]<arr[j]){
                leftmax=Math.max(leftmax,arr[i]);
                t+=(leftmax-arr[i]);
                i++;
            }else{
                rightmax=Math.max(rightmax,arr[j]);
                t+=(rightmax-arr[j]);
                j--;
            }
        }
        return t;
    } 
}