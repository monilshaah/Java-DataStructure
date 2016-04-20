package arrays;

/**
 * Created by Monil on 4/19/16.
 *
 * http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] A) {
        int newsum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
            newsum=Math.max(newsum+A[i],A[i]);
            max= Math.max(max, newsum);
        }
        return max;
    }
}
