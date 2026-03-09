//self approach (but not working)
// class Solution {
// public:
// vector<int> findAnagrams(string s, string p) {
//     int i=0;
//     int n=s.length();
//     int j=0;
//     bool flag =false;
//     vector<int>v;
//     unordered_map<char,int>mp;
//     while(j<n){
//         mp[s[j]]++;
//         while((j-i+1)>p.length()){
//             mp[s[i]]--;
//             if(mp[s[i]]==0){
//                 mp.erase(s[i]);
//             }
//             i++;
//         }
//         if(j-i+1 ==p.length()){
//             flag=false;
//             for(int k=0;k<p.length();k++){
//                 if(mp.find(p[k])!=mp.end()){
//                     mp[p[k]]--;
//                     if(mp[p[k]]==0){
//                         mp.erase(p[k]);
//                     }
//                 }
//                 else{
//                     break;
//                 }
//                 if(k==p.length()-1) flag=true;
//             }
//             if(flag==true){
//                 v.push_back(i);
//             }
//              i=i+1;
//              mp[s[i+1]]++;
//         }
//         j++;

//     }
//     return v;

// }
// };
// approach 1---using map
// class Solution {
// public:
//     vector<int> findAnagrams(string s, string p) {
//         int n=s.length();
//         int m=p.length();
//         unordered_map<char,int>Smp,Pmp;
//         for(int i=0;i<p.length();i++){
//             Pmp[p[i]]++;
//         }
//         int i=0;
//         int j=0;
//         vector<int>v;
//         while(j<n){
//             Smp[s[j]]++;
//             while((j-i+1)>m){
//                 Smp[s[i]]--;
//                 if(Smp[s[i]]==0){
//                     Smp.erase(s[i]);
//                 }
//                 i++;
//             }
//             if((j-i+1)==m){
//                 if(Smp==Pmp){
//                     v.push_back(i);
//                 }
//             }
//             j++;
//         }
//         return v;
//     }
// };
//approach 3---->using arrays
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
       int m=p.length();
       List<Integer>l=new ArrayList<>();
       int[] Smp =new int[26];
       int[] Pmp = new int[26];
       for(int i=0;i<m;i++){
        Pmp[p.charAt(i)-'a']++;
       }
       int i=0;
       int j=0;
       while(j<n){
        Smp[s.charAt(j)-'a']++;
        while((j-i+1)>p.length()){
            Smp[s.charAt(i)-'a']--;
            if(Smp[s.charAt(i)-'a']==0){
                Smp[s.charAt(i)-'a']=0;
            }
            i++;
        }
        if((j-i+1)==m){
            if(Arrays.equals(Smp,Pmp)){
                l.add(i);
            }
        }
        j++;
       }
       return l;
    }
}