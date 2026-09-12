class Solution {
    public int maxVowels(String s, int k) {
        int maxi;
        int count = 0;

        for (int l = 0; l < k; l++) {
            if (isVowel(s.charAt(l))) {
                count++;
            }
        }
        maxi = count;

        for (int h = k; h < s.length(); h++) {
            if (isVowel(s.charAt(h - k))) {   
                count--;
            }
            if (isVowel(s.charAt(h))) {       
                count++;
            }
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}