class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] needed = new int[128];
        int[] have = new int[128];

        // Store required character frequencies
        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }

        int low = 0;
        int haveCount = 0;
        int needCount = 0;
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;

        // Count distinct required characters
        for (int i = 0; i < needed.length; i++) {
            if (needed[i] > 0) {
                needCount++;
            }
        }

        // Expand the sliding window
        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);
            have[ch]++;

            // Check whether the current character requirement is satisfied
            if (needed[ch] > 0 && have[ch] == needed[ch]) {
                haveCount++;
            }

            // Shrink the window while it is valid
            while (haveCount == needCount) {

                int len = high - low + 1;

                if (len < minLength) {
                    minLength = len;
                    startIndex = low;
                }

                char leftChar = s.charAt(low);
                have[leftChar]--;

                if (needed[leftChar] > 0 &&
                    have[leftChar] < needed[leftChar]) {
                    haveCount--;
                }

                low++;
            }
        }

        // No valid window found
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }
}