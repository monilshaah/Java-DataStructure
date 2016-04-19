package arrays;

/**
 * Created by Monil on 4/18/16.
 *
 *  http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/
 */
public class SearchRotatedArray {


    /**
     * Recursive search
     *
     */
    public int searchRecursive(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        if(left>right)
            return -1;

        int mid = left + (right-left)/2;

        if(target == nums[mid])
            return mid;

        if(nums[left] <= nums[mid]){
            if(nums[left]<=target && target<nums[mid]){
                return binarySearch(nums,left, mid-1, target);
            }else{
                return  binarySearch(nums, mid+1, right, target);
            }
        }else {
            if(nums[mid]<target&& target<=nums[right]){
                return  binarySearch(nums,mid+1, right, target);
            }else{
                return  binarySearch(nums, left, mid-1, target);
            }
        }
    }


    /**
     *
     * Iterative Search
     */
    public int searchIteractive(int[] nums, int target) {
        int left = 0;
        int right= nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(target==nums[mid])
                return mid;

            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<target&& target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }


    /**
     * Iteractive search with duplicates
     *
     * http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/
     *
     */
    public boolean searchIteractiveWithDuplicates(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return true;

            if(nums[left]<nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                left++;
            }
        }

        return false;
    }
}
