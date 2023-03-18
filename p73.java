/*The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).


Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:

0 <= n <= 30*/
class Solution {
    public int fib(int n) {
        // Math
        int f1=0;
        int f2=1;
        int temp=0;
        for(int i=0;i<n;i++){
            temp=f1+f2;
            f1=f2;
            f2=temp;
        }
        return f1;
        
        // Recursion
        if(n<=1){
            return n;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
        
        // Top down DP
        int dp[]=new int[n+1];
        if(n<=1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fib(n-1)+fib(n-2);
        return dp[n];
        
        // Bottom Up DP
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[0]=0;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}