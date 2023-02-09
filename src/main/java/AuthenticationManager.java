import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    HashMap<String, Integer> hashMap;
    int gap;

    public AuthenticationManager(int timeToLive) {
        hashMap = new HashMap<>();
        gap = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        hashMap.put(tokenId, currentTime + gap);
    }

    public void renew(String tokenId, int currentTime) {
        if (hashMap.containsKey(tokenId)) {
            int oldTime = hashMap.get(tokenId);
            if (oldTime > currentTime) {
                hashMap.put(tokenId, currentTime + gap);
            } else {
                hashMap.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (Integer i : hashMap.values()) {
            if (i > currentTime) {
                res++;
            }
        }
        return res;
    }
}
