class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>res=new ArrayList<>();
        int n=expression.length();
        for(int i=0;i<n;i++){
            char c=expression.charAt(i);
            if(c=='+' || c=='*' || c=='-'){
                String left=expression.substring(0,i);
                String right=expression.substring(i+1);
                List<Integer>ansAtLeft=diffWaysToCompute(left);
                List<Integer>ansAtRight=diffWaysToCompute(right);

                for(int j=0;j<ansAtLeft.size();j++){
                    for(int k=0;k<ansAtRight.size();k++){
                        if(c=='+'){
                            res.add(ansAtLeft.get(j)+ansAtRight.get(k));
                        }
                         if(c=='-'){
                            res.add(ansAtLeft.get(j)-ansAtRight.get(k));
                        }
                         if(c=='*'){
                            res.add(ansAtLeft.get(j)*ansAtRight.get(k));
                        }
                    }
                }
            }
           
        }
         if(res.isEmpty()){
                res.add(Integer.parseInt(expression));
            }
        return res;

        
    }
}