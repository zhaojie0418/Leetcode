import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class exclusiveTime636 {
    //TODO 完善自己的写法（其实已经和标准答案的方法很类似了，只是没有完善好不同层级的函数相互调用的时间计算问题）
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[2];
        Stack<String[]> strings = new Stack<>();
        for(String s:logs){
            String[] tempUnit = s.split(":");
            //如果是开始时刻
            if(tempUnit[1].equals("start")){
                strings.add(tempUnit);
            }
            //如果是结束时刻
            else{
                //如果为空则说明处理完毕
                if(strings.isEmpty()){
                    return res;
                }
                String[] tempArr = strings.pop();
                if(res[Integer.parseInt(tempArr[0])]!=0){
                    res[Integer.parseInt(tempArr[0])] = res[Integer.parseInt(tempArr[0])] + Integer.parseInt(tempUnit[2]) - Integer.parseInt(tempArr[2]) + 1;
                }
            }
        }
        return new int[0];
    }

    //官方题解方式
    public int[] exclusiveTime2(int n, List<String> logs) {
        //注意使用双端队列实现栈
        Deque<int[]> stack = new ArrayDeque<int[]>(); // {idx, 开始运行的时间}
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            //如果是开始的时间戳
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    //相当于添加上父函数的前面一段时间记录，并更新父函数的时间戳为子函数当前开始时间
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                }
                //将这个新的函数开始时间戳进行压栈处理
                stack.push(new int[]{idx, timestamp});
            }
            //如果是结束的时间戳
            else {
                int[] t = stack.pop();
                //注意这里是在其对应的记录数组的基础上进行添加，相当于是将父函数的前后端执行时间分别处理
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }
}
