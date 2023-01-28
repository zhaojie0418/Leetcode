import tools.TrieNode;

import java.util.*;

public class minimumLengthEncoding820 {
    public static void main(String[] args) {
        int res = new minimumLengthEncoding820().minimumLengthEncoding(new String[]{"t"});
        Integer[] temp = new Integer[26];
        System.out.println(temp[1]);
        System.out.println(res);
    }
    //自己写的方法不仅速度奇慢，而且还消耗了更多的内存
    public int minimumLengthEncoding(String[] words) {
        //其实不需要排序，直接计算即可
        List<String> stringList = new ArrayList<>();
        //重写排序方法，使得字符串数组按照字符串长度降序排列
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1,String s2) {
                return s2.length() - s1.length();
            }
        });
        //最长的这个字符串一定会被添加到stringList中
        stringList.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String temp = words[i];
            int length = temp.length();
            //注意字符串截取含左不含右
            boolean b_ifHave = false;
            for (String s : stringList) {
                if (s.substring(s.length() - length).equals(temp)) {
                    b_ifHave = true;
                    break;
                }
            }
            if (!b_ifHave) {
                stringList.add(temp);
            }
        }
        int sum = 0;
        for (String s : stringList) {
            sum = sum + s.length();
        }
        return sum+stringList.size();
    }
    //官方存放字符串的方式
    public int minimumLengthEncoding2(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                //不考虑其他条件，只需要把一个对应的字符串的所有后缀去除即可
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
    //使用字典树的方式进行存储
    public int minimumLengthEncoding3(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                //注意这里使用的TrieNode结点的get方法进行了重写，在调用get方法时，如果没有对应结点则会自动进行创建
                //并且由于其在get方法中返回的就是对应下一个字符对应的结点，所以实际上不需要找到下一个节点
                cur = cur.get(word.charAt(j));
            }
            //
            nodes.put(cur, i);
        }

        int ans = 0;
        //注意这个foreach写法，可以不通过获取整个Map来进行遍历，而是只获取键值进行遍历
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }
    //第四种使用字符前缀树的方式，并且效率更高（也更好理解）

//    class Solution {
//        public int minimumLengthEncoding(String[] words) {
//            int len = 0;
//            Trie trie = new Trie();
//            // 先对单词列表根据单词长度由长到短排序
//            Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
//            // 单词插入trie，返回该单词增加的编码长度
//            for (String word: words) {
//                len += trie.insert(word);
//            }
//            return len;
//        }
//    }
//
//    // 定义tire
//    class Trie {
//
//        TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
    //    注意这里的返回值返回对应的长度
//        public int insert(String word) {
//            TrieNode cur = root;
//            boolean isNew = false;
//            // 倒着插入单词
//            for (int i = word.length() - 1; i >= 0; i--) {
//                int c = word.charAt(i) - 'a';
//                if (cur.children[c] == null) {
//                    isNew = true; // 是新单词
//                    cur.children[c] = new TrieNode();
//                }
//                cur = cur.children[c];
//            }
//            // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
              // 这里的返回值实际上和前缀树的结构中的结点数据无关，只是用于返回结果
              // 如果是新单词长度就要加一，如果不是新单词就没必要进行相加，返回结果0即可
//            return isNew? word.length() + 1: 0;
//        }
//    }
//
//    class TrieNode {
//        char val;
//        TrieNode[] children = new TrieNode[26];
//
//        public TrieNode() {}
//    }

}
