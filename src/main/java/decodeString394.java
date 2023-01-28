import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class decodeString394 {
    public static void main(String[] args) {
        StringBuffer unit = new StringBuffer();
        //注意StringBuffer的方法自动变化在其本身身上进行改变
        unit.append(123);
        unit.reverse();
//        System.out.println(new decodeString394().decodeString("3[a]2[bc]"));
        System.out.println(new decodeString394().decodeString("100[leetcode]"));

    }
    int ptr;
    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    //TODO 思考当数字是多位数的时候怎么将数字放入数字栈中(见上面)
    public String decodeString(String s) {
        //numberStack存放字符前面的系数  stringStack存放括号以及具体的字母
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        //记录有多少个左括号
        int countBracket = 0;
        //用于保证在第一个左括号到来之前需要先将StringStack中的数据输出
        int ifFirst = 0;
        StringBuffer res = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            StringBuilder temp = new StringBuilder();
            StringBuilder unit = new StringBuilder();
            char c = s.charAt(i);
            //如果是数字
            if(c>='0'&&c<='9'){
                numberStack.push(c-'0');
                continue;
            }
            //如果是括号（左）或者字符
            if(c == '['){
                if(ifFirst==1){
                    countBracket++;
                    stringStack.push(String.valueOf(c));
                    continue;
                }else{
                    if(!stringStack.isEmpty()){
                        StringBuilder t = new StringBuilder();
                        while(!stringStack.isEmpty()){
                            t.append(stringStack.pop());
                        }
                        t.reverse();
                        res.append(t);
                    }
                    ifFirst++;
                    countBracket++;
                    stringStack.push(String.valueOf(c));
                    continue;
                }

            }
            //如果是一般字符
            if(c>='a'&&c<='z'){
                stringStack.push(String.valueOf(c));
                continue;
            }
            //如果是括号（右）
            //注意这里为了保证存在嵌套括号关系的情况下，内层括号左右字符的一致性，使用字符串栈存储而不是使用字符栈存储，直接将拼接好的字符串放入栈中
            if(c == ']'){
                //strings是存储待排序单元使用的栈
                Stack<String> strings = new Stack<>();
                //注意这里由于涉及到字符串内容的比较，所以这里使用equal方法而不是使用==
                while(!stringStack.peek().equals("[")){
                    strings.push(stringStack.pop());
                }
                stringStack.pop();
                countBracket--;
                while (!strings.isEmpty()){
                    temp.append(strings.pop());
                }
                int times = numberStack.pop();
                unit.append(String.valueOf(temp).repeat(times));
                if(countBracket==0){
                    res.append(unit);
                }else {
                    stringStack.push(unit.toString());
                }
            }
        }
        //如果字符栈中还有未处理的字符
        if(!stringStack.isEmpty()){
            StringBuilder temp = new StringBuilder();
            while(!stringStack.isEmpty()){
                temp.append(stringStack.pop());
            }
            temp.reverse();
            res.append(temp);
        }
        return res.toString();
    }
}
