public class FindTheMedian {


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,9,10,11,12,13,14,15,16,17,18};
        System.out.println(findMedian(a,b));
    }

    private static double findMedian(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int totalLen=m+n;
        int median = totalLen/2;
        int min1=0;
        int max1=m-1;
        int median1=max1<median ? max1:median;
        double midIndex=0;
        while(min1<=median1){
            if(a[median1]<=b[median-median1]){
                    midIndex=median1;
                    break;
            }
            else {
                median1--;
            }

        }
        System.out.println("median="+median+" median1="+median1+"  median2="+(median-median1-1)+" totalLen="+totalLen);
        double solution=0;
        if(totalLen%2==0){

         solution= (a[median1]+b[median-median1-1])/2.0;
           // solution= (a[median1]+b[median-median1])/2;
        }
        System.out.println(solution);
return midIndex;
    }
}
