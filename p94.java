/*Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.

 

Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.
Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.
Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
 

Constraints:

1 <= words1.length, words2.length <= 1000
1 <= words1[i].length, words2[j].length <= 30
words1[i] and words2[j] consists only of lowercase English letters.*/
class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> m1=new HashMap<>();
        Map<String,Integer> m2=new HashMap<>();
        for(int i=0;i<words1.length;i++){
            if(!m1.containsKey(words1[i])){
                m1.put(words1[i],1);
            }else{
                m1.put(words1[i],m1.get(words1[i])+1);
            }
        }
        for(int i=0;i<words2.length;i++){
            if(!m2.containsKey(words2[i])){
                m2.put(words2[i],1);
            }else{
                m2.put(words2[i],m2.get(words2[i])+1);
            }
        }
        int c=0;
        Set<String> s=m1.keySet();
        for(String s1:s){
            if(m2.containsKey(s1) && m1.get(s1)==1 && m2.get(s1)==1){
                c++;
            }
        }
        return c;
    }
}