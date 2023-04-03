/*Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"
 

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.*/
class Solution {
    public String toLowerCase(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=90){
                res+=(char)(s.charAt(i)+32);
            }else{
                res+=s.charAt(i);
            }
        }
        return res;  
    }
}