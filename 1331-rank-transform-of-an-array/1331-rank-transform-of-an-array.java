class Solution {
    public int[] arrayRankTransform(int[] arr) {
                int n=arr.length;
                if(n==0){
                    return arr;
                }
        HashMap<Integer,Integer>mp =new HashMap<>();
        int[] temp =new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        List<Integer>l=new ArrayList<>();
        Arrays.sort(temp);
        l.add(temp[0]);
         for(int i=1;i<n;i++){
            if(temp[i]!=temp[i-1]){
                l.add(temp[i]);
            }
        }
        for(int i=0;i<l.size();i++){
            mp.put(l.get(i),i+1);
        }
    int[] res=new int[n];
    for(int i=0;i<n;i++){
        res[i]=mp.get(arr[i]);
    }
    return res;
    }
}