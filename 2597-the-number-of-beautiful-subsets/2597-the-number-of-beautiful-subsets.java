class Solution {
    
    public void backtracking(int[] nums, HashMap<Integer, Integer> mp, List<Integer> l, int i, int k, int[] count){
        // Base case: if we have gone through all elements
        if (i == nums.length) {
            return;
        }
        
        // --- CHOICE 1: SKIP the current element ---
        backtracking(nums, mp, l, i + 1, k, count);

        // --- CHOICE 2: PICK the current element ---
        // Check if either of the direct conflicting numbers are present in the map
        if (mp.getOrDefault(nums[i] - k, 0) == 0 && mp.getOrDefault(nums[i] + k, 0) == 0) {
            
            // 1. Add to the map and the list
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            l.add(nums[i]); 
            
            // 2. Increment count because the subset in list 'l' is valid
            count[0]++;
            
            // 3. Continue to the next element
            backtracking(nums, mp, l, i + 1, k, count);

            // 4. Backtrack: Undo the choice from both map and list
            mp.put(nums[i], mp.get(nums[i]) - 1);
            l.remove(l.size() - 1); // Remove the last added element
        }
    }  
    
    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        int[] count = new int[1]; 
        
        backtracking(nums, mp, l, 0, k, count);
        return count[0];
    }
}
