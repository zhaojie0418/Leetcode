import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses93 {
    public static void main(String[] args) {

    }
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    //由于有四段数字
    //这里很巧妙的使用了共享的数组进行存储，由于每一次dfs实际上只会有一种情况被输出，所以即使又被重新覆盖也无所谓
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            //如果找完了第四段但是还有剩余的数字没有使用，则说明遍历完全进行返回
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯(该终止了)
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            //注意这里没有简单的使用字符串转数字的方式（效率过低）
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            //如果满足当前ip条件
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
