import java.util.ArrayList;
import java.util.List;

public class ambiguousCoordinates816 {
    //思路一：暴力破解法
    //思路二：先确定好逗号所在的位置，再确定小数点的位置
    //实际上直接使用暴力枚举即可，确定位置实际上减少不了多少时间复杂度
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList();
        s = s.substring(1, s.length() - 1); // 先去掉前后括号，只保留数字部分。即："(034)"——>"034"
        for (int i = 1; i < s.length(); i++) // 将s划分成【x轴】和【y轴】
            for (String x : genNums(s.substring(0, i))) // 获得x轴，然后使用“小数点”分割出【n种】可能的合法数字
                for (String y : genNums(s.substring(i))) // 获得y轴，然后使用“小数点”分割出【m种】可能的合法数字
                    result.add(new StringBuilder("(").append(x).append(", ").append(y).append(")").toString()); // 拼装在最终结果【n*m种】
        return result;
    }

    /** 将num用小数点分割 */
    private List<String> genNums(String num) {
        List<String> list = new ArrayList();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i); // 分割【整数】部分
            right = num.substring(i++); // 分割【小数】部分
            if ((!left.equals("0") && left.charAt(0) == '0') || // 对于逗号左侧【整数】，不允许以0开头，除非这个整数就是0本身
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue; // 对于逗号右侧【小数】，不允许以0作为结尾
            if (right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }

}
