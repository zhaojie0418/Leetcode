public class longestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        int num = strs.length;
        StringBuffer res = new StringBuffer();
        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i<num;i++){
            minLength= Math.min(minLength,strs[i].length());
        }
        for(int i = 0;i<minLength;i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j<num;j++){
                if(strs[j].charAt(i)!=c)
                    return res.toString();
            }
            res.append(c);
        }
        return res.toString();
    }
}
