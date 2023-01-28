import java.util.HashMap;
public class checkInclusion567 {
    public static void main(String[] args) {
        System.out.println(new checkInclusion567().checkInclusion("ab" , "eidbaooo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        int left = 0;
        int right = length-1;
        int[] numbers = new int[26];
        for(int i = 0;i<length;i++){
            char c = s1.charAt(i);
            numbers[c-'a']++;
        }
        while(right<s2.length()){
            int[] myNumber = numbers.clone();
            //第一步优化
            //其实这里大大增加了需要遍历的元素个数，本身滑动窗口向右移动只需要多检查一个元素即可，现在变成要检查重新的字符串
            //实际上可以记录字符串s1对应的标记数组cnt1 和滑动窗口中的标记数组cnt2 通过cnt1 == cnt2来判断是否相同
            //每次滑动窗口只需要添加右边的一个字符，删除左边的一个字符即可

            //第二步优化
            //为简化上述逻辑，我们可以只用一个数组  cnt，其中 cnt[x]=  cnt2[x] - cnt1[x]
            //替换成 cnt[x] 与 0 的比较。
            //设左边减少的字符为X，右边增加的字符为Y
            //那么当X=Y的时候，插值不发生改变
            //当X!=Y时，只需要改变两个字符即可

            for(int i = 0;i<length;i++){
                myNumber[s2.charAt(left+i)-'a']--;
            }
            if(isClean(myNumber)){
                return true;
            }
            left++;
            right++;
        }


        return false;
    }
    public boolean isClean(int[] arr){
        for(int n:arr){
            if(n!=0){
                return false;
            }
        }
        return true;
    }
}
