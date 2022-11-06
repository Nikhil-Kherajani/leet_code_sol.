class Solution {
    public String intToRoman(int number) {
        Map<Integer, Character> map = Map.of(1, 'I', 5, 'V', 10, 'X', 50, 'L', 100, 'C', 500, 'D', 1000, 'M');
        StringBuilder roman = new StringBuilder();

        int multiplier = 1;
        while (number > 0) {
            int digit = number % 10;

            if (digit == 4 || digit == 9)
                roman.insert(0, "" + map.get(multiplier) + map.get((digit + 1) * multiplier));
            else
                roman.insert(0,  (digit >= 5 ? map.get(5 * multiplier) : "") + (map.get(multiplier).toString().repeat(digit >= 5 ? digit - 5 : digit)));

            number = number / 10; multiplier *= 10;
        }

        return roman.toString();
    }
}