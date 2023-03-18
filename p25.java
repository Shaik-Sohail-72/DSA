/*Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome

Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
 

Your Task:
You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.

Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)*/
class Solution {
    int isPalindrome(String S) {
        int l=0;
        int r=S.length()-1;
        while(l<=r){
            if(S.charAt(l)!=S.charAt(r)){
                return 0;
            }
            l++;
            r--;
        }
        return 1;
    }
};