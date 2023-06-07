import java.util.*;

class Solution {
    public int minFlips(int a, int b, int c) {
        StringBuilder aa = new StringBuilder();
        for (int i = 0; i < 30 - Integer.toBinaryString(a).length(); i++) {
            aa.append(0);
        }
        aa.append(Integer.toBinaryString(a));
        StringBuilder bb = new StringBuilder();
        for (int i = 0; i < 30 - Integer.toBinaryString(b).length(); i++) {
            bb.append(0);
        }
        bb.append(Integer.toBinaryString(b));
        StringBuilder cc = new StringBuilder();
        for (int i = 0; i < 30 - Integer.toBinaryString(c).length(); i++) {
            cc.append(0);
        }
        cc.append(Integer.toBinaryString(c));
        int or = a | b;
        StringBuilder orr = new StringBuilder();
        for (int i = 0; i < 30 - Integer.toBinaryString(or).length(); i++) {
            orr.append(0);
        }
        orr.append(Integer.toBinaryString(or));

        // for(int i = 0 ; i < aa.length())
        // System.out.println(aa.toString());
        // System.out.println(bb.toString());
        // System.out.println(cc.toString());
        // System.out.println(orr.toString());
        int ans = 0;
        for (int i = 29; i >= 0; i--) {
            if (orr.charAt(i) != cc.charAt(i)) {
                if (cc.charAt(i) == '1' && orr.charAt(i) == '0') {
                    ans++;
                } else {
                    if (aa.charAt(i) == '1' && bb.charAt(i) == '1') {
                        ans += 2;
                    } else {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}