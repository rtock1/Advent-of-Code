package AOC_2015.day5;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args) {
        String data = ReadInput.getString("AOC_2015.day5");
        int vowels;
        boolean tworow;
        int total = 0;
        String[] d = data.split("\n");
        for (int i=0;i<d.length;i++){
            if (d[i].contains("ab") || d[i].contains("cd") || d[i].contains("pq") || d[i].contains("xy")){
                continue;
            }
            vowels = 0;
            tworow = false;
            for (int a=0;a<d[i].length();a++){
                if (Vowel.isVowel(d[i].charAt(a))){
                    vowels++;
                }
                if (a != d[i].length()-1){
                    if (d[i].charAt(a) == d[i].charAt(a+1)){
                        tworow = true;
                    }
                }
            }
            if (vowels >= 3 && tworow){
                total++;
            }
        }
        System.out.println(total);
    }
}
