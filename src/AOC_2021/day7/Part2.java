package AOC_2021.day7;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day7");
        int[] d = ListConvert.strtoint(data.split(","));
        int mintotal = 1000000000;
        for (int i=0;i<1000;i++){
            int total = 0;
            for (int a:d){
                total += triangle(Math.abs(a-i));
            }
            if (total < mintotal){
                mintotal = total;
            }
        }
        System.out.println(mintotal);
    }
    public static int triangle(int a){
        int total = 0;
        while (a > 0){
            total += a;
            a -= 1;
        }
        return total;
    }
}
