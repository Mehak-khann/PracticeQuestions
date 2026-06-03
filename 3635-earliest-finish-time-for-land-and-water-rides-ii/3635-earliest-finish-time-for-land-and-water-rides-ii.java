class Solution {
    public int solve(int[] start1, int[] finish1, int[] start2, int[] finish2){
        int val1=Integer.MAX_VALUE;
        for(int i=0;i<start1.length;i++){
            val1=Math.min(val1,start1[i]+finish1[i]);
        }
        int val2=Integer.MAX_VALUE;
        for(int i=0;i<start2.length;i++){
         int nextStart = Math.max(start2[i],val1);
           val2=Math.min(nextStart+finish2[i],val2);
        }

        return val2;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n =landStartTime.length;
        int m=waterStartTime.length;
        int land=solve(landStartTime,landDuration,waterStartTime,waterDuration);
        int water = solve(waterStartTime,waterDuration,landStartTime,landDuration);

        return Math.min(land,water);

    }
}