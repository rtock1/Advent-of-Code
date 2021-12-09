package AOC_2015.day3;

import AOC_Helper_Classes.*;
import java.util.Arrays;

public class Part1 {
    public static void main(String[] args) {
        String data = ReadInput.getString("AOC_2015.day3");
        int[][] houses = new int[data.length()][2];
        int[] currPos = new int[2];
        for (int i=0;i<data.length();i++){
            if (data.charAt(i) == '>'){
                currPos[0] += 1;
            } else if(data.charAt(i) == '<'){
                currPos[0] -= 1;
            } else if (data.charAt(i) == 'v'){
                currPos[1] -= 1;
            } else if (data.charAt(i) == '^'){
                currPos[1] += 1;
            }
            boolean matches = false;
            for (int a=0;a<houses.length;a++){
                if (Arrays.equals(houses[a],currPos)){
                    matches = true;
                }
            }
            if (!matches){
                houses[i] = new int[]{currPos[0],currPos[1]};
            }
        }
        int counter = 1;
        for (int i=0;i<houses.length;i++){
            if (!Arrays.equals(houses[i],new int[]{0,0})){
                counter ++;
            }
        }
        System.out.println(counter);
    }
}
