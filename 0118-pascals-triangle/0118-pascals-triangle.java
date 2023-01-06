import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> rows = new ArrayList<>();
        rows.add(1);
        result.add(rows);
        if (numRows == 1) {
            return result;
        }
        
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < result.get(i - 1).size(); j++) {
                temp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            temp.add(1);
            result.add(temp);
        }

        return result;

    }
}