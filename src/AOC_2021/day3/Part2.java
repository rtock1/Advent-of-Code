package AOC_2021.day3;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args){
        String co2 = "";
        String data = ReadInput.getString("AOC_2021.day3");
        String[] d = data.split("\n");
        for (int i=0;i<d[0].length();i++){
            int zeros = 0;
            int ones = 0;
            for (int a=0;a<d.length;a++){
                if (d[a].charAt(i)=='0'){
                    zeros += 1;
                } else if (d[a].charAt(i)=='1') {
                    ones += 1;
                }
            }
            if (zeros > ones){
                for (int a=0;a<d.length;a++){
                    if (d[a].charAt(i) == '1'){
                        d[a] = "222222222222";
                    }
                }
            } else {
                for (int a=0;a<d.length;a++){
                    if (d[a].charAt(i) == '0'){
                        d[a] = "222222222222";
                    }
                }
            }
        }
        String o2 = "";
        for (int i=0;i<d.length;i++){
            if (d[i].charAt(0) != '2'){
                o2 = d[i];
            }
        }
        data = ReadInput.getString("AOC_2021.day3");
        d = data.split("\n");
        for (int i=0;i<d[0].length();i++){
            int zeros = 0;
            int ones = 0;
            for (int a=0;a<d.length;a++){
                if (d[a].charAt(i)=='0'){
                    zeros += 1;
                } else if (d[a].charAt(i)=='1') {
                    ones += 1;
                }
            }
            if (zeros > ones){
                for (int a=0;a<d.length;a++){
                    if (d[a].charAt(i) == '0'){
                        d[a] = "222222222222";
                    }
                }
            } else if (ones > zeros) {
                for (int a=0;a<d.length;a++){
                    if (d[a].charAt(i) == '1'){
                        d[a] = "222222222222";
                    }
                }
            } else {
                for (int a=0;a<d.length;a++){
                    if (d[a].charAt(i) == '0'){
                        co2 = d[a];
                    }
                }
            }
        }
        for (int i=0;i<d.length;i++){
            if (d[i].charAt(0) != '2'){
                co2 = d[i];
            }
        }
        System.out.println(o2);
        System.out.println(co2);
        System.out.println(Integer.parseInt(o2,2) * Integer.parseInt(co2,2));
    }
}
