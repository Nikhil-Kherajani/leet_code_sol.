class Solution {
    public int buyChoco(int[] prices, int money) {
        // Array to store frequency of prices
        int[] freq = new int[101];
        for (int p : prices) {
            freq[p]++;
        }

        // Assume minimum and second minimum to be zero.
        // Since prices[i] cannot be 0, the 0 value implies
        //They haven't been computed yet.
        int minimum = 0;
        int secondMinimum = 0;
        for (int price = 1; price <= 100; price++) {
            if (freq[price] > 1) {
                minimum = price;
                secondMinimum = price;
                break;
            } else if (freq[price] == 1) {
                minimum = price;
                break;
            }
        }

        // If the second minimum is not found, then find it
        if (secondMinimum == 0) {
            for (int price = minimum + 1; price <= 100; price++) {
                if (freq[price] > 0) {
                    secondMinimum = price;
                    break;
                }
            }
        }

        // Minimum Cost
        int minCost = minimum + secondMinimum;

        // We can buy chocolates only if we have enough money
        if (minCost <= money) {
            // Return the Amount of Money Left
            return money - minCost;
        }

        // We cannot buy chocolates. Return the initial amount of money
        return money;
    }
}