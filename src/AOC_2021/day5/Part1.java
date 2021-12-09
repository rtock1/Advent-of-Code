package AOC_2021.day5;

import AOC_Helper_Classes.*;

public class Part1 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day5");
        String[] d = data.split("\n");
        int rows = 1000;
        int cols = 1000;
        int[] grid = new int[rows * cols];
        for (String i:d){
            int x1 = Integer.parseInt(i.split(",")[0]);
            int y1 = Integer.parseInt(i.split(",")[1].split(" ")[0]);
            int x2 = Integer.parseInt(i.split(",")[1].split(" ")[2]);
            int y2 = Integer.parseInt(i.split(",")[2]);
            if (x1 == x2 || y1 == y2) {
                for (int a = 0; a < grid.length; a++) {
                    if (((x1 <= a%rows && x2 >= a%rows) || (x1 >= a % rows && x2 <= a % rows)) && ((y1 >= a / rows && y2 <= a / rows) || (y1 <= a / rows && y2 >= a / rows))) {
                        grid[a] += 1;
                    }
                }
            }
        }
//        for (int i = 0;i<100;i++){
//            if (i%10 == 9){
//                System.out.print(grid[i] + "\n");
//            } else {
//                System.out.print(grid[i] + " ");
//            }
//        }
        int total = 0;
        for (int i:grid){
            if (i>=2){
                total ++;
            }
        }
        System.out.println(total);
    }
}
