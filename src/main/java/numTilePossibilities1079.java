public class numTilePossibilities1079 {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        char[] charArray = tiles.toCharArray();
        for (char c : charArray) {
            count[c - 'A']++;
        }
        // tiles 里所有的信息都存在 count 里，对 count 执行深度优先遍历即可
        return dfs(count);
    }

    /**
     * 设计递归函数的返回值
     *
     * @return 在当前的频数数组下，可以产生的排列数
     */
    private int dfs(int[] count) {

        int res = 0;
        for (int i = 0; i < 26; i++) {
            //相当于每一个结点都是26叉树，判断每一次结点是否能够生成对应的分叉，如果不能则跳过
            if (count[i] == 0) {
                continue;
            }
            res++;
            count[i]--;
            res += dfs(count);
            //注意恢复count[i]
            count[i]++;
        }
        return res;
    }

}
