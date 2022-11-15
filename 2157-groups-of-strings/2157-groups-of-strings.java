class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        Map<Integer, Integer> maskToIndex = new HashMap<>();
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            for (char ch : words[i].toCharArray()) {
                masks[i] |= (1 << ch - 'a');
            }
            maskToIndex.put(masks[i], i);
        }
        
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            // This is necessary to union the duplicate words
            disjointSet.union(i, maskToIndex.get(masks[i]));
            for (char ch : words[i].toCharArray()) {
                // Removing ch from the word
                int maskWithoutCh = masks[i] ^ (1 << ch - 'a');
                if (maskToIndex.containsKey(maskWithoutCh)) {
                    disjointSet.union(i, maskToIndex.get(maskWithoutCh));
                }
                
                // Replace ch with any other charactor
                for (int j = 0; j < 26; j++) {
					// Skip if the word already contains the char at j
                    if (j == ch - 'a' || (maskWithoutCh | (1 << j)) == maskWithoutCh) {
                        continue;
                    }
                    int maskWithReplace = maskWithoutCh | (1 << j);
                    if (maskToIndex.containsKey(maskWithReplace)) {
                        disjointSet.union(i, maskToIndex.get(maskWithReplace));
                    }
                }
            }
        }
        return disjointSet.getState();
    }

    private final class DisjointSet {
        private int[] parent;
        private int[] size;
        private int groupCount;
        private int maxSize;
        
        DisjointSet(int n) {
            groupCount = n;
            maxSize = 1;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        
        public void union(int a, int b) {
            if (a == b) {
                return;
            }
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
				// Improving the runtime for find operations by joining the small group to large one
                if (size[pb] < size[pa]) {
                    parent[pa] = pb;
                    size[pb] += size[pa];
                    maxSize = Math.max(maxSize, size[pb]);
                } else {
                    parent[pb] = pa;
                    size[pa] += size[pb];
                    maxSize = Math.max(maxSize, size[pa]);
                }
                groupCount--;
            }
        }
        
        public int[] getState() {
            return new int[]{groupCount, maxSize};
        }
    }
}