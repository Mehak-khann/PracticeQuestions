class Solution {
    public void spilt(int val,List<Integer>ans ){
        // int count=0;
        List<Integer>temp=new ArrayList<>();
        while(val>0){
            // count++;
            int last=val%10;
            temp.add(last);
            val=val/10;
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        List<Integer>res=new ArrayList<>();
        // List<Integer>temp=new ArrayList<>();

        for(int i=0;i<n;i++){
            spilt(nums[i],res );
        }
        int m=res.size();
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}