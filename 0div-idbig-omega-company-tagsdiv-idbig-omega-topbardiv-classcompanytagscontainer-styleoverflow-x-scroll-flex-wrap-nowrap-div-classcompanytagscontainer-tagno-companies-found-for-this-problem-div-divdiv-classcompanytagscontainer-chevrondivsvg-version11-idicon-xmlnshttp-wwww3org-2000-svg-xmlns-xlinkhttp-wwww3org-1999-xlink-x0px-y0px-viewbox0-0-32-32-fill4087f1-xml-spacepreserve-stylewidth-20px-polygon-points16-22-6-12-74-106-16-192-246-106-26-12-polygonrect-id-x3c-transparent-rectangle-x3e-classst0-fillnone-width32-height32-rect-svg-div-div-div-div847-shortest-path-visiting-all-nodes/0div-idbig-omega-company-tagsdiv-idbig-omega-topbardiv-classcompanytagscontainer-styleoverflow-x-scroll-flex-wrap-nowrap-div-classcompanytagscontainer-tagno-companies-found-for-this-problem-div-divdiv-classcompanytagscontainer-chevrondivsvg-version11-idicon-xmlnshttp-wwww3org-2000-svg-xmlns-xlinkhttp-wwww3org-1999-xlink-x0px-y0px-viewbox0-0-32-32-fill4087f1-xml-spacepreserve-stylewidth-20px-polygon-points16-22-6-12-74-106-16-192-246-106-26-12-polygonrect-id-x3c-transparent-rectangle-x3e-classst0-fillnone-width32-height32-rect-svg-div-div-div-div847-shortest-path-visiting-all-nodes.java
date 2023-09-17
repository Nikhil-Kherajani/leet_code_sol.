class Path{
        int node;
        int steps;
        Set<Integer> visit;
        Path(int node,int steps,Set<Integer> visit){
            this.node=node;
            this.steps=steps;
            this.visit=new HashSet<>(visit);
    }
}

class Solution {

    int shortestPathLength(int[][] graph){ 
        int n=graph.length;

        Map<Integer,Set<Set<Integer>>> map=new HashMap<>();
        Queue<Path> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            set.add(i);
            map.put(i,new HashSet<>(Arrays.asList(set)));
            queue.add(new Path(i,0,set));
        }

        while(!queue.isEmpty()){
            Path current=queue.poll();
            int node=current.node;
            int steps=current.steps;
            Set<Integer> v=current.visit;
            if(v.size()==n)
                return steps;
            for(int j:graph[node]){
                Set<Integer> newVisit=new HashSet<>(v);
                newVisit.add(j);
                if(!map.get(j).contains((newVisit))){
                    queue.add(new Path(j,steps+1,newVisit));
                    map.computeIfAbsent(j,k->new HashSet<>()).add(newVisit);
                }
            }
        }
        return 0;
    }
}