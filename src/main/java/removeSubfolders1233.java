import java.util.*;

public class removeSubfolders1233 {
    public static void main(String[] args) {
        String[] strings = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(new removeSubfolders1233().removeSubfolders(strings));
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < folder.length; i++) {
            boolean ifHave = true;
            String s = folder[i];
            String[] strings = s.split("/");
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < strings.length; j++) {
                stringBuilder.append("/").append(strings[j]);
                if (hashSet.contains(stringBuilder.toString())) {
                    ifHave = false;
                    break;
                }
            }
            if (ifHave) {
                hashSet.add(stringBuilder.toString());
            }
        }
//        List<String> res = Arrays.asList(hashSet.toArray());
        List<String> res = new ArrayList<>();
        for (Object temp : hashSet.toArray()) {
            res.add(temp.toString());
        }
        return res;
    }
}
