package AOC_2021.day8;

import AOC_Helper_Classes.*;

import java.util.Arrays;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day8");
        String[] d = data.split("\n");
        int total = 0;
        for (String a:d) {
            String[] numbers = new String[10];
            String[] before = a.split(" \\| ")[0].split(" ");
            String[] after = a.split(" \\| ")[1].split(" ");
            numbers[1] = getSpecificLength(before,2);
            numbers[4] = getSpecificLength(before,4);
            numbers[7] = getSpecificLength(before,3);
            numbers[8] = getSpecificLength(before,7);
            String[] fives = getAllLength(before, 5);
            for (String b:fives){
                if (findDifference(b, numbers[1]).length == 3){
                    numbers[3] = b;
                }
            }
            String[] sixes = getAllLength(before,6);
            for (String b:sixes){
                if (findDifference(b,numbers[1]).length == 5) {
                    numbers[6] = b;
                }
            }
            for (String b:fives){
                if (findDifference(b,numbers[6]).length == 1){
                    numbers[5] = b;
                } else {
                    if (findDifference(b, numbers[4]).length == 2) {
                        numbers[3] = b;
                    }
                    if (findDifference(b, numbers[4]).length == 3) {
                        numbers[2] = b;
                    }
                }
            }
            for (String b:sixes){
                if (b != numbers[6]){
                    if (findDifference(b,numbers[5]).length == 1){
                        numbers[9] = b;
                    } else {
                        numbers[0] = b;
                    }
                }
            }
            //System.out.println(Arrays.toString(numbers));
            String currTol = "";
            for (String b:after){
                for (int i=0;i<10;i++){
                    if (findDifference(b,numbers[i]).length==0){
                        currTol += i;
                    }
                }
            }
            System.out.println(currTol);
            total += Integer.parseInt(currTol);
        }
        System.out.println(total);
    }
    public static String getSpecificLength(String[] l, int length){
        for (String a:l){
            if (a.length()==length){
                return a;
            }
        }
        return "";
    }
    public static String[] getAllLength(String[] l, int length){
        String[] end;
        int counter = 0;
        for (String a:l){
            if (a.length()==length){
                counter ++;
            }
        }
        end = new String[counter];
        counter = 0;
        for (String a:l){
            if (a.length()==length){
                end[counter] = a;
                counter++;
            }
        }
        return end;
    }
    public static char[] findDifference(String str1, String str2){
        char[] word1 = new char[str1.length()];
        char[] word2 = new char[str2.length()];
        char[] pred;
        for (int i=0;i<str1.length();i++){
            word1[i] = str1.charAt(i);
        }
        for (int i=0;i<str2.length();i++){
            word2[i] = str2.charAt(i);
        }
        int counter = 0;
        if (str1.length()>str2.length()) {
            pred = new char[str1.length()];
            for (char a : word1) {
                if (!(ArrayHelp.checkList(word2, a))) {
                    pred[counter] = a;
                    counter++;
                }
            }
        } else {
            pred = new char[str2.length()];
            for (char a : word2) {
                if (!(ArrayHelp.checkList(word1, a))) {
                    pred[counter] = a;
                    counter++;
                }
            }
        }
        char[] end = new char[counter];
        counter=0;
        for (int i=0;i<pred.length;i++){
            if (pred[i]=='a'||pred[i]=='b'||pred[i]=='c'||pred[i]=='d'||pred[i]=='e'||pred[i]=='f'||pred[i]=='g'){
                end[counter] = pred[i];
                counter++;
            }
        }
        return end;
    }
}
