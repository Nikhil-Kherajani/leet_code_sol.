class Solution {
    public String[] sortPeople(String[] names, int[] h) {
        
        return IntStream.range(0, names.length)
            .mapToObj(i -> new Object[] {names[i], h[i]})
            .sorted( (a,b) -> (int) b[1] - (int) a[1])
            .map(a -> (String) a[0]).toArray((i) -> names);
    }
}