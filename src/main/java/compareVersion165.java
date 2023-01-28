public class compareVersion165 {
    public static void main(String[] args) {
        System.out.println("  10 0  ".trim());
    }
    public int compareVersion(String version1, String version2) {
        //TODO 研究split函数的用法（为什么表达式中不加\\就会输出错误
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length1 = v1.length;
        int length2 = v2.length;
        int minLength = Math.min(length1, length2);
        for(int i = 0;i<minLength;i++){
            //这里trim使用错误，trim是用于去除前后空格的

            int value1 = Integer.parseInt(v1[i].trim());
            int value2 = Integer.parseInt(v2[i].trim());
            //如果有大小之分
            if(value1>value2){
                return 1;
            }else if(value1<value2){
                return -1;
            }
            //如果没有大小之分继续比较
        }
        if(length2 == length1){
            return 0;
        }else if(length1 < length2){
            for(int i = length1;i<length2;i++){
                if(Integer.parseInt(v2[i].trim())>0) return -1;
            }
            return 0;
        }else{
            for(int i = length2;i<length1;i++){
                if(Integer.parseInt(v1[i].trim())>0) return 1;
            }
            return 0;
        }
    }
    //官方题解方式
    //注意其减少使用多余内存的方式
    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            //确保当两个数组的长度不同时，长度较小的那个超出数组长度部分为0
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    //官方题解 使用双指针减少内存的使用（数组类问题为了减少内存使用往往使用双指针）
    public int compareVersion3(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        //只要有一个版本号没有遍历完全就继续遍历
        while (i < n || j < m) {
            //注意当两个版本号中有一个遍历完后，对应的for循环就会直接跳过，进而使用其原本的默认值

            //每次都各从两个版本号中解析出来一个数字
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                //解析含前导0的字符串解析成数字的方式
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
