package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 *

 The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals. And then merge some intervals.

 The take-away message from this problem is utilizing the advantage of sorted list/array.

 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" +  this.start + "," + this.end + "]";
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println("Merging:: " + intervals);

        intervals = merge(intervals);

        System.out.println("Merged:: " + intervals);

        System.out.println("Inserting [4,9]");

        System.out.println("Inserted:: " + insert(intervals, new Interval(4, 9)));
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1)
            return intervals;

        // sort intervals by using self-defined Comparator
        Collections.sort(intervals, new IntervalComparator());

        ArrayList<Interval> result = new ArrayList<Interval>();

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if (prev.end >= curr.start) {
                // merged case
                Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merged;
            } else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);

        return result;
    }


    /**
     *  http://www.programcreek.com/2012/12/leetcode-insert-interval/
     *
     *  Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
     */
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        result.add(newInterval);

        return result;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}
