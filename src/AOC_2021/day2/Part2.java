package AOC_2021.day2;

import AOC_Helper_Classes.*;

public class Part2 {
    public static void main(String[] args) {
        String data = ReadInput.getString("AOC_2021.day2");
        String[] d = data.split("\n");
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (String a : d) {
            if (a.split(" ")[0].equals("forward")){
                horizontal += Integer.parseInt(a.split(" ")[1]);
                depth += aim * Integer.parseInt(a.split(" ")[1]);
            } else if (a.split(" ")[0].equals("down")){
                aim += Integer.parseInt(a.split(" ")[1]);
            } else if (a.split(" ")[0].equals("up")){
                aim -= Integer.parseInt(a.split(" ")[1]);
            } else {
                System.out.println("error");
            }
        }
        System.out.println(horizontal* depth);
    }
}
