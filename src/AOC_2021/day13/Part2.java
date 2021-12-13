package AOC_2021.day13;

import AOC_Helper_Classes.ReadInput;

import java.util.*;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day13");
        String[] d = data.split("\n");
        int instructionRows = 750;
        int xMax = 0;
        int yMax = 0;
        for (int i=0;i<instructionRows;i++){
            if (Integer.parseInt(d[i].split(",")[0])>xMax){
                xMax = Integer.parseInt(d[i].split(",")[0]);
            }
            if (Integer.parseInt(d[i].split(",")[1])>yMax){
                yMax = Integer.parseInt(d[i].split(",")[1]);
            }
        }
        String[] parsed = new String[yMax+1];
        for (int a=0;a<parsed.length;a++){
            parsed[a] = "";
            for (int i=0;i<xMax+1;i++){
                parsed[a] += ".";
            }
        }
        for (int i=0;i<instructionRows;i++){
            parsed[Integer.parseInt(d[i].split(",")[1])] = parsed[Integer.parseInt(d[i].split(",")[1])].substring(0,Integer.parseInt(d[i].split(",")[0])) + "#" + parsed[Integer.parseInt(d[i].split(",")[1])].substring(Integer.parseInt(d[i].split(",")[0])+1);
        }
        //parsed = instruction(d[instructionRows + 1], parsed);
        for (int i=1;i<13;i++){
            parsed = instruction(d[instructionRows + i], parsed);
        }
        //parsed = instruction(d[instructionRows + 2], parsed);
        int total = 0;
        for (String c:parsed){
            System.out.println(c);
            for (String a:c.split("")){
                if(a.equals("#")){
                    total++;
                }
            }
        }
        System.out.println(total);
    }
    public static String[] instruction(String instruction, String[] d){
        int num = Integer.parseInt(instruction.split(" ")[2].split("=")[1]);
        if (instruction.split(" ")[2].split("=")[0].equals("y")){
            String[] end = new String[num];
            for (int i=0;i<num;i++){
                end[i] = d[i];
            }
            for (int i=num+1; i<d.length;i++){
                for (int a=0;a<d[i].length();a++){
                    if (d[i].charAt(a) == '#'){
                        end[(num*2) - i] = end[(num*2) - i].substring(0,a) + "#" + end[(num*2) - i].substring(a+1);
                    }
                }
            }
            return end;
        } else {
            for (int i=0; i<d.length;i++){
                for (int a=num+1;a<d[i].length();a++){
                    if (d[i].charAt(a) == '#'){
                        d[i] = d[i].substring(0,num*2 - a) + "#" + d[i].substring(num*2 - a + 1);
                    }
                }
            }
            for (int i=0;i<d.length;i++){
                d[i] = d[i].substring(0,num);
            }
            return d;
        }
    }
}
