package arrays;

/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
 *
 * Solution 1: max heap
 *
 * Solution 2: Quick select
 */
public class KthLargest {

    /**
     * MaxHeap for Kth largest
     *
     *  Time complexity -> O(n) for heapifying n elements, O(log(n)) for restructuring heap after removing max. So, O(k*log(n))
     */
    public static int findKthLargestUsingHeap(int[] nums, int k) {
        // TODO: 4/18/16 - Implement Kth largest using maxheap (own Heap datastructure)
        return 0;
    }
    
    
    /**
     * Quickselect Algorithm - similar to quicksort
     *
     *  Time complexity -> average case O(n)    Worst case O(n^2)
     */
    public int findKthLargestUsingQuickSelect(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k +1, nums, 0, nums.length - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
}
