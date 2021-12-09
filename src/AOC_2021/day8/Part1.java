package AOC_2021.day8;

import AOC_Helper_Classes.*;

import java.util.Arrays;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day8");
        String[] d = data.split("\n");
        int total = 0;
        for (String a:d) {
            String[] before = a.split(" \\| ")[0].split(" ");
            String[] after = a.split(" \\| ")[1].split(" ");
            for (String b:after){
                if (b.length() == 2||b.length()==4||b.length()==3||b.length()==7){
                    total++;
                }
            }
        }
        System.out.println("\n"+total);
    }
}
