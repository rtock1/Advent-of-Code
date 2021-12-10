package AOC_2021.day10;

import AOC_Helper_Classes.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day10");
        String[] d = data.split("\n");
        BigInteger[] numbers = new BigInteger[d.length];
        int counter = 0;
        for (String c:d) {
            BigInteger curr = corrupted(c);
            if (!curr.equals(new BigInteger("0"))){
                numbers[counter] = corrupted(c);
                counter++;
            }
        }
        BigInteger[] numbers2 = new BigInteger[counter];
        for (int a = 0;a<counter;a++){
            numbers2[a] = numbers[a];
        }
        Arrays.sort(numbers2);
        System.out.println(numbers2[numbers2.length/2]);
    }
    public static boolean openClose(char c){
        switch (c){
            case '(':
            case '[':
            case '{':
            case '<':
                return true;
            default:
                return false;
        }
    }
    public static BigInteger corrupted(String c){
        char[] opens = new char[100];
        int current = 0;
        for (String a:c.split("")){
            if (openClose(a.charAt(0))){
                opens[current] = a.charAt(0);
                current++;
            } else {
                current--;
                if ((opens[current] =='(' && a.charAt(0) != ')') || (opens[current] =='[' && a.charAt(0) != ']') || (opens[current] =='{' && a.charAt(0) != '}') || (opens[current] =='<' && a.charAt(0) != '>')){
                    return new BigInteger("0");
                }
                opens[current] = '.';
            }
        }
        BigInteger total = new BigInteger("0");

        int len = 0;
        for (char i:opens){
            if (i=='(' || i=='[' || i=='{' || i== '<'){
                len++;
            }
        }
        for (int i=len-1;i>=0;i--){
            switch (opens[i]){
                case '(':
                    total = total.multiply(new BigInteger("5"));
                    total = total.add(new BigInteger("1"));
                    break;
                case '[':
                    total = total.multiply(new BigInteger("5"));
                    total = total.add(new BigInteger("2"));
                    break;
                case '{':
                    total = total.multiply(new BigInteger("5"));
                    total = total.add(new BigInteger("3"));
                    break;
                case '<':
                    total = total.multiply(new BigInteger("5"));
                    total = total.add(new BigInteger("4"));
                    break;
                default:
                    break;
            }
        }
        return total;
    }
}
