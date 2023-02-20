/*An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples : 

Input: 
9
-12 11 -13 -5 6 -7 5 -3 -6

Output: -12 -13 -5 -7 -3 -6 11 6 5

Note: Order of elements is not important here.*/
import java.util.*;
class p23{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int l=0;
        int r=n-1;
        while(l<=r){
            if(arr[r]>0){
                r--;
            }else if(arr[l]<0){
                l++;
            }else if(arr[l]>0 && arr[r]<0){
                int temp=arr[r];
                arr[r]=arr[l];
                arr[l]=temp;
                l++;
                r--;
            }else{
                l++;
                r--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}