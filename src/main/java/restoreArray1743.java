import java.util.*;

public class restoreArray1743 {
    public static void main(String[] args) {
        int[][] arr = {{2,1},{3,2},{3,4}};
        System.out.println(Arrays.toString(new restoreArray1743().restoreArray(arr)));
    }
    //由于不考虑输出顺序，这里想法是维护每一个待完善的数字串的最左边和最右边（因为只有这两个位置可能被连接）
    public Object[] restoreArray(int[][] adjacentPairs) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int[] adjacentPair : adjacentPairs) {
            if (listList.isEmpty()) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add(adjacentPair[0]);
                integerList.add(adjacentPair[1]);
                listList.add(integerList);
            }else{
                for (List<Integer> list : listList) {
                    //判断有没有能够连接的选项
                    if (list.get(0) == adjacentPair[0]) {
                        list.add(0,adjacentPair[1]);
                        break;
                    } else if (list.get(0) == adjacentPair[1]) {
                        list.add(0,adjacentPair[0]);
                        break;
                    } else if (list.get(list.size() - 1) == adjacentPair[0]) {
                        list.add(adjacentPair[1]);
                        break;
                    } else if (list.get(list.size() - 1) == adjacentPair[1]) {
                        list.add(adjacentPair[0]);
                        break;
                    }
                    //没有能够连接的选项
                    List<Integer> temp = new ArrayList<>();
                    temp.add(adjacentPair[0]);
                    temp.add(adjacentPair[1]);
                    listList.add(temp);
                }
            }
        }
        //后面应该还需要将listList中的数据进行遍历，然后再进行拼接
        //但是由于看到官方题解很简单就没有继续写了
        return listList.get(0).toArray();
    }
    //官方题解思路：并不是记录整个字符串，而是记录每一个字母的邻居，因为开头和结尾的两个字符都是只有一个邻居
    //而除了开头和结尾的都是有两个邻居，所以可以根据邻居的数量来判断字符串的组成
    public int[] restoreArray2(int[][] adjacentPairs) {
        //字符 和 其邻居 的kv结构
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            //如果这两个字符没有添加过则进行添加
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            //两个字符互为彼此的邻居
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        //字符对的个数 + 1 = 最终字符串结果的长度
        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        //这里注意map也可以使用foreach进行遍历
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            //如果只有一个邻居，则说明这个元素可以用于充当开头
            if (adj.size() == 1) {
                ret[0] = e;
                //找到一个开头就可以了，就可以进行遍历了
                break;
            }
        }

        //第二个直接从第一个元素的邻居中进行获取
        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            //获取当前构造好的字符串的最后一个字符的邻居，即字符串尾部字符的邻居
            List<Integer> adj = map.get(ret[i - 1]);
            //由于从尾部进行获取邻居，所以这个尾部字符的邻居一定有一个已经消耗了（放到了倒数第二个字符的位置）
            //所以可以直接根据是否和第二个相等来判断使用哪一个邻居
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }
}