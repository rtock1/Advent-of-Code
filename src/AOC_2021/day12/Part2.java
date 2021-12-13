package AOC_2021.day12;

import java.util.*;
import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day12");
        String[] d = data.split("\n");
        int total = 0;
        for (String c: find(d, "start")){
            if (c.toUpperCase().equals(c)) {
                total += getStuff(d, new String[0], c, false, new String[]{c});
            } else {
                total += getStuff(d, new String[]{c}, c, false, new String[]{c});
            }
        }
        System.out.println(total);
    }
    public static int getStuff(String[] d, String[] used, String curr, boolean smallCaveTwice, String[] route){
        //System.out.println(Arrays.toString(used));
        String[] options = find(d, curr);
        //System.out.println(Arrays.toString(find(d, "end")));
        int routes = 0;
        for (String c:options){
            String[] currRoute = new String[route.length + 1];
            for (int i=0;i<route.length;i++){
                currRoute[i] = route[i];
            }
            currRoute[currRoute.length-1] = c;
            boolean works = true;
            for (String b: used){
                if (c.equals(b)){
                    works = false;
                }
            }
            if (c.equals("end")) {
                //System.out.println(Arrays.toString(currRoute));
                routes += 1;
            } else if (c.equals("start")) {
            } else if (works){
                if (c.toUpperCase().equals(c)) {
                    routes += getStuff(d, used, c, smallCaveTwice, currRoute);
                } else {
                    String[] temp = new String[used.length + 1];
                    for (int i=0;i<used.length;i++){
                        temp[i] = used[i];
                    }
                    temp[temp.length-1] = c;
                    routes += getStuff(d, temp, c, smallCaveTwice, currRoute);
                }
            } else {
                if (!smallCaveTwice){
                    routes += getStuff(d, used, c, true, currRoute);
                }
            }
        }
        //System.out.println(routes);
        return routes;
    }
    public static String[] find(String[] d, String curr){
        String[] end = new String[100];
        int counter = 0;
        for (String c: d){
            if (c.contains(curr+"-")||c.contains("-"+curr)){
                String[] temp = c.split(curr);
                try{
                    end[counter] = temp[1].split("-")[1];
                } catch (Exception e) {
                    end[counter] = temp[0].split("-")[0];
                }
                counter++;
            }
        }
        String[] end2 = new String[counter];
        counter = 0;
        for (String c: end){
            if (c != null){
                end2[counter] = c;
                counter++;
            }
        }
        return end2;
    }
}
