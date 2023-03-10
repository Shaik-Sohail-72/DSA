/*Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.*/
class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        String ans="";
        for(int i=0;i<arr.length;i++){
            ans+=rev(arr[i])+" ";
        }
        return ans.substring(0,ans.length()-1);
    }
    public String rev(String s){
        int m=0;
        int n=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(m<=n){
            sb.setCharAt(m,s.charAt(n));
            sb.setCharAt(n,s.charAt(m));
            m++;
            n--;
        }
        return sb.toString();
    }
}