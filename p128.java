/*Given an array of words, find all shortest unique prefixes to represent each word in the given array. Assume that no word is prefix of another.

Example 1:

Input: 
N = 4
arr[] = {"zebra", "dog", "duck", "dove"}
Output: z dog du dov
Explanation: 
z => zebra 
dog => dog 
duck => du 
dove => dov 
Example 2:

Input: 
N = 3
arr[] =  {"geeksgeeks", "geeksquiz",
                       "geeksforgeeks"};
Output: geeksg geeksq geeksf
Explanation: 
geeksgeeks => geeksg 
geeksquiz => geeksq 
geeksforgeeks => geeksf
Your task:
You don't have to read input or print anything. Your task is to complete the function findPrefixes() which takes the array of strings and it's size N as input and returns a list of shortest unique prefix for each word
 
Expected Time Complexity: O(N*length of each word)
Expected Auxiliary Space: O(N*length of each word)
 
Constraints:
1 ≤ N, Length of each word ≤ 1000*/
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
public class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        TrieNode root=new TrieNode();
        String res[]=new String[N];
        for(int i=0;i<N;i++){
            insert(arr[i],root);
        }
        for(int i=0;i<N;i++){
            res[i]=find(arr[i],root);
        }
        return res;
    }
    static void insert(String word,TrieNode root){
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
    static String find(String key,TrieNode root){
        TrieNode curr=root;
        String ans="";
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            ans+=key.charAt(i);
            curr=curr.children[idx];
            if(curr.freq<=1){
                break;
            }
        }
        return ans;
    }
};