package xiaozhang;

import java.io.IOException;

public class readKey {
    public static void main(String[] args) throws IOException {
        char c;
        do {
            c = (char)System.in.read();
        } while (c != 'q');
        System.out.println("----程序退出----");
    }
}
