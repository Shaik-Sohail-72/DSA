/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.*/
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> hm=new HashMap<>();
        Map<Character,Integer> hm1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),1);
            }else{
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(!hm1.containsKey(t.charAt(i))){
                hm1.put(t.charAt(i),1);
            }else{
                hm1.put(t.charAt(i),hm1.get(t.charAt(i))+1);
            }
        }
        if(hm1.equals(hm)){
            return true;
        }else{
            return false;
        }
    }
}