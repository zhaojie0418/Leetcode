public class compress443 {
    //注意是对输入数组进行操作，使得其被修改，返回修改后的数组长度
    //这种方法能够实现，但是使用了多余的数据空间，这里题目要求使用常数额外空间
    public int compress(char[] chars) {
        StringBuffer stringBuffer = new StringBuffer();
        int count = 1;
        char tempChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == tempChar) {
                count++;
            } else {
                stringBuffer.append(tempChar);
                if (count != 1) {
                    stringBuffer.append(count);
                }
                //初始化对应字符
                tempChar = chars[i];
                count = 1;
            }
        }
        stringBuffer.append(tempChar);
        if (count != 1) {
            stringBuffer.append(count);
        }
        for (int i = 0; i < stringBuffer.length(); i++) {
            chars[i] = stringBuffer.charAt(i);
        }
        return stringBuffer.length();
    }

    //官方解法，使用了双指针原地排序的思想
    //使用双指针分别标志我们在字符串中读和写的位置   (注意双指针不仅是快慢指针还可以是读写指针)
    public int compress2(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        //读指针进行遍历操作
        for (int read = 0; read < n; read++) {
            //如果读指针读到最后一个字符 或者读指针读到的字符和下一个字符不相同
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                //这里利用读指针和left的差值来表示有多少个对应字符
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
            //排除if中的情况则相当于是遇到了重复的字符，这里的操作是没有任何操作，由于在操作过程中没有移动left，所以指针和left的差值本身就代表字符的个数
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
