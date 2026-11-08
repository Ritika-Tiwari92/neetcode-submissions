class Solution {

    public String encode(List<String> strs) {
     StringBuilder sb=new StringBuilder();
     for(String str:strs){
      int s=str.length();
      sb.append(s).append('#').append(str);
     }
     return sb.toString();
    }

    public List<String> decode(String encoded) {
    List<String> result = new ArrayList<>();
    int i = 0;

    while (i < encoded.length()) {
        int delimiter = encoded.indexOf('#', i);

        int length = Integer.parseInt(
            encoded.substring(i, delimiter)
        );

        String word = encoded.substring(
            delimiter + 1,
            delimiter + 1 + length
        );

        result.add(word);

        i = delimiter + 1 + length;
    }

    return result;
}
}
