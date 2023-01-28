public class solveEquation640 {
    //自己的写法，没有进行完成，使用简单的模拟思路
    public String solveEquation(String equation) {
        //左右两边的x系数
        int leftParam = 0;
        int rightParam = 0;
        int leftSum = 0;
        int rightSum = 0;
        int tempNumber = 1;
//        x = x * 10 + version1.charAt(i) - '0';
        int i = 0;
        for(;i<equation.length();i++){
            char c = equation.charAt(i);
            //如果是等号的话
            if(c=='='){
                i++;
                break;
            }
            //如果是数字的话
            //如果是参数的话
            if(c=='x'){
                leftParam += tempNumber;
            }
        }
        for(;i<equation.length();i++){
            char c = equation.charAt(i);
            //如果是数字的话
            //如果是参数的话
            if(c=='x'){

            }
        }
        return equation;
    }

    //官方题解 ：对字符进行分隔处理
    public String solveEquation2(String equation) {
        // 把x移到左边，把其他移到右边，注意这里可以直接使用字符串的split函数对字符串进行切分
        String[] arr1 = equation.split("=");
        //对左右参数的记录
        int left = 0;
        int right = 0;

        //arr1[0]是等号左边的部分  arr1[1]是等号右边的部分
        //为了简化计算  将表达式中的所有"-"替换成"+-"
        String[] arr2 = arr1[0].replace("-", "+-").split("\\+");
        String[] arr3 = arr1[1].replace("-", "+-").split("\\+");

        // 等式左边的处理
        for (String s : arr2) {
            if (s.equals("x")) {
                left += 1;
            } else if (s.equals("-x")) {
                left += -1;
            } else if (s.contains("x")) {
                left += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                right -= Integer.parseInt(s);
            }
        }

        // 等式右边的处理
        for (String s : arr3) {
            if (s.equals("x")) {
                left -= 1;
            } else if (s.equals("-x")) {
                left -= -1;
            } else if (s.contains("x")) {
                left -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                right += Integer.parseInt(s);
            }
        }

        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + right/left;
        }
    }

}
