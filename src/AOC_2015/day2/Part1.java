package AOC_2015.day2;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2015.day2");
        String[] d = data.split("\n");
        int total = 0;
        for (int i=0;i<d.length;i++){
            int[] curr = ListConvert.strtoint(d[i].split("x"));
            total += curr[0]*curr[1]*2;
            total += curr[0]*curr[2]*2;
            total += curr[1]*curr[2]*2;
            total += MinMax.min(curr)*MinMax.min(MinMax.removeMin(curr));
        }
        System.out.println(total);
    }
}
