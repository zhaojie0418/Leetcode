package CSVTest;

import java.io.*;

public class Reader {
    public static void main(String[] args) {
        new Reader().read();

    }
    File file = new File("D:\\java_workspace\\Leetcode\\src\\main\\java\\CSVTest\\1322.csv");
    public void read() {
        try{
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            BufferedReader textFile = new BufferedReader(new FileReader(file));
            String lineDta = "";

            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            while ((lineDta = textFile.readLine()) != null){
                System.out.println(lineDta);
            }

            textFile.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
    }
}
