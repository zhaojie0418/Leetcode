import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class myAtoi8 {
    public static void main(String[] args) {
        System.out.println("".length());
        System.out.println(new myAtoi8().myAtoi(" "));
    }
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0){
            return  0;
        }
        int i;
        char firstChar = s.charAt(0);
        boolean b = true;
        if(firstChar>='0'&&firstChar<='9'){
            i=0;
        }else if(firstChar == '+'){
            b=true;
            i=1;
        }else if(firstChar == '-'){
            b=false;
            i=1;
        }
        else{
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0'&&c<='9'){
                stack.add(c-'0');
            }else {
                break;
            }
        }
        double sum = 0L;
        for(int j = 0;!stack.isEmpty();j++){
            int oneByte = stack.pop();
            sum = sum + oneByte*Math.pow(10,j);
        }
        sum = b == true?Math.min(sum, (long) Integer.MAX_VALUE) :Math.min(-sum, -(long) Integer.MIN_VALUE);
        return (int) sum;
    }
}
