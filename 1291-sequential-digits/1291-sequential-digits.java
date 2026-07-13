class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>l=new ArrayList<>();
        String s="123456789";
        String lo=low+"";
        String hi=high+"";
        int n1=lo.length();
        int n2=hi.length();
        int count=n1;
        int i=0;
        int j=n1-1;
        for(int k=0;k<=(n2-n1);k++){
            i=0;
            j=count-1;
            while(j<s.length()){
            int val=Integer.parseInt(s.substring(i,j+1));
            if(val>=low && val<=high){
l.add(val);
        }
i++;
            j++;
            }
            count++;
        
    }
        return l;
    }
}
/*

class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int> res;
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            for (int j = i + 1; j <= 9; ++j) {
                num = num * 10 + j;
                if (num >= low && num <= high)
                    res.push_back(num);
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};

*/