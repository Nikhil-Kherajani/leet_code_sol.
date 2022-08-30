class OrderedStream {
    private String[] stream;
    private int n;
    private int i = 0;
    
    public OrderedStream(int n) {
        this.n = n;
        stream = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        stream[idKey - 1] = value;
        
        while(i < n && stream[i] != null) {
            list.add(stream[i]);
            i++;
        }
        return list;
    }
}