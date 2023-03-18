/*Given three stacks S1, S2, and S3 of the positive numbers, the task is to find the possible equal maximum sum of the stacks with the removal of top elements allowed. Stacks are represented as an array, and the first index of the array represents the top element of the stack.


Example 1:

Input:
N1 = 3, N2 = 4, N3 = 2
S1 = {4,2,3}
S2 = {1,1,2,3}
S3= {1,4}
Output:
5
Explanation:
We can pop 1 element from the 1st stack, and 2
elements from the 2nd stack. Now remaining elements
yield the equal sum of the three stacks, that is 5.
 

Example 2:

Input:
N1 =2, N2 = 1, N3 = 3
S1 = {4,7}
S2 = {10}
S3 = {1,2,3}
Output:
0
Explanation:
We will never get an equal sum after popping
some elements, so the answer will be 0.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function maxEqualSum() which takes the arrays S1[], S2[], and S3[] and their sizes N1, N2, and N3 as inputs and returns the maximum equal sum we can obtain.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N1, N2, N3 <= 105
1 <= S1[i], S2[i], S3[i] <= 103
Sum of N over all test cases doesn't exceeds 106*/
class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        int sum1=0;
        int sum2=0;
        int sum3=0;
        for(int i=0;i<N1;i++){
            sum1+=S1[i];
        }
        for(int i=0;i<N2;i++){
            sum2+=S2[i];
        }
        for(int i=0;i<N3;i++){
            sum3+=S3[i];
        }
        int top1=0;
        int top2=0;
        int top3=0;
        while(true){
            if(top1==N1 ||top2==N2||top3==N3){
                return 0;
            }
            if(sum1==sum2 && sum2==sum3){
                return sum1;
            }
            if(sum1>=sum2 && sum1>=sum3){
                sum1-=S1[top1++];
            }else if(sum2>=sum1 && sum2>=sum3){
                sum2-=S2[top2++];
            }else{
                sum3-=S3[top3++];
            }
        }
    }
}