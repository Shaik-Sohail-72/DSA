/*Given a sentence in the form of a string, convert it into its equivalent mobile numeric keypad sequence. 
 

Mobile-keypad

Examples : 

Input: GEEKSFORGEEKS
Output: 4333355777733366677743333557777
Explanation: For obtaining a number, we need to press a number corresponding to that character for a number of times equal to the position of the character. For example, for character E, press number 3 two times and accordingly.


Input : HELLO WORLD
Output : 4433555555666096667775553*/
import java.util.*;
class p33{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String res="";
        String arr[]={"2","22","222","3","33","333",
                    "4","44","444","5","55","555",
                    "6","66","666","7","77","777","7777",
                    "8","88","888","9","99","999","9999"};
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                res+="0";
            }else{
                //System.out.println('A'-0);
                int pos=s.charAt(i)-'A';
                res+=arr[pos];
            }
        }
        System.out.println(res);
    }
}
