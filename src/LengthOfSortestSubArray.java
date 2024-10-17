public class LengthOfSortestSubArray {
    public static int shortLength(int[] arr,int sol){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int k=i;k<arr.length;k++){
                sum+=arr[k];
                if(sum==sol){
                    int len=k-i+1;
                    if(min>len)
                        min=len;
                }
                if(sum>sol)
                    break;
            }
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 52, 4};
        int K = 50;
        System.out.println(shortLength(arr,K));

    }
}
