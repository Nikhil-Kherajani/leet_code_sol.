class Solution {
    public int captureForts(int[] forts) {
        int one = -1;
        int minusone = -1;
        int ans = 0;
        int finalans = Integer.MIN_VALUE;
        for (int i = 0; i < forts.length; i++) {

            if (forts[i] == 1) {
                // System.out.println(ans + " " + finalans);
                one = i;
                if (minusone != -1) {
                    ans = ((Math.abs(minusone - one)) - 1);
                    finalans = Math.max(finalans, ans);
                    ans = 0;
                    // System.out.println(((Math.abs(minusone - one))- 1));
                    minusone = -1;
                }
            } else if (forts[i] == -1) {
                if (one != -1) {
                    ans = Math.abs(i - one) - 1;
                    finalans = Math.max(finalans, ans);
                    ans = 0;
                    one = -1;
                }
                minusone = i;
            }
        }
        return finalans == Integer.MIN_VALUE ? 0 : finalans;
    }
}