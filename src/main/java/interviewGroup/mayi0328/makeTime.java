package interviewGroup.mayi0328;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class makeTime {
    static HashMap<String, Integer> money;
    static HashMap<String, Tool> pay;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupNumber = sc.nextInt();
        sc.nextLine();
        pay = new LinkedHashMap<>();
        money = new HashMap<>();
        for (int i = 0; i < groupNumber; i++) {
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            String name = strings[0];
            int comTime = Integer.parseInt(strings[1]);
            int needCount = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> needTool = new HashMap<>();
            for (int j = 0; j < needCount; j++) {
                String sTemp = sc.nextLine();
                String[] stringsTemp = sTemp.split(" ");
                String nameTemp = stringsTemp[0];
                int countTemp = Integer.parseInt(stringsTemp[1]);
                needTool.put(nameTemp, countTemp);
            }
            Tool curTool = new Tool(comTime, needTool);
            pay.put(name, curTool);
        }
        for (String s : pay.keySet()) {
            int res = 0;
            if (money.containsKey(s)) {
                res = money.get(s);
            } else {
                res = getMoney(s);
            }
            System.out.println(s + " " + res);
        }
    }

    public static int getMoney(String name) {
        Tool curTool = pay.get(name);
        HashMap<String, Integer> need = curTool.needTool;
        if (!need.isEmpty()) {
            int res = 0;
            for (String s : need.keySet()) {
                res += getMoney(s) * need.get(s);
            }
            res += curTool.comTime;
            money.put(name, res);
            return res;
        } else {
            money.put(name, curTool.comTime);
            return curTool.comTime;
        }
    }
}


class Tool {
    int comTime;
    HashMap<String, Integer> needTool;

    public Tool(int comTime, HashMap<String, Integer> needTool) {
        this.comTime = comTime;
        this.needTool = needTool;
    }
}