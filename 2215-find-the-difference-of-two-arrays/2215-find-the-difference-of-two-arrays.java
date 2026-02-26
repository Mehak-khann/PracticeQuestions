// import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            s2.add(nums2[i]);
        }
        for (int i = 0; i < n; i++) {
            s1.add(nums1[i]);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        for (int x : s1) {
            if (!s2.contains(x)) {
                res.add(x);
            }
        }
        ans.add(res);
        
        List<Integer> res1 = new ArrayList<>();
        for (int x : s2) {
            if (!s1.contains(x)) {
                res1.add(x);
            }
        }
        ans.add(res1);
        
        return ans;
    }
}
