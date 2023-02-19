/*Generate binary strings of length 'k' 

Example 1: 
input:
2
output:
[00, 01, 10, 11]

Example 2:
input:
3
output:
[000, 001, 010, 011, 100, 101, 110, 111]
*/
import java.util.*;
class p13{
    public static List<String> AllPossibleStrings(int len){
        List<String> ans= new ArrayList<>();
        for(int i = 0; i<(1<<len) ;i++){
            String res="";
            for(int k=0;k<len;k++){
                res+="0";
            }
            StringBuilder sb=new StringBuilder(res);
            int j=0;
            int temp=i;
            while(temp>0){
                if((temp&1)>0){
                    sb.setCharAt(j,'1');
                }
                j++;
                temp>>=1;
            }
            ans.add(sb.toString()) ;
        }
        Collections.sort(ans);
        return  ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        System.out.println(AllPossibleStrings(len));
    }
}
