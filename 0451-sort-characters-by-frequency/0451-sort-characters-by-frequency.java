class Solution {
    public String frequencySort(String s) {
        // PriorityQueue for sorting elements on decresing order based on frequency
        // b.val - a.val => store pair objects based on decresong order of frequency value 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val-a.val);
        // HashMap to store elements and their current frequency
        HashMap<Character,Integer> hm = new HashMap<>();
        char []c = s.toCharArray();
        for(int i=0;i<c.length;i++) {
            int count = hm.getOrDefault(c[i],0);
            //add element and current frequency in hashmap
            hm.put(c[i],count+1);
        }
        //add whole hashmap to priorityQueue
        for(Map.Entry<Character,Integer> entry: hm.entrySet()) {
            Pair pair = new Pair(entry.getKey(),entry.getValue());
            pq.add(pair);
        }
        StringBuilder sb = new StringBuilder("");
        //extract value from priorityQueue and add it into answer string
        while(!pq.isEmpty()) {
            Pair pair = pq.remove();
            int count = pair.val;
            char ch = pair.c;
            // add character into answer string as many time as frequency (it appears in main string)
            while(count--> 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
    // create class to store character and their respective frequency
    public class Pair {
        int val;
        char c;
        public Pair(char c,int val) {
            this.c = c;
            this.val = val;
        }
    }
}