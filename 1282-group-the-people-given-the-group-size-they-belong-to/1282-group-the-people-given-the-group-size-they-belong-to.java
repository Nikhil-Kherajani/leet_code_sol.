class Solution {
 public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        Map<Integer, List<Integer>> map = new TreeMap<>(Integer::compareTo);

        List<Integer> list = null;
        for (int i = 0 ; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                list = map.get(groupSizes[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(groupSizes[i], list);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (Integer key : map.keySet()) {
            List<Integer> values = map.get(key);

            int i = 0;
            while (i < values.size()) {
                indexes = values.subList(i, i+key);
                result.add(indexes);
                i += key;
            }
        }

        return result;
    }

}