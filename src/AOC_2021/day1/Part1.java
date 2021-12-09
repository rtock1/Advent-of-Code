package AOC_2021.day1;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day1"); // getting the puzzle input
        String[] d = data.split("\n");

        int prev = Integer.parseInt(d[0]);
        int total = 0;
        for (int i=1;i<d.length;i++){
            if (Integer.parseInt(d[i])>prev){
                total++;
            }
            prev = Integer.parseInt(d[i]);
        }
        System.out.println(total);
    }
}
