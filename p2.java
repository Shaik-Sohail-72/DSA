/*Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.

Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.

Your Task:
You do not need to read or print anything. Your task is to complete the function singleNumber() which takes the array as input parameter and returns a list of two numbers which occur exactly once in the array. The list must be in ascending order.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)

Constraints:
1 <= length of array <= 106 
1 <= Elements in array <= 5 * 106*/
class Solution{
    public int[] singleNumber(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum^nums[i];
        }
        sum=sum& ~(sum-1);
        int s1=0;
        int s2=0;
        for(int i=0;i<nums.length;i++){
            if((sum & nums[i])>0){
                s1^=nums[i];
            }else{
                s2^=nums[i];
            }
        }
        int arr[]=new int[2];
        if(s1<s2){
            arr[0]=s1;
            arr[1]=s2;
        }else{
            arr[0]=s2;
            arr[1]=s1;
        }
        return arr;
    }
}