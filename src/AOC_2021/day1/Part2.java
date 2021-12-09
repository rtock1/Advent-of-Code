package AOC_2021.day1;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day1"); //get puzzle input
        String[] d = data.split("\n");

        int prev = Integer.parseInt(d[0]) + Integer.parseInt(d[1]) + Integer.parseInt(d[2]);
        int total = 0;
        for (int i=3;i<d.length;i++){
            if (Integer.parseInt(d[i])+prev - Integer.parseInt(d[i-3])>prev){
                total++;
            }
            prev += Integer.parseInt(d[i]);
            prev -= Integer.parseInt(d[i-3]);
        }
        System.out.println(total);
    }
}
