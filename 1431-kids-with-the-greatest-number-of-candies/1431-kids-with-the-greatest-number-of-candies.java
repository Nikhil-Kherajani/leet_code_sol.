class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
     
        
        int max = candies[0]; 
        int len = candies.length;
        
        for(int i = 0; i < len; i++){
            if(max < candies[i]){ // if max is less then current index
                max = candies[i]; // set the max to current index
            }
        }
        
        int temp = max; // store the max in a temp variable
        
        ArrayList<Boolean> extra = new ArrayList<>(); // created array list to store the result
        
        
        for(int i = 0; i < len; i++){
            if(temp <= candies[i] + extraCandies){ // checks if current index + extracandies if greater then or equal to max we find above
                extra.add(true); // if yes add true to arraylist
            }else{
                extra.add(false); // if not add false to array list
            }
        }
        return extra;
    }
}