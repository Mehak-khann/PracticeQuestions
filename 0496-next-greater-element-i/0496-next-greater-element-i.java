//Approach1--->musing nested array + hashmap and no stack
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int n=nums1.length;
//         int m=nums2.length;
//         HashMap<Integer,Integer>mp=new HashMap<>();
//         int[] ans=new int[n];
//         for(int i=0;i<m;i++){
//             mp.put(nums2[i],i);
//         }
//       //  Stack<Integer>st=new Stack<>();
        
        
//         for(int i=0;i<n;i++){
//             int key=nums1[i];
//             int val=mp.get(nums1[i]);
//             int found=-1;
//             for(int j=val+1;j<=m-1;j++){
//                 if(key<nums2[j]){
//                   //  ans[i]=st.peek();
//                   //  break;
//                  //   st.push(nums2[j]);
//                     found=nums2[j];
//                     break;
    
//             }
//             }
//                 ans[i]=found;
          
//         }
//         return ans;
//     }
// }
// approach2-->using stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] ans=new int[n];
HashMap<Integer,Integer>mp=new HashMap<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<m;i++){
            while(st.size()>0 && st.peek()<nums2[i]){
                mp.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums1[i])){
                ans[i]=mp.get(nums1[i]);
            }
            else ans[i]=-1;
        }
        return ans;
    }
}