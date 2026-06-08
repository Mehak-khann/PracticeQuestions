class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer>l1=new ArrayList<>();
        ArrayList<Integer>l2=new ArrayList<>();
        int c=0;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                l1.add(nums[i]);
            }
            if(nums[i]==pivot){
                c++;
            }
            if(nums[i]>pivot){
                l2.add(nums[i]);
            }
        }
        for(int i=0;i<l1.size();i++){
            nums[i]=l1.get(i);
        }
        // nums[l1.size()]=pivot;
        for(int i=0;i<c;i++){
            nums[l1.size()+i]=pivot;
        }
        for(int i=0;i<l2.size();i++){
            nums[l1.size()+i+c]=l2.get(i);
        }
        return nums;
    }
}