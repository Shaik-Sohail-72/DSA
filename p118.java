/*Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!m.containsKey(words[i])){
                m.put(words[i],1);
            }else{
                m.put(words[i],m.get(words[i])+1);
            }
        }
        List<String> ls=new ArrayList<>();
        ls.addAll(m.keySet());
        Collections.sort(ls,(a,b)-> m.get(a).equals(m.get(b)) ? a.compareTo(b) : m.get(b)-m.get(a));
        for(int i=ls.size()-1;i>=k;i--){
            ls.remove(ls.get(i));
        }
        return ls;
    }
}