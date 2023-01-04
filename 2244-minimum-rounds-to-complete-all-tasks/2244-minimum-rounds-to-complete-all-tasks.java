import java.util.Arrays;

class Solution {
    public int minimumRounds(int[] tasks) {

        Arrays.sort(tasks);
        int ans = 0;
        int temp = tasks[0];
        int count = 1;
        for (int i = 1; i < tasks.length; i++) {
            // System.out.println(tasks[i] + " " + count + ans);
            if (tasks[i] == temp) {
                count++;
            } else {
                if (count == 1) {
                    return -1;

                } else if (count == 2) {
                    ans += 1;

                }
                // else if (count == 3) {
                // ans += 1;

                // }
                else if (count == 4) {
                    ans += 2;

                } else if (count % 3 == 0) {
                    ans += count / 3;
                } else if (count % 3 == 1 || count % 3 == 2) {
                    ans += count / 3 + 1;
                }
                if (i != tasks.length)
                    count = 1;
                temp = tasks[i];
            }
        }
        if (count > 0) {
            if (count == 1) {
                return -1;

            }
            if (count == 2) {
                ans += 1;
                return ans;
            }
            if (count == 3) {
                ans += 1;
                return ans;
            }
            if (count == 4) {
                ans += 2;
                return ans;
            }
            if (count % 3 == 0) {
                ans += count / 3;
            } else if (count % 3 == 1 || count % 3 == 2) {
                // System.out.println(ans);
                ans += count / 3 + 1;
            }
        }

        return ans;
    }
}