class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        
     
        int[][] sortedSpells = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }
     
        Arrays.sort(sortedSpells, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(potions);
        
        int[] answer = new int[n];
        int potionIndex = m - 1;

        for (int[] sortedSpell : sortedSpells) {
            int spell = sortedSpell[0];
            int index = sortedSpell[1];
            
            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
                potionIndex -= 1;
            }
            answer[index] = m - (potionIndex + 1);
        }
        
        return answer;
    }
}