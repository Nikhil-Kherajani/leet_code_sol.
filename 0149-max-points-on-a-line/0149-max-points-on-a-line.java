// import java.util.*;

// class Solution {
//     public int maxPoints(int[][] points) {
//         if (points.length == 1) {
//             return 1;

//         }
//         if (points.length == 2) {
//             return 2;
//         }

//         ArrayList<ArrayList<Float>> slopes = new ArrayList<>();
//         for (int i = 0; i < points.length; i++) {
//             ArrayList<Float> temp = new ArrayList<>();
//             for (int j = i + 1; j < points.length; j++) {
//                 Double y = (points[j][1] - points[i][1] +0d);
//                 Double x = (points[j][0] - points[i][0] + 0d);
//                 Float s = y / x;
//                 if (Float.compare(s, -0.0f) == 0) {
//                     s = 0.0f;
//                 }
//                 if (Float.compare(s, 1f / 0f) == 0 || Float.compare(s, -1f / 0f) == 0) {
//                     s = 0f;
//                 }
//                 // System.out.println("x = " + x + "y = " + y + "s = " + s);
//                 temp.add(s);

//             }
//             slopes.add(temp);
//         }
//         for (int i = 0; i < slopes.size(); i++) {
//             Collections.sort(slopes.get(i));
//         }
//         int ans = 0, count = 0;
//         Float prev = 0f;

//         for (int i = 0; i < slopes.size(); i++) {
//             if (slopes.get(i).size() > 0) {
//                 prev = slopes.get(i).get(0);
//                 // System.out.println(" i = " + i + " " + slopes.get(i).get(0));
//                 count = 1;
//                 for (int j = 1; j < slopes.get(i).size(); j++) {
//                     // System.out.println(" " + slopes.get(i).get(j));
//                     if (Float.compare(slopes.get(i).get(j), prev) == 0) {
//                         // System.out.println("IN");
//                         count++;
//                         if (j == slopes.get(i).size() - 1) {
//                             ans = Math.max(ans, count);
//                         }
//                     } else {
//                         ans = Math.max(ans, count);
//                         prev = slopes.get(i).get(j);
//                         count = 1;
//                     }
//                 }

//             }
//         }

//         return ans + 1;
//     }
// }

import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;

        }
        if (points.length == 2) {
            return 2;
        }

        ArrayList<ArrayList<Double>> slopes = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            ArrayList<Double> temp = new ArrayList<>();
            for (int j = i + 1; j < points.length; j++) {
                Double y = (points[j][1] - points[i][1] + 0d);
                Double x = (points[j][0] - points[i][0] + 0d);
                if (Double.compare(x, 0d) == 0) {
                    
                    temp.add(10005d);
                    continue;
                }
                Double s = y / x;
                if (Double.compare(s, -0d) == 0) {
                    s = 0.0d;
                }
                // if (Double.compare(s, 1f / 0f) == 0 || Double.compare(s, -1f / 0f) == 0) {
                // s = 0f;
                // }
                // System.out.println("x = " + x + "y = " + y + "s = " + s);
                temp.add(s);

            }
            slopes.add(temp);
        }
        for (int i = 0; i < slopes.size(); i++) {
            Collections.sort(slopes.get(i));
        }
        int ans = 0, count = 0;
        Double prev = 0d;

        for (int i = 0; i < slopes.size(); i++) {
            if (slopes.get(i).size() > 0) {
                prev = slopes.get(i).get(0);
                // System.out.println(" i = " + i + " " + slopes.get(i).get(0));
                count = 1;
                for (int j = 1; j < slopes.get(i).size(); j++) {
                    // System.out.println(" " + slopes.get(i).get(j));
                    if (Double.compare(slopes.get(i).get(j), prev) == 0) {
                        // System.out.println("IN");
                        count++;
                        if (j == slopes.get(i).size() - 1) {
                            ans = Math.max(ans, count);
                        }
                    } else {
                        ans = Math.max(ans, count);
                        prev = slopes.get(i).get(j);
                        count = 1;
                    }
                }

            }
        }

        return ans + 1;
    }
}