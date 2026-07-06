class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
    // 1. Sort: Start asc, then End DESCENDING (crucial for this problem)
    Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

    int count = 0;
    int currentEnd = 0;

    for (int[] interval : intervals) {
        // If the current interval extends beyond the previous "max" end,
        // it is not covered.
        if (interval[1] > currentEnd) {
            count++;
            currentEnd = interval[1];
        }
        // If interval[1] <= currentEnd, it is covered, so we do nothing (count doesn't increase)
    }
    return count;
}
}