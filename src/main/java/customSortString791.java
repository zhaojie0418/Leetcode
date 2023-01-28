import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class customSortString791 {
    public static void main(String[] args) {
        System.out.println(new customSortString791().customSortString3("cba","abcd"));
    }
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        int length = order.length();
        //初始化对应的HashMap
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < length; i++) {
            charCount.put(order.charAt(i), 0);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCount.containsKey(c)) {
                charCount.compute(c, (key, value) -> {
                    return ++value;
                });
            } else {
                res.append(c);
            }
        }
        for (int i = 0; i < length; i++) {
            char c = order.charAt(i);
            int count = charCount.get(c);
            for (int j = 0; j < count; j++) {
                res.append(c);
            }
        }
        return res.toString();
    }

    //学习官方写法（和上面方法采用同样思路）
    public String customSortString2(String S, String T) {
        // count[char] = the number of occurrences of 'char' in T.
        // This is offset so that count[0] = occurrences of 'a', etc.
        // 'count' represents the current state of characters
        // (with multiplicity) we need to write to our answer.
        int[] count = new int[26];
        for (char c: T.toCharArray())
            count[c - 'a']++;

        // ans will be our final answer.  We use StringBuilder to join
        // the answer so that we more efficiently calculate a
        // concatenation of strings.
        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in S, in the order of S.
        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[c - 'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }

    //突发奇想看能不能重写比较器来实现
    //结果好像更慢，但是好像也蛮合情合理
    public String customSortString3(String order, String s) {
        int length = order.length();
        Character[] temp = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            temp[i] = s.charAt(i);
        }
        int[] weight = new int[26];
        for (int i = 0; i < length; i++) {
            char c = order.charAt(i);
            weight[c - 'a'] = length - i;
        }
        Arrays.sort(temp, (o1, o2) -> weight[o2 - 'a'] - weight[o1 - 'a']);
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = temp[i];
        }
        return String.valueOf(chars);
    }
}
