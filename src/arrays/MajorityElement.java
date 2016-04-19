package arrays;

/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2014/02/leetcode-majority-element-java/
 *
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int result = 0, count = 0;

        for(int i = 0; i<nums.length; i++ ) {
            if(count == 0){
                result = nums[ i ];
                count = 1;
            }else if(result == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        return result;
    }
}
