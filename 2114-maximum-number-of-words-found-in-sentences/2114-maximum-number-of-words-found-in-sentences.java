class Solution {
    public int mostWordsFound(String[] sentences) {
        int[] arr = new int[sentences.length];
        for(int i = 0; i < sentences.length; i++){ 
            arr[i] = sentences[i].split(" ").length;  
        }
        Arrays.sort(arr);
        
        return arr[sentences.length-1];
    }
}