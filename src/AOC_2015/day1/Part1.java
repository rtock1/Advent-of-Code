package AOC_2015.day1;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2015.day1");
        int counter = 0;
        for (int i=0;i<data.length();i++){
            if (data.charAt(i)=='('){
                counter += 1;
            } else {
                counter -= 1;
            }
        }
        System.out.println(counter);
    }
}
