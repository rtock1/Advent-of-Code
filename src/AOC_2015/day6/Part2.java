package AOC_2015.day6;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args) {
        String data = ReadInput.getString("AOC_2015.day6");
        String[] d = data.split("\n");
        int[][] lights = new int[1000][1000];
        for (String curr : d){
            if (curr.split(" ")[1].equals("on")){
                turnOn(curr, lights);
            } else if (curr.split(" ")[1].equals("off")){
                turnOff(curr, lights);
            } else {
                toggle(curr, lights);
            }
        }
        int total = 0;
        for (int x=0;x<1000;x++){
            for (int y=0;y<1000;y++){
                total += lights[x][y];
            }
        }
        System.out.println(total);
    }
    public static void turnOn(String data, int[][] lights){
        int x1 = Integer.parseInt(data.split(",")[0].split("on ")[1]);
        int y1 = Integer.parseInt(data.split(",")[1].split(" thr")[0]);
        int x2 = Integer.parseInt(data.split(",")[1].split("gh ")[1]);
        int y2 = Integer.parseInt(data.split(",")[2]);
        for (int x = 0; x<1000;x++){
            for (int y=0;y<1000;y++){
                if (x>=x1 && x<=x2 && y>=y1 && y<=y2){
                    lights[x][y] += 1;
                }
            }
        }
    }
    public static void turnOff(String data, int[][] lights){
        int x1 = Integer.parseInt(data.split(",")[0].split("off ")[1]);
        int y1 = Integer.parseInt(data.split(",")[1].split(" thr")[0]);
        int x2 = Integer.parseInt(data.split(",")[1].split("gh ")[1]);
        int y2 = Integer.parseInt(data.split(",")[2]);
        for (int x = 0; x<1000;x++){
            for (int y=0;y<1000;y++){
                if (x>=x1 && x<=x2 && y>=y1 && y<=y2 && lights[x][y] != 0){
                    lights[x][y] -= 1;
                }
            }
        }
    }
    public static void toggle(String data, int[][] lights){
        int x1 = Integer.parseInt(data.split(",")[0].split("toggle ")[1]);
        int y1 = Integer.parseInt(data.split(",")[1].split(" thr")[0]);
        int x2 = Integer.parseInt(data.split(",")[1].split("gh ")[1]);
        int y2 = Integer.parseInt(data.split(",")[2]);
        for (int x = 0; x<1000;x++){
            for (int y=0;y<1000;y++){
                if (x>=x1 && x<=x2 && y>=y1 && y<=y2){
                    lights[x][y] += 2;
                }
            }
        }
    }
}
