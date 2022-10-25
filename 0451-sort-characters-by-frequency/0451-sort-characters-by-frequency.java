class Solution {
    public String frequencySort(String s) {
		Map<Character,Integer> map=new HashMap<Character, Integer>();
		Queue<Map.Entry<Character,Integer>> qu=new PriorityQueue<>(
				(a,b)->{
					if(a.getValue() != b.getValue())
						return -a.getValue().compareTo(b.getValue());
					return a.getKey().compareTo(b.getKey());
				}
				);
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) map.put(s.charAt(i),map.get(s.charAt(i))+1);
			else map.put(s.charAt(i),1);
		}
		
		for(Map.Entry<Character,Integer> m:map.entrySet()) {
			qu.offer(m);
		}
		String str="";
		while(!qu.isEmpty()) {
			int n=qu.peek().getValue();
			char ch=qu.poll().getKey();
			while(n>0) {
				str=str+ch;
				n--;
			}
        }
    
		return str;
    }
}