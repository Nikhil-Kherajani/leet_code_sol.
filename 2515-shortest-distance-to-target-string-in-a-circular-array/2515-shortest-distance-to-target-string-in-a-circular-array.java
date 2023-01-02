class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        String[] newa = new String[words.length * 3];
        if (words.length == 1) {
            if (words[0].equals(target))
                return 0;
            else
                return -1;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < words.length; j++) {
                newa[k] = words[j];
                k++;
            }
        }
        int rcount = 0;
        boolean rflag = false, lflag = false;
        for (int i = startIndex + words.length; i < newa.length; i++) {

            // System.out.println(newa[i]);
            if (newa[i].equals(target)) {
                
                rflag = true;
                break;
            }
            rcount++;
        }
        int lcount = 0;
        for (int i = startIndex + words.length; i >= 0; i--) {
            if (newa[i].equals(target)) {
                lflag = true;
                break;
            }
            lcount++;
        }
        if (rflag && lflag) {

            return Math.min(rcount, lcount);
        } else if (rflag && !lflag) {
            return rcount;
        } else if (!rflag && lflag) {
            return lcount;
        } else {
            return -1;
        }

    }
}