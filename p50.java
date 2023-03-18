/*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> mainls=new ArrayList<>();
        for(int i=0;i<(1<<nums.length);i++){
            int temp=i;
            int j=0;
            List<Integer> ls=new ArrayList<>();
            while(temp>0){
                if((temp&1)>0){
                    ls.add(nums[j]);
                }
                j++;
                temp>>=1;
            }
            Collections.sort(ls);
            if(!mainls.contains(ls)){
                mainls.add(ls);
            }
        }
        return mainls;
    }
}