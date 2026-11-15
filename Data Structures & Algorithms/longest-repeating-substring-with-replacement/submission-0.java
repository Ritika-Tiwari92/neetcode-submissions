class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0,right=0,maxLen=0,maxFreq=0;
        for(right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);

            if(right-left+1 - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            int currLen=right-left+1;
            maxLen=Math.max(maxLen,currLen);
        }
        return maxLen;
    }
}
