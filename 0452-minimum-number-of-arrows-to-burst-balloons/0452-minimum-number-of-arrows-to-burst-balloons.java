import java.util.*;

class Solution {
    static void columnWiseSorting(int arr[][], int colmn) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] frst, int[] scnd) {
                if (frst[colmn - 1] > scnd[colmn - 1]) {
                    return 1;
                } else
                    return -1;
            }
        });
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
    }

    public int findMinArrowShots(int[][] points) {
        // columnWiseSorting(points, 1);
        Arrays.sort(points, (a, b) -> Integer.compare(a[0],b[0]));
        int max = points[0][0];
        int min = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            // System.out.println(max + " " + min);
            max = Math.max(points[i][0], max);
            min = Math.min(points[i][1], min);

            if (min >= max) {
                
            } else {
                ans++;
                max = points[i][0];
                min = points[i][1];
            }

        }
        // if (!(min >= max)) {
        //         ans++;
        //     } 
        return ans;
    }
}