/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".


Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String rstr = strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<rstr.length()){
                rstr = strs[i];
            }
        }
        String res = "";
        boolean flag = true;
        for(int i=0;i<rstr.length();i++){
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=rstr.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res = res+rstr.charAt(i);
            }else{
                break;
            }
        }
        return res;
    }
}

// Another Approach Using Trie
class TrieNode{
    TrieNode children[];
    int freq;
    TrieNode(){
        children=new TrieNode[26];
        for(int i=0;i<26;i++){
            children[i]=null;
        }
        freq=0;
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root=new TrieNode();
        String ans="";
        for(int i=0;i<strs.length;i++){
            insert(strs[i],root);
        }
        return find(strs[0],root,strs);
    }
    public static void insert(String word,TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
            curr.freq++;
        }
    }
    public static String find(String key,TrieNode root,String[] strs){
        TrieNode curr=root;
        String res="";
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            curr=curr.children[idx];
            if(curr.freq<strs.length){
                break;
            }
            res+=key.charAt(i);
        }
        return res;
    }
}