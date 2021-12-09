package AOC_2021.day9;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day9");
        String[] d = data.split("\n");
        int x = 0;
        int y = 0;
        int finalTot = 0;
        for (String a:d){
            x=0;
            for (String b:a.split("")){
                int curr = 0;
                if (x!=0) {
                    if (Integer.parseInt(a.substring(x - 1, x)) > Integer.parseInt(a.substring(x, x + 1))) {
                        curr++;
                    }
                } else {
                    curr++;
                }
                if (y!=0){
                    if (Integer.parseInt(d[y-1].substring(x,x+1)) > Integer.parseInt(a.substring(x,x+1))){
                        curr ++;
                    }
                } else {
                    curr++;
                }
                if (x<a.length()-1){
                    if (Integer.parseInt(a.substring(x, x+1)) < Integer.parseInt(a.substring(x+1, x + 2))){
                        curr++;
                    }
                } else {
                    curr++;
                }
                if (y<d.length-1){
                    if (Integer.parseInt(d[y+1].substring(x,x+1)) > Integer.parseInt(a.substring(x,x+1))){
                        curr++;
                    }
                } else {
                    curr++;
                }
                if (curr==4){
                    finalTot += Integer.parseInt(b)+1;
                }
                x++;
            }
            y++;
        }
        System.out.println(finalTot);
    }
}
