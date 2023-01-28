import java.util.*;

public class letterCombinations17 {
    public static void main(String[] args) {
        System.out.println(new letterCombinations17().letterCombinations("22"));
    }
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
//        HashSet<Character> set = new HashSet<>();
        int num = digits.length();
        if(num==0)
            return combinations;
        for(int i = 0;i<digits.length();i++){
//            if(set.contains(digits.charAt(i))){
//                continue;
//            }else{
//                set.add(digits.charAt(i));
                combinations = change(phoneMap.get(digits.charAt(i)),combinations);

//            }
        }
        return combinations;
    }

    public List<String> change(String s ,List<String> c){
        List<String> res = new ArrayList<>();
        if(c.isEmpty()){
            for(int i = 0;i<s.length();i++){
                res.add(String.valueOf(s.charAt(i)));
            }
        }else {
            for(int i = 0;i<c.size();i++){
                for(int j = 0;j<s.length();j++){
                    res.add(c.get(i)+s.charAt(j));
                }
            }
        }
        return res;
    }
}
