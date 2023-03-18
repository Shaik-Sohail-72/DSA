/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> mainls=new ArrayList<>();
        Map<String,List<String>> m=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String val=strs[i];
            char arr[]=strs[i].toCharArray();
            Arrays.sort(arr);
            String temp=new String(arr);
            m.computeIfAbsent(temp,k->new ArrayList<>()).add(val);
        }
        for(Map.Entry<String,List<String>> e:m.entrySet()){
            mainls.add(e.getValue());
        }
        return mainls;
    }
}