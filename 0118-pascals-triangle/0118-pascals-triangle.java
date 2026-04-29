import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        // In Java, we use List of Lists for dynamic 2D structures
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // If it's the first or last element of the row, it's always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Get the two values from the previous row
                    // prevRow[j] + prevRow[j-1]
                    int left = pascal.get(i - 1).get(j - 1);
                    int right = pascal.get(i - 1).get(j);
                    row.add(left + right);
                }
            }
            // Add the completed row to the main list
            pascal.add(row);
        }
        
        return pascal;
    }
}