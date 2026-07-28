class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

       
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        
        for (int i = 0; i < 26; i++) {
            int half = freq[i] / 2;

            for (int j = 0; j < half; j++) {
                left.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        StringBuilder result = new StringBuilder();

        result.append(left);

        if (middle != 0) {
            result.append(middle);
        }

        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }
}