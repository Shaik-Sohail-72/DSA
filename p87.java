/*You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.*/
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<stones.length();i++){
            if(!m.containsKey(stones.charAt(i))){
                m.put(stones.charAt(i),1);
            }else{
                m.put(stones.charAt(i),m.get(stones.charAt(i))+1);
            }
        }
        int res=0;
        for(int i=0;i<jewels.length();i++){
            if(m.containsKey(jewels.charAt(i)))
            {
               res+=m.get(jewels.charAt(i)); 
            }
        }
        return res;
    }
}