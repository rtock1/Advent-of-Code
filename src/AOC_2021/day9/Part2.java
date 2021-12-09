package AOC_2021.day9;

import AOC_Helper_Classes.*;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day9");
        String[] d = data.split("\n");
        int x = 0;
        int y = 0;
        int[] max3 = new int[3];
        for (int i=0;i<d.length;i++){
            for (int i2=0;i2<d[i].length();i2++){
                int temp = getBasin(i2,i,d);
                Arrays.sort(max3);
                if (temp>max3[0]){
                    max3[0] = temp;
                }
            }
        }
        System.out.println(max3[0]*max3[1]*max3[2]);
    }
    public static int getBasin(int x, int y, String[] d){
        if (Integer.parseInt(String.valueOf(d[y].charAt(x))) == 9){
            return 0;
        }
        d[y] = d[y].substring(0,x)+"9"+d[y].substring(x+1);
        int total = 1;
        if (y!=0){
            total += getBasin(x,y-1,d);
        }
        if (y<d.length-1){
            total += getBasin(x,y+1,d);
        }
        if (x<d[y].length()-1){
            total += getBasin(x+1,y,d);
        }
        if (x!=0){
            total += getBasin(x-1,y,d);
        }
        return total;
    }
}
