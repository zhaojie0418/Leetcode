import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class asteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        //注意这里使用双端队列来模拟栈的实现
        Deque<Integer> stack = new LinkedList<>();
        //这里记录下栈中向右移动的行星数量
        int countRight = 0;
        for(int i = 0;i<asteroids.length;i++){
            int number = asteroids[i];
            //如果行星向右移动
            if(number>0){
                stack.push(number);
                countRight++;
            }
            //如果行星向左移动
            //注意栈的情况只能是 负数（0个或多个）+ 正数（0个或多个）
            else{
               while(true){
                   if(countRight == 0){
                       stack.push(number);
                       break;
                   }else{
                       int rightStar = stack.pop();
                       countRight--;
                       //这里有三种情况，向左，向右，相等
                       if(rightStar + number == 0){
                           break;
                       }
                       if(rightStar + number >0){
                           stack.push(rightStar);
                           countRight++;
                           break;
                       }
                       //能够突破两个if来到这的一定是向左的更厉害
                   }
               }
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    //官方题解  思路相同，使用更为简洁的代码进行实现
    public int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

}
