import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    //剩余左括号总数要小于等于右括号。 递归把所有符合要求的加上去
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            //所有符合条件的括号字符串最终都会回到这里来，故在这里设置将其放回列表中
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号

            //left > 0 表示还有剩余的左括号可以用
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }
}
