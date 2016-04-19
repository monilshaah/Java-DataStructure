package arrays;

/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 *

 If we see log(n), we should think about using binary something.

 This problem can be converted to the problem of finding kth element, k is (A's length + B' Length)/2.

 If any of the two arrays is empty, then the kth element is the non-empty array's kth element. If k == 0, the kth element is the first element of A or B.

 For normal cases(all other cases), we need to move the pointer at the pace of half of an array length to get log(n) time.

 Time complexity: O(log(m+n))
 */
public class KthElementOf2SortedArray {


    public static void main(String[] args) {
        int[] a = {2,7,8,9};
        int[] b = {1,3,4,5};
        int k = 5; // find 5th element
        System.out.println(findKth(a, b, k-1, 0, a.length-1, 0, b.length-1));
    }

    // TODO: 4/18/16 - Understand this algo
    public static int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}
