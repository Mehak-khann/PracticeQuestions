class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        TreeSet<Integer>dryDay =new TreeSet<>();

        int[] res=new int[n];

        for(int i=0;i<n;i++){
            res[i]=1;
        }
        for(int i=0;i<n;i++){
          int lake = rains[i]  ;
           if(lake==0){
            dryDay.add(i);
           }
           else{
            res[i]=-1;
            if(mp.containsKey(lake)){
                // lake already filled previously
                    Integer d = dryDay.higher(mp.get(lake));  // next dry day after it was last filled
            if(d==null){
                return new int[0];
            }

            res[d] = lake;
            dryDay.remove(d);
            }
            mp.put(lake,i);
           }
        }
        return res;
    }
}