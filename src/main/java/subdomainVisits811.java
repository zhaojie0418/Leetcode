import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subdomainVisits811 {
    public static void main(String[] args) {
        List<String> res = new subdomainVisits811().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(res.toString());
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : cpdomains) {
            String[] countAndNet = s.split(" ");
            int count = Integer.parseInt(countAndNet[0]);
            //注意这里的 . 需要进行转义
            String[] net = countAndNet[1].split("\\.");
            StringBuilder temp = new StringBuilder(net[net.length-1]);
            for (int i = net.length - 1; i >= 0; i--) {
                if (i != net.length - 1) {
                    temp.insert(0, net[i] + '.');
                }
                if (hashMap.containsKey(temp.toString())) {
                    hashMap.put(temp.toString(), hashMap.get(temp.toString()) + count);
                } else {
                    hashMap.put(temp.toString(), count);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> s : hashMap.entrySet()) {
            res.add(s.getValue() + " " + s.getKey());
        }
        return res;
    }
}
