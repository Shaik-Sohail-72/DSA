/*Given a string s, return the number of distinct substrings of s.

A substring of a string is obtained by deleting any number of characters (possibly zero) from the front of the string and any number (possibly zero) from the back of the string.

 

Example 1:

Input: s = "aabbaba"
Output: 21
Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]
Example 2:

Input: s = "abcdefg"
Output: 28
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 

Follow up: Can you solve this problem in O(n) time complexity?*/

// Approach
// Find all suffix of string
// create a trie from suffix
// count nodes of the trie. 
// :- total number of nodes = count of unique prefix

class p126{
    static class Node{
        Node children[];
        boolean eow;
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }
    static int total=0;
    public static void insert(String word,Node root){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }
    public static void countUnique(Node root){
        if(root==null){
            return;
        }
        Node curr=root;
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null){
                countUnique(curr.children[i]);
                total++;
            }
        }
    }
    public static void main(String [] args){
        Node root=new Node();
        String str="abcdefg";
        for(int i=0;i<str.length();i++){
            String suff=str.substring(i);
            insert(suff,root);
        }
        countUnique(root);
        System.out.println(total);
    }
}