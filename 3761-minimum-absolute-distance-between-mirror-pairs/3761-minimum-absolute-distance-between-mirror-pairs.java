class Solution {
    public int reverse(int n){
        int rev=0;
        while(n>0){
            int last=n%10;
            rev=rev*10+last;
            n=n/10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
      int n= nums.length;
      HashMap<Integer,Integer>mp=new HashMap<>();
      int absolute=Integer.MAX_VALUE;
        mp.put(reverse(nums[0]),0);
      for(int i=1;i<n;i++){
        if(mp.containsKey(nums[i])){
            absolute=Math.min(absolute,Math.abs(i-mp.get(nums[i])));
        }
        
            mp.put(reverse(nums[i]),i);
        
      }
      if(absolute==Integer.MAX_VALUE){
        return -1;
      }
      return absolute;
    }
}