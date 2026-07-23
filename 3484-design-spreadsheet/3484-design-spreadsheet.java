class Spreadsheet {
    private int[][] sheet;
    public Spreadsheet(int rows) {
        sheet=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char ch = cell.charAt(0);
        int j=ch-'A';
        int i=Integer.parseInt(cell.substring(1,cell.length()))-1;
        sheet[i][j]=value;
    }
    
    public void resetCell(String cell) {
       char ch = cell.charAt(0);
        int j=ch-'A';
        int i=Integer.parseInt(cell.substring(1,cell.length()))-1;
        sheet[i][j]=0;
    }
    public int solve(String s){
        if(Character.isDigit(s.charAt(0))){
            return Integer.parseInt(s);
        }
        char ch  =s.charAt(0);
        int j=ch-'A';
        int i=Integer.parseInt(s.substring(1))-1;
        return sheet[i][j];
    }
    
    public int getValue(String formula) {
        String s =formula.substring(1);
        int idx = s.indexOf('+');
        String left = s.substring(0,idx);
        String right = s.substring(idx+1);
        // as string is not only 5+7 but also of type 7+B1...so we first need to evaluate B1 then add its value to 7
        return solve(left) + solve(right);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */