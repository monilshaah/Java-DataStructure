package arrays;

import java.util.*;

/**
 * Created by Monil on 4/18/16.
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, 1, -4};

        System.out.println(threeSum(a, 0));

        System.out.println(threeSumClosest(a, 1));

        System.out.println(fourSumWithGenericMethod(a, 4));

        System.out.println(kSum(a, 5, 0));
    }


    /**
     *
     *  http://www.programcreek.com/2012/12/leetcode-3sum/
     *
     *  A better solution is using two pointers instead of one. This makes time complexity of O(n^2).
     *
     * To avoid duplicate, we can take advantage of sorted arrays, i.e., move pointers by >1 to use same element only once.
     *
     *
     * time complexity: O(n^2)
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num.length < 3)
            return result;

        // sort array
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || num[i] > num[i - 1]) {

                int rem = target - num[i];

                int start = i + 1;
                int end = num.length - 1;

                while (start < end) {
                    //case 1
                    if (num[start] + num[end] == rem) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && num[end] == num[end + 1])
                            end--;

                        while (start < end && num[start] == num[start - 1])
                            start++;
                        //case 2
                    } else if (num[start] + num[end] < rem) {
                        start++;
                        //case 3
                    } else {
                        end--;
                    }
                }

            }
        }

        return result;
    }

    /**
     *  http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
     *
     *  Time complexity: O(n^2)
     */
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if(diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }


    /**
     *  http://lifexplorer.me/leetcode-3sum-4sum-and-k-sum/
     *
     *  we combine every 2 twoSum-pairs to see if their sum is equal to target.
     *
     * Time complexity: O(N^2 logN) time complexity, because it utilizes twoSum whose time complexity is O(N logN), and map.containsKey requires O(logN) time.
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
        // Since we use set here, we don't need to dedup data
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(num);
        Map<Integer, Set<Pair>> map = new HashMap<Integer, Set<Pair>>();
        for (int i=0; i<num.length; i++) {
            // Note the order of these two for-loops is critical
            for (int j=i+1; j<num.length; j++) {
                int pairSum = num[i] + num[j];
                if (map.containsKey(target - pairSum)) {
                    for (Pair p : map.get(target - pairSum)) {
                        List l = new LinkedList();
                        l.add(p.first);
                        l.add(p.second);
                        l.add(num[i]);
                        l.add(num[j]);
                        result.add(l);
                    }
                }
            }
            for (int j=0; j<i; j++) {
                int a = num[j], b = num[i];
                if (!map.containsKey(a+b)) {
                    map.put(a+b, new HashSet());
                }
                map.get(a+b).add(new Pair(a, b));
            }
        }
        return new ArrayList<List<Integer>>(result);
    }



    /**
     * http://lifexplorer.me/leetcode-3sum-4sum-and-k-sum/
     *
     * generic K-sum method
     *
     *  Time complexity:  O(n^(k/2) * logn) when even k
     *                  or O(n^((k-1)/2+1)) when odd k
     *
     */

    static List<List<Integer>> rt = new LinkedList<List<Integer>>();

    public static List<List<Integer>> fourSumWithGenericMethod(int[] num, int target) {
        Arrays.sort(num);
        return kSum(num, 4, target);
    }

    private static List<List<Integer>> kSum(int[] n, int k, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        if (n.length < k) {
            return new LinkedList<List<Integer>>(result);
        }
        int patch = k % 2;

        List<List> sumHalf = combine((k - patch) / 2, 0, n.length - 1);
        HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();

        for (List<Integer> l : sumHalf) {
            int sum = sumList(l, n);
            if (!map.containsKey(sum)) {
                map.put(sum, new LinkedList<List<Integer>>());
            }
            map.get(sum).add(0, l);
        }

        if (patch == 0) {
            for (Integer i : map.keySet()) {
                if (map.containsKey(target - i)) {
                    for (List<Integer> li : map.get(i)) {
                        for (List<Integer> lj : map.get(target - i)) {
                            if (li.get(li.size() - 1) >= lj.get(0)) {
                                break;
                            }
                            List element = new LinkedList();
                            for (Integer id : li) {
                                element.add(n[id]);
                            }
                            for (Integer id : lj) {
                                element.add(n[id]);
                            }
                            result.add(element);
                        }
                    }
                }
            }
        }
        else {
            for (int split = 0; split < n.length; split ++) {
                for (Map.Entry<Integer, List<List<Integer>>> i : map.entrySet()) {
                    int wanted = target - i.getKey() - n[split];
                    if (map.containsKey(wanted)) {
                        for (List<Integer> li : i.getValue()) {
                            if (li.get(li.size() - 1) >= split) {
                                continue;
                            }
                            for (List<Integer> lj : map.get(wanted)) {
                                if (lj.get(0) <= split) {
                                    break;
                                }
                                List element = new LinkedList();
                                for (Integer id : li) {
                                    element.add(n[id]);
                                }
                                element.add(n[split]);
                                for (Integer id : lj) {
                                    element.add(n[id]);
                                }
                                result.add(element);
                            }
                        }
                    }
                }
            }
        }

        return new LinkedList<List<Integer>>(result);
    }

    // get the index combinations with size k from [start, end]
    private static List<List> combine(int k, int start, int end) {
        rt.clear();
        combineHelper(k, start, end, new ArrayList());
        return new ArrayList<List>(rt);
    }
    private static void combineHelper(int k, int start, int end, ArrayList comb) {
        if (k == 0) {
            rt.add(new ArrayList(comb));
            return;
        }
        for (int i = start; i <= end; i ++) {
            comb.add(i);
            combineHelper(k - 1, i + 1, end, comb);
            comb.remove(comb.size() - 1);
        }
    }

    private static int sumList(List<Integer> tup, int[] num) {
        int sum = 0;
        for (Integer i : tup) {
            sum += num[i];
        }
        return sum;
    }

    /** -- Generic K-sum ends -- */
}

/**
 * Used for foursum() method above
 */
class Pair {
    Integer first;
    Integer second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public int hashCode() {
        return this.first.hashCode() + this.second.hashCode();
    }
    @Override
    public boolean equals(Object d){
        if (!(d instanceof Pair)) {
            return false;
        }
        Pair p = (Pair) d;
        return (this.first == p.first) && (this.second == p.second);
    }
}
