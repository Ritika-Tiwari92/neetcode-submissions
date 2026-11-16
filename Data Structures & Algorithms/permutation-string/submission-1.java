class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length() > s2.length()){
        return false;
       }
       int[] s1Freq = new int[26];
       int[] winFreq = new int[26];
       int winLen = s1.length();
       for(int i=0;i<s1.length();i++){
        s1Freq[s1.charAt(i) - 'a']++;
       }
       for(int i=0;i<winLen;i++){
        winFreq[s2.charAt(i) - 'a']++;
       }
       if(Arrays.equals(winFreq,s1Freq)){
        return true;
       }
       for(int right=winLen;right<s2.length();right++){
         int left=right-winLen;
         winFreq[s2.charAt(left) - 'a']-- ;
         winFreq[s2.charAt(right) - 'a']++;
         if(Arrays.equals(winFreq,s1Freq)){
            return true;
         }
       }
       return false;
    }
}
