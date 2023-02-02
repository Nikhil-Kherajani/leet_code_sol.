class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
    int l1 = num1.length();
    int l2 = num2.length();

    int[] res = new int[l1 + l2];

    int i = l1 - 1;
    int pf = 0;

    while (i >= 0) {
      int ival = i >= 0 ? num1.charAt(i) - '0' : 0;
      i--;

      int j = l2 - 1;
      int k = res.length - 1 - pf;

      int carry = 0;
      while (j >= 0 || carry != 0) {
        int jval = j >= 0 ? num2.charAt(j) - '0' : 0;
        j--;

        int prod = ival * jval + carry + res[k];
        res[k] = prod % 10;
        carry = prod / 10;
        k--;
      }
      pf++;
    }

    boolean flag = false;
    String str = "";
    for (int val : res) {
      if (val == 0 && flag == false) {
        continue;
      } else {
        flag = true;
        str += val;
      }
    }
    return str;
    }
}