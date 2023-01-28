import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class evaluate1807 {
    public static void main(String[] args) {

    }
    //自己编写的这个代码测试用例是一遍过的，但是运行过程超时
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> know = knowledge.get(i);
            map.put(know.get(0), know.get(1));
        }
        StringBuilder res = new StringBuilder();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left = i++;
                while (s.charAt(i) != ')') {
                    i++;
                }
                right = i;
                String temp = s.substring(left+1,right);
                res.append(map.get(temp) == null ? '?': map.get(temp) );
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    //给出的不超时的算法
    public String evaluate2(String s, List<List<String>> knowledge) {
        //好傻，就是把这个给定的List<List<String>>使用hashmap优化（原来你给定的也能优化）
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> know = knowledge.get(i);
            map.put(know.get(0), know.get(1));
        }
        char[] cs = s.toCharArray();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '(') {
                StringBuffer key = new StringBuffer();
                while (cs[++i] != ')') {
                    key.append(cs[i]);
                }
                String value = map.getOrDefault(key.toString(), "?");
                ans.append(value);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

}
