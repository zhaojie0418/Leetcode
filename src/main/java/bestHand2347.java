import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bestHand2347 {
    public String bestHand(int[] ranks, char[] suits) {
        String[] res = {"Flush", "Three of a Kind", "Pair", "High Card"};
        //由于从高到低输出结果
        HashMap<Character, Integer> suitsHashMap = new HashMap<>();
        HashMap<Integer, Integer> ranksHashMap = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            int temp = ranks[i];
            ranksHashMap.put(ranks[i], ranksHashMap.getOrDefault(ranks[i], 0)+1);
            suitsHashMap.put(suits[i], suitsHashMap.getOrDefault(suits[i], 0)+1);
        }
        int suitCount = suitsHashMap.size();
        int rankCount = ranksHashMap.size();
        //"Flush"：同花，五张相同花色的扑克牌。
        if (suitCount == 1) {
            return res[0];
        }
        //"High Card"：高牌，五张大小互不相同的扑克牌。
        if (rankCount == 5) {
            return res[3];
        }
        //"Three of a Kind"：三条，有 3 张大小相同的扑克牌。
        //"Pair"：对子，两张大小一样的扑克牌。
        for (int count : ranksHashMap.values()) {
            if (count >= 3) {
                return res[1];
            }
        }
        return res[2];
    }
}
