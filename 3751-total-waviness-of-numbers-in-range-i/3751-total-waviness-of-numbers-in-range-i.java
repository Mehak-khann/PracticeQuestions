class Solution {
    int numOfDigit(int n) {
        int c = 0;
        int temp = n; // Use temp to preserve n
        if (temp == 0) return 1;
        while (temp > 0) {
            c++;
            temp = temp / 10;
        }
        return c;
    }

    // Changed to return int (count) instead of boolean as a single number can contain multiple peaks and multiple value  bbollean was good until a number contain single peak or single valley or both peak and valley but not 2 peaks 1 valleys , 3 peaks and so on
    int countWaviness(int nums) {
        int digit = numOfDigit(nums);
        if (digit < 3) return 0;
          
        int[] arr = new int[digit];
        int temp = nums; 
        for(int i = digit - 1; i >= 0; i--) {
            arr[i] = temp % 10;
            temp = temp / 10;
        }
        
        int count = 0;
        for(int i = 1; i < digit - 1; i++) {
            if((arr[i] < arr[i-1] && arr[i] < arr[i+1]) || 
               (arr[i] > arr[i-1] && arr[i] > arr[i+1])) {
                count++;
            }
        }
        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int totalSum = 0;
        for(int i = num1; i <= num2; i++) {
            totalSum += countWaviness(i);
        }
        return totalSum;
    }
}