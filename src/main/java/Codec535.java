import java.util.HashMap;
import java.util.Map;

public class Codec535 {
    private Map<Integer, String> dataBase = new HashMap<Integer, String>();
    private int id;

    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }

}
