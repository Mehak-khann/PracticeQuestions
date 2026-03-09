class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long sum = 0;
        long res = 0;
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        while (j < n) {
            sum += nums[j];
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            while (i < n && j - i + 1 > k) {
                sum -= nums[i];
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }
            if (mp.size() == (j - i + 1) && mp.size() == k) {
                res = Math.max(res, sum);
            }
            j++;
        }
        
        return res;
    }
}