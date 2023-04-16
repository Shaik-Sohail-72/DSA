/*Trie is an efficient information retrieval data structure. Use this data structure to store Strings and search strings. Your task is to use TRIE data structure and search the given string A. If found print 1 else 0.

Example 1:

Input:
N = 8
key[] = {the,a,there,answer,any,by,
         bye,their}
search = the
Output: 1
Explanation: the is present in the given
string "the a there answer any by bye
their"
Example 2:

Input:
N = 8
key[] = {the,a,there,answer,any,by,
         bye,their}
search = geeks
Output: 0
Explanation: geeks is not present in the
given string "the a there answer any by
bye their"
Your Task:
Complete insert and search function and return true if key is present in the formed trie else false in the search function. (In case of true, 1 is printed and false, 0 is printed by the driver's code.

Expected Time Complexity: O(M+|search|).
Expected Auxiliary Space: O(M).
M = sum of the length of all strings which is present in the key[] 

|search| denotes the length of the string search.

Constraints:
1 <= N <= 104
1 <= |input strings|, |A| <= 100*/
import java.util.*;
class trie{
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
    static Node root=new Node();
    public static void insert(String word){
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
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(i==key.length()-1 && curr.children[idx].eow==false){
                return false;
            } 
            curr=curr.children[idx];
        }
        return true;
        
    }
    public static void main(String[] args){
        String words[]={"the","a","there","answer","any","by","bye","their"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("the"));
        System.out.println(search("sohail"));
    }
}