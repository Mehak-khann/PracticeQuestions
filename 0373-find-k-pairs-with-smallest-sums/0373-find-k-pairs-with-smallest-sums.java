class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
       List<List<Integer>>res=new ArrayList<>();
       if(n==0 || nums2.length==0 || k==0) return res;
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       Set<String>visited=new HashSet<>();
       pq.add(new int[]{nums1[0]+nums2[0],0,0});
       visited.add("0,0");
       while(k-->0 && !pq.isEmpty()){
        int[] curr=pq.poll();
        int i=curr[1];
        int j=curr[2];
        res.add(Arrays.asList(nums1[i],nums2[j]));
        if(j+1<nums2.length && !visited.contains(i+","+(j+1))){//not--->"i,j+1"
            pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
            visited.add(i+","+(j+1));
        }
        if(i+1<n && !visited.contains((i+1)+","+j)){
            pq.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
            visited.add((i+1)+","+j);
        }
       }
       return res;
    }
}