/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105*/
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int s3=0;
        int e3=n-1;
        while(s3<e3){
            int temp=nums[s3];
            nums[s3]=nums[e3];
            nums[e3]=temp;
            s3++;
            e3--;
        }
        int s1=0;
        int e1=k-1;
        while(s1<e1){
            int temp=nums[s1];
            nums[s1]=nums[e1];
            nums[e1]=temp;
            s1++;
            e1--;
        }
        int s2=k;
        int e2=n-1;
        while(s2<e2){
            int temp=nums[s2];
            nums[s2]=nums[e2];
            nums[e2]=temp;
            s2++;
            e2--;
        }
    }
}