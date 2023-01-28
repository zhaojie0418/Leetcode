import java.util.ArrayDeque;
import java.util.Deque;

public class simplifyPath71 {
    public String simplifyPath(String path) {
        //对输入的字符串进行切分
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            //注意当字符串为空字符串和为单个点的时候不需要进行处理
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                //实际上就是往末尾添加元素
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
