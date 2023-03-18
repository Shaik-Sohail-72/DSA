/*Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.

Example 1:

Input:
S = "001"
Output: 1
Explanation: 
We can flip the 0th bit to 1 to have
101.

Example 2:

Input:
S = "0001010111" 
Output: 2
Explanation: We can flip the 1st and 8th bit 
bit to have "0101010101"
101.

Your Task:
You don't need to read input or print anything. Your task is to complete the function minFlips() which takes the string S as input and returns the minimum number of flips required.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).*/
class Solution{
    public int minFlips(String S){
        int c1=0;
        int c2=0;
        for(int i=0;i<S.length();i++){
            if(i%2==0 && S.charAt(i)=='1'|| i%2!=0 && S.charAt(i)=='0'){
                c1++;
            }
            if(i%2==0 && S.charAt(i)=='0'|| i%2!=0 && S.charAt(i)=='1'){
                c2++;
            }
        }
        return Math.min(c1,c2);
    }
    
}