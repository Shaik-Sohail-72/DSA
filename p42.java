/*Given binary string str of length N. The task is to find the maximum count of consecutive substrings str can be divided into such that all the substrings are balanced i.e. they have an equal number of 0s and 1s. If it is not possible to split str satisfying the conditions then return -1.

Example 1:

Input:
S = "0100110101"
Output: 4
Explanation: 
The required substrings are 01, 0011, 01 and 01.

Example 2:

Input:
S = "0111100010"
Output: 3
 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSubStr() which takes a string S and returns an integer as output.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)*/
class Solution {
    public static int maxSubStr(String str) {
    int c0=0;
    int c1=0;
    int count=0;
       for(int i=0;i<str.length();i++){
           if(str.charAt(i)=='0'){
               c0++;
           }else{
               c1++;
           }
           if(c0==c1){
               count++;
           }
       }
       if(c0==c1){
           return count;
       }
       return -1;
    }
}