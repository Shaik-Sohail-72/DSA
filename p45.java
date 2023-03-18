/*Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.

Example 2:

Input: 
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function secFrequent() which takes the string array arr[] and its size N as inputs and returns the second most frequent string in the array.


Expected Time Complexity: O(N*max(|Si|).
Expected Auxiliary Space: O(N*max(|Si|).*/
class Solution{
    String secFrequent(String arr[], int N){
        Map<String,Integer> m=new HashMap<>(); 
        for(int i=0;i<N;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }
        List<String> ls=new ArrayList<>();
        for(String i:m.keySet()){
            ls.add(i);
        }
        Collections.sort(ls,(a,b)->{
            return m.get(b)-m.get(a);
        });
        return ls.get(1);
    }
}