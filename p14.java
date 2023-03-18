/*Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.

Example 1:

Input : str = "abc"
Output: a ab abc ac b bc c
Explanation : There are 7 subsequences that 
can be formed from abc.

Example 2:

Input: str = "aa"
Output: a a aa
Explanation : There are 3 subsequences that 
can be formed from aa.
Your Task:
You don't need to read input or print anything. Your task is to complete the function AllPossibleStrings() which takes S as the input parameter and returns a list of all possible subsequences (non-empty) that can be formed from S in lexicographically-sorted order.zzzzz

Expected Time Complexity: O(n*2n) where n is the length of the String
Expected Space Complexity: O(n * 2n)*/
class Solution{
    public List<String> AllPossibleStrings(String str){
        List<String> ans= new ArrayList<>();
        for(int i = 1; i<(1<<str.length());i++){
            String res="";
            int temp=i; 
            int j=0;
            while(temp>0){
                if((temp&1)>0){
                    res+=str.charAt(j);
                }
                j++;
                temp>>=1;
            }
            ans.add(res) ;
        }
        Collections.sort(ans);
        return  ans;
    }
}