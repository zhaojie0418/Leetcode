import java.util.ArrayList;
import java.util.List;

public class generate118 {
    public static void main(String[] args) {
        System.out.println(new generate118().generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowList = new ArrayList<>();
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 1;i<=numRows;i++){
            if(i==1){
                rowList.add(new ArrayList<>(){{add(1);}});
                continue;
            }
            if(i==2){
                row.add(1);
                row.add(1);
                rowList.add(row);
                continue;
            }
            List<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            for(int j = 1;j<i-1;j++){
                newRow.add(row.get(j-1)+row.get(j));
            }
            newRow.add(1);
            rowList.add(newRow);
            row=newRow;
        }
        return rowList;
    }
}
