/*Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words. 


Example 1:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung",
"mobile","ice","cream", "icecream", "man",
"go", "mango" }, A = "ilike"
Output: 1
Explanation: The string can be segmented as
"i like".
Example 2:

Input: 
n = 12 
B = { "i", "like", "sam", "sung", "samsung",
"mobile","ice","cream", "icecream", "man", 
"go", "mango" }, A = "ilikesamsung" 
Output: 1
Explanation: The string can be segmented as 
"i like samsung" or "i like sam sung".

Your Task:
Complete wordBreak() function which takes a string and list of strings as a parameter and returns 1 if it is possible to break words, else return 0. You don't need to read any input or print any output, it is done by driver code.


Expected time complexity: O(n*l+|A|2) where l is the leght of longest string present in the dictionary and |A| is the length of string A
Expected auxiliary space: O(|A| + k) , where k = sum of length of all strings present in B

 

Constraints:
1 <= N <= 12
1 <= s <=1000 , where s = length of string A
 The length of each word is less than 15.*/
 class Solution{
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
    public static boolean search(String key,Node root){
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
    public static boolean wordBreakRecur(String A,Node root){
        if(A.length()==0){
            return true;
        }
        for(int i=1;i<=A.length();i++){
            String firstPart=A.substring(0,i);
            String secPart=A.substring(i);
            if(search(firstPart,root) && wordBreakRecur(secPart,root)){
                return true;
            }
        }
        return false;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Node root=new Node();
        for(int i=0;i<B.size();i++){
            insert(B.get(i),root);
        }
        if(wordBreakRecur(A,root)){
            return 1;
        }
        return 0;
    }
}