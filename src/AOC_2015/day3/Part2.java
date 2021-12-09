package AOC_2015.day3;

import AOC_Helper_Classes.*;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        String data = ReadInput.getString("AOC_2015.day3");
        int[][] houses = new int[data.length()][2];
        int[] santaPos = new int[2];
        int[] roboPos = new int[2];
        int[] currPos = new int[2];
        for (int i=0;i<data.length();i++){
            if (data.charAt(i) == '>'){
                if (i%2==0){
                    santaPos[0] += 1;
                } else {
                    roboPos[0] += 1;
                }
            } else if(data.charAt(i) == '<'){
                if (i%2==0){
                    santaPos[0] -= 1;
                } else {
                    roboPos[0] -= 1;
                }
            } else if (data.charAt(i) == 'v'){
                if (i%2==0){
                    santaPos[1] -= 1;
                } else {
                    roboPos[1] -= 1;
                }
            } else if (data.charAt(i) == '^'){
                if (i%2==0){
                    santaPos[1] += 1;
                } else {
                    roboPos[1] += 1;
                }
            }
            boolean matches = false;
            if (i%2==0) {
                currPos = new int[]{santaPos[0],santaPos[1]};
            } else {
                currPos = new int[]{roboPos[0],roboPos[1]};
            }
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
