package AOC_2021.day7;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day7");
        int[] d = ListConvert.strtoint(data.split(","));
        int mintotal = 10000000;
        for (int i=0;i<1000;i++){
            int total = 0;
            for (int a:d){
                total += Math.abs(a-i);
            }
            if (total < mintotal){
                mintotal = total;
            }
        }
        System.out.println(mintotal);
    }
}
