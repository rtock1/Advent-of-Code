package AOC_2021.day10;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day10");
        String[] d = data.split("\n");
        int total = 0;
        for (String c:d){
            total += corrupted(c);
        }
        System.out.println(total);
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
    public static int corrupted(String c){
        char[] opens = new char[100];
        int current = 0;
        for (String a:c.split("")){
            if (openClose(a.charAt(0))){
                opens[current] = a.charAt(0);
                current++;
            } else {
                current--;
                if ((opens[current] =='(' && a.charAt(0) != ')') || (opens[current] =='[' && a.charAt(0) != ']') || (opens[current] =='{' && a.charAt(0) != '}') || (opens[current] =='<' && a.charAt(0) != '>')){
                    switch (a.charAt(0)){
                        case ')':
                            return 3;
                        case ']':
                            return 57;
                        case '}':
                            return 1197;
                        case '>':
                            return 25137;
                    }
                }
            }
        }
        return 0;
    }
}
