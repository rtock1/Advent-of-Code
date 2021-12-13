package AOC_2021.day11;

import AOC_Helper_Classes.*;
import java.util.Arrays;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day11");
        String[] data2 = data.split("\n");
        int[][] d = new int[data2.length][data2[0].length()];
        for (int i=0;i<data2.length;i++){
            for (int a=0;a<data2[i].length();a++){
                d[i][a] = Integer.parseInt(String.valueOf(data2[i].charAt(a)));
            }
        }
        int flashes = 0;
        int prevFlashes = 0;
        for (int b=0;b<100;b++) {
            prevFlashes = flashes;
            for (int i = 0; i < d.length; i++) {
                for (int a = 0; a < d[i].length; a++) {
                    d[i][a]++;
                }
            }
            while (contain(d)) {
                for (int i = 0; i < d.length; i++) {
                    for (int a = 0; a < d[i].length; a++) {
                        if (d[i][a] > 9) {
                            flashes++;
                            flash(d, a, i);
                        }
                    }
                }
            }
            for (int i = 0; i < d.length; i++) {
                for (int a = 0; a < d[i].length; a++) {
                    if (d[i][a] > 9 || d[i][a] < 0) {
                        d[i][a] = 0;
                    }
                }
            }
        }
        System.out.println(flashes);
    }
    public static void flash(int[][] d,int x,int y){
        d[y][x] = -10;
        try{
            d[y-1][x] += 1;
        } catch (Exception e) {
        }
        try{
            d[y+1][x] += 1;
        } catch (Exception e) {
        }
        try{
            d[y][x-1] += 1;
        } catch (Exception e) {
        }
        try{
            d[y][x+1] += 1;
        } catch (Exception e) {
        }
        try{
            d[y-1][x-1] += 1;
        } catch (Exception e) {
        }
        try{
            d[y-1][x+1] += 1;
        } catch (Exception e) {
        }
        try{
            d[y+1][x-1] += 1;
        } catch (Exception e) {
        }
        try{
            d[y+1][x+1] += 1;
        } catch (Exception e) {
        }
    }
    public static void print(int[][] d){
        for (int[] c:d){
            System.out.println(Arrays.toString(c));
        }
    }
    public static boolean contain(int[][] d){
        for (int[] c:d){
            for (int b:c){
                if (b > 9){
                    return true;
                }
            }
        }
        return false;
    }
}
