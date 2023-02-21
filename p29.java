/*Given an array of size n, generate and print all possible combinations of r elements in array. For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
Following are two methods to do this. 

Example 1:

Input:
n = 5
r = 3
Output: 
1 2 3 
1 2 4
1 3 4
2 3 4
1 2 5
1 3 5
2 3 5
1 4 5
2 4 5
3 4 5
Example 2:

Input:
n = 4
r = 2
Output: 
1 2 
1 3
2 3
1 4
2 4
3 4
*/
import java.util.*;
class a{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        int r=sc.nextInt();
        for(int i=1;i<(1<<n);i++){
            int j=0;
            List<Integer> ls=new ArrayList<>();
            int temp=i;
            while(temp>0){
                if((temp&1)>0){
                    ls.add(arr[j]);
                }
                j++;
                temp>>=1;
            }
            if(ls.size()==r){
                for(int ele:ls){
                    System.out.print(ele+" ");
                }
                System.out.println();
            }
        }
    }
}