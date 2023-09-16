/*Write a function solution that, given a string S of length N, returns any palindrome which can be obtained by replacing all of the question marks in S by lowercase letters (a'-'z'). If no palindrome can be obtained, the function should return the string "NO". A palindrome is a string that reads the same both forwards and backwards. Some examples of palindromes are: "kayak", "radar", "mom".

Examples:
1. Given S="?ab??a", the function should return "aabbaa".

2. Given S="bab??a", the function should return "NO".

3. Given S="?a?", the function may return "aaa". It may also return "zaz", among other possible answers.

Assume that:
N is an integer within the range [1..1,000]; 
string S consists only of lowercases letters ('a' - 'z') or '?'.*/


import java.util.*;
class expwrian1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(find(str));
    }
    public static String find(String s){
        int i=0;
        int j=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(i<j){
            if(s.charAt(i)!='?' && s.charAt(j)!='?' && s.charAt(i)!=s.charAt(j)){
                return "NO";
            }else if(s.charAt(i)=='?' && s.charAt(j)=='?'){
                sb.setCharAt(i, 'a');
                sb.setCharAt(j,'a');
            }else if(s.charAt(i)!='?' && s.charAt(j)=='?'){
                sb.setCharAt(j, s.charAt(i));
            }else if(s.charAt(i)=='?' && s.charAt(j)!='?'){
                sb.setCharAt(i, s.charAt(j));
            }
            i++;
            j--;
        }
        return sb.toString();
    }
}