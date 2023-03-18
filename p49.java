/*Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> mainls=new ArrayList<>();
        for(int i=0;i<(1<<nums.length);i++){
            int j=0;
            int temp=i;
            List<Integer> ls=new ArrayList<>();
            while(temp>0){
                if((temp&1)>0){
                    ls.add(nums[j]);
                }
                j++;
                temp=temp>>1;
            }
            mainls.add(ls);
        }
        return mainls;
    }
}