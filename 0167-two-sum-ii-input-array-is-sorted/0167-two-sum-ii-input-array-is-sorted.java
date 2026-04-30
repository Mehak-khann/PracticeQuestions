class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        int n = numbers.length;
        int i=0;
        int j=n-1;
        int val=numbers[i]+numbers[j];
  
        while(i<j){
            if(target==val){
                  res[0]=i+1;
                res[1]=j+1;
                break;
            }
            else if(target>val){
                 val-=numbers[i];
                i++;
                val+=numbers[i];
            }
            else{
               val-=numbers[j];
                j--;
                val+=numbers[j];
            }

        }
        return res;
    }
}