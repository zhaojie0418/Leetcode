import java.util.HashMap;

public class getFolderNames1487 {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (hashMap.containsKey(name)) {
                int k = hashMap.get(name);
                while (hashMap.containsKey(addSuffix(name, k))) {
                    k++;
                }
                hashMap.put(name, k + 1);
                hashMap.put(addSuffix(name, k), 1);
                res[i] = addSuffix(name, k);
            } else {
                hashMap.put(name, 1);
                res[i] = name;
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }

}
