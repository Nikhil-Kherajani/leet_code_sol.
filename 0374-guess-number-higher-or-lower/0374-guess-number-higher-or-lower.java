/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, h = n , ans = 0;
        while(l <= h){
            int m = l + (h - l)/2;
            if(guess(m) == 0){
                return m;
            }
            else if(guess(m) > 0){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return ans;
    }
}