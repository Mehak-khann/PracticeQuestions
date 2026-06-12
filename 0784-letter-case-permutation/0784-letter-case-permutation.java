class Solution {
    public void Permutation(String s,StringBuilder a,int i,ArrayList<String>l){

        if(i==s.length()){
            l.add(a.toString());
            return;
        }
        if(i>s.length()){
            return;
        }
       if (Character.isLetter(s.charAt(i))) {
            char ch = s.charAt(i);
            a.append(Character.toLowerCase(ch));
            Permutation(s,a,i+1,l);
            a.deleteCharAt(a.length() - 1);

            a.append(Character.toUpperCase(ch));
            Permutation(s,a,i+1,l);
            a.deleteCharAt(a.length() - 1);
        }
        else{
            a.append(s.charAt(i));
            Permutation(s,a,i+1,l);
                        a.deleteCharAt(a.length() - 1);

        }


    }
    public List<String> letterCasePermutation(String s) {
       int n=s.length();
       ArrayList<String>l = new ArrayList<>();
       StringBuilder sb=new StringBuilder();
       Permutation(s,sb,0,l);
       return l;

    }
}