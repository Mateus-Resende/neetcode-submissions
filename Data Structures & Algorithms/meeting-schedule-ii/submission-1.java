/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() < 1) return 0;
        Integer size = intervals.stream().map(el -> el.end).max(Integer::compare).get();

        List<Integer> diffArray = new ArrayList<>(Collections.nCopies(size + 1, 0));

        for (Interval interval : intervals) {
            diffArray.set(interval.start, diffArray.get(interval.start) + 1);
            diffArray.set(interval.end, diffArray.get(interval.end) - 1);
        }

        int ans = 0, sum = 0;
        for (int i = 0; i < diffArray.size(); i++) {
            sum += diffArray.get(i);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
