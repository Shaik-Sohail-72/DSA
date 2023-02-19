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
            for(int j = 0 ;j<len;j++){
                if((i &( 1<<j)) >0)
                    sb.setCharAt(j,'1');
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