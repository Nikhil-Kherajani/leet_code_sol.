class Solution {
    public int maxRectangleArea(int[][] points) {
        int n = points.length;
        if (n < 4) {
            return -1;
        }

        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] + "," + point[1]);
        }

        int maxArea = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int[] p1 = points[i];
                        int[] p2 = points[j];
                        int[] p3 = points[k];
                        int[] p4 = points[l];

                        if (isRectangle(p1, p2, p3, p4)) {
                            int minX = Math.min(Math.min(p1[0], p2[0]), Math.min(p3[0], p4[0]));
                            int maxX = Math.max(Math.max(p1[0], p2[0]), Math.max(p3[0], p4[0]));
                            int minY = Math.min(Math.min(p1[1], p2[1]), Math.min(p3[1], p4[1]));
                            int maxY = Math.max(Math.max(p1[1], p2[1]), Math.max(p3[1], p4[1]));

                            boolean valid = true;
                            for (int[] p : points) {
                                if (p[0] > minX && p[0] < maxX && p[1] > minY && p[1] < maxY) {
                                    valid = false;
                                    break;
                                }
                                if ((p[0] == minX || p[0] == maxX) && (p[1] >= minY && p[1] <= maxY) ||
                                        (p[1] == minY || p[1] == maxY) && (p[0] >= minX && p[0] <= maxX)) {
                                    if (!((p[0] == p1[0] && p[1] == p1[1]) || (p[0] == p2[0] && p[1] == p2[1]) ||
                                            (p[0] == p3[0] && p[1] == p3[1]) || (p[0] == p4[0] && p[1] == p4[1]))) {
                                        valid = false;
                                        break;
                                    }
                                }
                            }

                            if (valid) {
                                int area = (maxX - minX) * (maxY - minY);
                                maxArea = Math.max(maxArea, area);
                            }
                        }
                    }
                }
            }
        }

        return maxArea;
    }

    private boolean isRectangle(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        Set<String> points = new HashSet<>();
        points.add(p1[0] + "," + p1[1]);
        points.add(p2[0] + "," + p2[1]);
        points.add(p3[0] + "," + p3[1]);
        points.add(p4[0] + "," + p4[1]);
        
        if (points.size() != 4)
        {
            return false;
        }
        
        int[] x = {p1[0], p2[0], p3[0], p4[0]};
        int[] y = {p1[1], p2[1], p3[1], p4[1]};
        Arrays.sort(x);
        Arrays.sort(y);

        
        if (!((x[0] == x[1] && x[2] == x[3]) && (y[0] == y[1] && y[2] == y[3])))
        {
            return false;
        }
        
        if(points.contains(x[0]+","+y[0]) && points.contains(x[0]+","+y[2]) &&
            points.contains(x[2]+","+y[0]) && points.contains(x[2]+","+y[2])){
            return true;
        }
        return false;

    }
}