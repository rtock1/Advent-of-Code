package AOC_2021.day6;

import AOC_Helper_Classes.*;

import java.util.*;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day6");
        long[] values = new long[9];
        for (int i:ListConvert.strtoint(data.split(","))){
            values[i] += 1;
        }
        for (int i=0;i<256;i++){
//            for (int c:values) {
//                System.out.print(c + ",");
//            }
//            System.out.print("\n");
            long store = values[0];
            for (int a=0;a<9;a++) {
                if (a!=8) {
                    values[a] = values[a + 1];
                } else {
                    values[a] = store;
                }
            }
            values[6] += values[8];
        }
        System.out.println(Arrays.stream(values).sum());
    }
}
