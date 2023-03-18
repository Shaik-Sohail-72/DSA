/*Write an efficient program to print all the duplicates and their counts in the input string 
Example 1:

Input: "test string"
Output: 
s, count = 2 
t, count = 3 
*/
import java.util.*;
class print_all_duplicates{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Map<Character,Integer> m=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(!m.containsKey(s.charAt(i))){
                m.put(s.charAt(i),1);
            }else{
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            }
        }
        for(char c:m.keySet()){
            if(m.get(c)>1){
                System.out.println(c+" ,count = "+m.get(c));
            }
        }
    }
}

