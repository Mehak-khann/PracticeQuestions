// class Solution {
//     public int minimumCost(int[] cost) {
//         int n=cost.length;
//         int sum=0;
//         if(n==2){
//             return cost[0]+cost[1];
//         }
//         Arrays.sort(cost);
//         int a=cost[n-1];
//         int b=cost[n-2];
//         sum=a+b;
//         boolean flag=false;
//         for(int i=n-3;i>=0;i--){
//             if(flag==true){
//                 a=cost[i];
//                 b=cost[i+1];
//                 sum=sum+a+b;
//                 i--;
//             //flag=false;
//             }
//            else if(cost[i]<=Math.min(a,b)){
//                 flag=true;
//             }
//             else{
//                 flag=false;
//                 sum+=cost[i];
//                 a=cost[i-1];
//                 b=cost[i];
//             }
//         }
//         return sum;
//     }
// }
 
class Solution {
    public int minimumCost(int[] cost) {
  
        
        int n = cost.length;
        int totalCost = 0;
        int sum=0;
        if(n==2){
            return cost[0]+cost[1];
        }
        
        Arrays.sort(cost);
 
        for (int i = n - 1; i >= 0; i--) {
            // We buy the candy at i
            totalCost += cost[i];
            
            // If there is another candy, we buy it too
            if (i - 1 >= 0) {
                totalCost += cost[i - 1];
            }
            
            // Skip the third candy (the one at i-2)
            // Move index to the next group of 3
            i -= 2;
        }
        
        return totalCost;
    }
}