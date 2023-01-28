import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class largestWordCount2284 {
    public static void main(String[] args) {
        System.out.println(new largestWordCount2284().largestWordCount(
                new String[]{"How is leetcode for everyone","Leetcode is useful for practice"},
                new String[]{"Bob","Charlie"}));
    }
    //        ["How is leetcode for everyone","Leetcode is useful for practice"]
//        ["Bob","Charlie"]
//["D","P","d","N","A","V","A","z","s","Z","E","f","L","M","k","a","v","w","N","h","b","o","o","e","Z","M","Q","b","l","z","z","J","d","Y","Z","F","g","Q","V","R","a","T","s","P","d","W","L","a","X","m","S","F","e","p","R","p","T","s","U","a","t","w","y","r","N","X","C","M","l"]
//["zJyJOrQCET","eADWrEGbxE","GEkALUqtls","HJzNJCxTPP","vcQnbXmQlY","wQXpjBYRaw","FNEnKkITIl","mPRTWXOeUm","jEscYOuSPs","mwuvVloPdY","xxyhOgfovA","HGnEAuYmcB","DOeQneHLoV","LFaFAknlNu","tAvkcJVeiw","ryJaGpnzab","siBxFLQDYq","vpcDDIVTYA","OmlfVsyiQX","hJUUHwTxdb","zWSrDroNkQ","yiJYiAuvlu","dDKvOWWplK","jloRpAItjy","jAbtpifhLK","CnKiIqYTAO","tsrNmxWjWJ","MmOMtwFwgT","NVvyYwFGqp","azGMRkpFHK","NKszyfGyep","RCLJRWIqJr","EnsYcgZocC","HLxjqnHGJQ","fmWaDmgsHY","SQoMUFmwFh","gJsobPnlsJ","HekunIHcum","PhaOVpIfHX","dTIiLFHJgA","gHsPxtDlee","gxWtSNVdHe","VvDHebWLum","wtbOkUqzoj","sFYGsgxSIL","VzyvwRnpsb","dkRVwyCKjw","ctkQqEnSsp","rBevrnGoVf","QzTgrDxhDv","QjdxyqrSBk","oAUVcxmfOg","UmvqVzLlgW","yMqXxuMXDW","gxTyHStXkI","KEugpAmKNU","HZRevihKwM","NmeVScfceP","ekmKZbQNTr","bFvufvfCjc","IiMtHarDxx","SYoNJsoYnn","MDWXAykVke","kowDkCsdir","WFOfDjbHRk","vigUEWkQmQ","nuRZKxEDrV","PyNgdglJkn","qNZbSSCLKY"]
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String s = messages[i];
            int count = 1;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == ' ') {
                    count++;
                }
            }
            hashMap.put(senders[i], hashMap.getOrDefault(senders[i], 0) + count);
        }
//        AtomicReference<String> resultName = new AtomicReference<>("z");
//        AtomicInteger wordCount = new AtomicInteger();
//        hashMap.entrySet().forEach((entry -> {
//            if (entry.getValue() >= wordCount.get()) {
//                if (!(wordCount.get() == entry.getValue() && entry.getKey().compareTo(String.valueOf(resultName)) < 0)) {
//                    resultName.set(entry.getKey());
//                    wordCount.set(entry.getValue());
//                }
//            }
//        }));
        //以后还是使用for循环的方式进行遍历吧，效果还好些
        String resultName = "a";
        int wordCount = 0;
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()
        ) {
            if (entry.getValue() >= wordCount) {
                if (!(wordCount == entry.getValue() && entry.getKey().compareTo(resultName) < 0)) {
                    resultName= entry.getKey();
                    wordCount = entry.getValue();
                }
            }
        }

        return resultName;
    }
}
