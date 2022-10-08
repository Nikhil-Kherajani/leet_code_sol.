class Solution {
    
    public int[] finalPrices(int[] prices) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i=prices.length-1; i>=0; i--) {
            
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                
                stack.pop();
            }
            
            int price = prices[i];
            
            if (!stack.isEmpty()) {
                
                prices[i] = prices[i] - stack.peek();  
            }
            
            stack.push(price);
        }
        
        return prices;
    }
}