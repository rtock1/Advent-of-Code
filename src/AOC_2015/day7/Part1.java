package AOC_2015.day7;

import AOC_Helper_Classes.*;

import java.util.Arrays;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2015.day7");
        String[] d = data.split("\n");
        process(d, "f");
        //System.out.println(process(d, "f"));
    }
    public static String getLetter(String[] d, String letter){
        String whatReturn = " ";
        for (String a:d){
            if (a.split(" -> ")[1].equals(letter)){
                whatReturn = a.split(" -> ")[0];
            }
        }
        if (whatReturn.equals(" ")){
            //System.out.println("hi");
        } else {
            //System.out.println("hi2");
        }
        return whatReturn;
    }
    public static int process(String[] d, String letter){
        try{
            Integer.parseInt("a");
            //return Integer.parseInt(getLetter(d, letter));
        } catch (NumberFormatException e) {
            String curr = getLetter(d, letter);
            System.out.println(Arrays.toString(getLetter(d,letter).split(" ")));
            double xa = 0;
            for (int i=0;i<1000000;i++){
                xa = Math.pow(2,xa);
            }
            System.out.println(Arrays.toString(curr.split(" ")));
            if (curr.split(" ")[0].equals("NOT")){
                int[] thing1 = toBinary(process(d, curr.split(" ")[1]));
                int[] end = new int[16];
                for (int i=0;i<16;i++){
                    end[i] = (1+thing1[i])%2;
                }
                //System.out.println(fromBinary(end));
            } else if (curr.split(" ")[1].equals("LSHIFT")){
                int[] thing1 = toBinary(process(d, curr.split(" ")[0]));
                int shift = Integer.parseInt(curr.split(" ")[2]);
                int[] end = new int[16];
                //System.out.println(Arrays.toString(thing1));
                //System.out.println(shift);
                //System.out.println(fromBinary(end));
            } else if (curr.split(" ")[1].equals("AND")){
                int[] thing1 = toBinary(process(d, curr.split(" ")[0]));
                int[] thing2 = toBinary(process(d, curr.split(" ")[2]));
                int[] end = new int[16];
                for (int i=0;i<16;i++){
                    if (thing1[i] == 1 && thing2[i] == 1){
                        end[i] = 1;
                    }
                }
                //System.out.println(fromBinary(end));
            } else if (curr.split(" ")[1].equals("OR")){
                int[] thing1 = toBinary(process(d, curr.split(" ")[0]));
                int[] thing2 = toBinary(process(d, curr.split(" ")[2]));
                int[] end = new int[16];
                for (int i=0;i<16;i++){
                    if (thing1[i] == 1 || thing2[i] == 1){
                        end[i] = 1;
                    }
                }
                //System.out.println(fromBinary(end));
            }
        }
        return 0;
    }
    public static int[] toBinary(int number){
        int[] end = new int[16];
        String binary = Integer.toBinaryString(number);
        int counter = 16-binary.length();
        for (String i:binary.split("")){
            end[counter] = Integer.parseInt(i);
            counter++;
        }
        return end;
    }
    public static int fromBinary(int[] number){
        int total = 0;
        for (int i=0;i<16;i++){
            if (number[15-i] == 1){
                total += Math.pow(2, i);
            }
        }
        return total;
    }
}
