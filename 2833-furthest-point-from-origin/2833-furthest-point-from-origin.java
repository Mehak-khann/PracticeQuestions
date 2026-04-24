class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int n=s.length();
        int count=0;
        int[] freq=new int[2];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='L'){
                freq[0]++;
            }

            if(s.charAt(i)=='R'){
                freq[1]++;
            }
        }
        char ch='R';
        if(freq[0]>freq[1]){
            ch='L';
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='_'){
                sb.append(ch);
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='L'){
                count++;
            }
            else{
                count--;
            }
        }
        return  Math.abs(count);
    }
}