package AOC_2015.day5;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args) {
        String data = ReadInput.getString("AOC_2015.day5");
        int total = 0;
        String[] d = data.split("\n");
        for (String val : d) {
            boolean sandwich = false;
            boolean twoLetters = false;
            for (int a=0;a<val.length();a++){
                if (a<val.length()-2 && val.charAt(a)==val.charAt(a+2)) {
                    sandwich = true;
                }
                if (a<val.length()-1 && (val.substring(0,a).contains(val.substring(a,a+2)))||(a<val.length()-2&&val.substring(a+2).contains(val.substring(a,a+2)))){
                    twoLetters = true;
                }
            }
            if (sandwich&&twoLetters){
                total++;
            }
        }
        System.out.println(total);
    }
}
