package AOC_2021.day3;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day3");
        String[] d = data.split("\n");
        String gamma = "";
        String epsilon = "";
        for (int i=0;i<d[0].length();i++){
            int zeros = 0;
            int ones = 1;
            for (int a=0;a<d.length;a++){
                if (d[a].charAt(i)=='0'){
                    zeros += 1;
                } else {
                    ones += 1;
                }
            }
            if (zeros > ones){
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }
        System.out.println(Integer.parseInt(gamma,2) * Integer.parseInt(epsilon,2));
    }
}
