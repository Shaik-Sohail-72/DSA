class temp{
    /*public static void isHappy(int n) {
        if(n==1){
            return true;
        }else if(n==4){
            return false;
        }else{
            return isHappy(sod(n));
        }
    }*/
    public static void  sod(int n){
        int sum=0;
        while(n!=0){
            int temp=n%10;
            System.out.println(temp);
            sum+=temp;
            n/=10;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        sod(19);
    }
}