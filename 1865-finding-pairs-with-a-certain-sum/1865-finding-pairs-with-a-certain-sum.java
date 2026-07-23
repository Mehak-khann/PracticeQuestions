class FindSumPairs {
    int[] n1;
    int[] n2;
            HashMap<Integer,Integer>mp;

    public FindSumPairs(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        n1=new int[size1];
        n2=new int[size2];
        n1=nums1;
        n2=nums2;
        mp=new HashMap<>();
        for(int i=0;i<size2;i++){
            mp.put(n2[i],mp.getOrDefault(n2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        mp.put(n2[index],mp.get(n2[index])-1);
        n2[index] += val;
        mp.put(n2[index],mp.getOrDefault(n2[index],0)+1);
    }
    
    public int count(int tot) {
      int c=0;
      for(int i=0;i<n1.length;i++){
        if(mp.containsKey(tot-n1[i])){
            c+=mp.get(tot-n1[i]);
        }
      }
      return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */