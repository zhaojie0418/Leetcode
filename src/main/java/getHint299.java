import java.util.HashMap;

public class getHint299 {
    public static void main(String[] args) {
//        System.out.println(new getHint299().getHint("1807","7810"));
        System.out.println(new getHint299().getHint("1123","0111"));

    }
    //该方法有缺陷，有奶牛误判成公牛的情况，需要先对相同的元素进行遍历再对不同的元素进行遍历，未改善，详见下面官方题解
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<secret.length();i++){
            char c = secret.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int bullCount = 0;
        int cowsCount = 0;
        for(int i = 0;i<secret.length();i++){
            //如果两个字符串同一个位置的字符相同
            if(secret.charAt(i)==guess.charAt(i)){
                char c = secret.charAt(i);
                if(check(c,map))
                    bullCount++;

            }
            //如果两个字符串的位置不同
            else{
                char c = guess.charAt(i);
                if(check(c,map))
                    cowsCount++;
            }
        }
        return bullCount+"A"+cowsCount+"B";
    }
    public boolean check(char c ,HashMap<Character,Integer> map){
        if(map.containsKey(c)){
            int count = map.get(c);
            if(count==1){
                map.remove(c);
            }else{
                map.put(c,count-1);
            }
            return true;
        }else{
            return false;
        }
    }

    //官方题解方法：由于需要先判断公牛才能判断奶牛，所以不相同时将二者存放在数组中进行比较而不是直接相比
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
