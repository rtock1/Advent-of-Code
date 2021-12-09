package AOC_2015.day1;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2015.day1");
        int counter = 0;
        for (int i=0;i<data.length();i++){
            if (data.charAt(i)=='('){
                counter += 1;
            } else if (data.charAt(i)==')'){
                counter -= 1;
            }
            if (counter < 0){
                System.out.println(i+1);
                break;
            }
        }
    }
}
