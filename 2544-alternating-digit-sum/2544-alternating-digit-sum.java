class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int copy = n;
        int size = 0;
        while (copy > 0) {
            copy = copy / 10;
            size++;
        }
        while (n > 0) {
            int lastDigit = n % 10;
            if (size % 2 == 0) {
                sum += -lastDigit;
            } else {
                sum += lastDigit;
            }
            size--;
            n = n / 10;
        }
        return sum;
    }
}