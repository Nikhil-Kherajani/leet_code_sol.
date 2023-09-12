public class Solution {
    
    static class Pair implements Comparable<Pair> {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Pair other) {
            return other.count - this.count; // for max priority queue
        }
    }

    public int minDeletions(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int deletions = 0;
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            while (!maxHeap.isEmpty() && current.count == maxHeap.peek().count) {
                Pair next = maxHeap.poll();
                next.count--;
                deletions++;
                if (next.count > 0) {
                    maxHeap.offer(next);
                }
            }
        }

        return deletions;
    }
}
