class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];
        int n = arr.length;
        for(int i =0;i<n;i++){
            arr[indices[i]]=s.charAt(i);
        }
        String str = new String(arr); // convert char array into a combined string
        return str;
    }
}