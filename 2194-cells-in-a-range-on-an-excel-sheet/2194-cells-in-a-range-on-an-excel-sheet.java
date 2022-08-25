class Solution {
    public List<String> cellsInRange(String s) {
        
       
        String[] str=s.split(":");
        List<String> ans=new ArrayList<>();
        char a = str[0].charAt(0);
        char b = str[1].charAt(0);
        char p = str[1].charAt(1);
        char v = str[0].charAt(1);
        
        int q = Character.getNumericValue(p);
        int z = Character.getNumericValue(v);
        System.out.println(q);
        System.out.println(z);
        
        for (char c = a; c <= b; c++) {
          for (int i=z; i<=q; i++){
              String dop=String.valueOf(i);
              ans.add(c+dop);
          }   
      }
 
        return ans;
    }
}

        
    