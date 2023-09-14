class Solution {

    private void dfs(String s, Map<String, PriorityQueue<String>> map, LinkedList<String> list){

        PriorityQueue<String> pq = map.get(s);

        while(pq!=null && !pq.isEmpty()){

            dfs(pq.poll(), map, list);

        }

        list.addFirst(s);

    }

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(int i=0; i<tickets.size(); i++){

            if(!map.containsKey(tickets.get(i).get(0))){

                PriorityQueue<String> pq = new PriorityQueue<>();

                map.put(tickets.get(i).get(0), pq);

            }

            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));

        } 

        LinkedList<String> list = new LinkedList<>();

        dfs("JFK", map, list);

        return list;

    }

}