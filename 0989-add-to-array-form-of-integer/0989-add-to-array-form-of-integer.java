import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        LinkedList<Integer> sum = new LinkedList<>();
        int i;
        for (i = num.length - 1; i >= 0 || k > 0 || carry > 0; i--) {
            int digit = k % 10;
            if (i >= 0) {
                sum.addFirst((carry + num[i] + digit) % 10);
                carry = (carry + num[i] + digit) / 10;
            } else {
                sum.addFirst((carry + digit) % 10);
                carry = (carry + digit) / 10;
            }
            k = k / 10;
        }

        return sum;
    }
}