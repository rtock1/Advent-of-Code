package AOC_2021.day4;

import AOC_Helper_Classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args){
        String data = ReadInput.getString("AOC_2021.day4");
        int[] marked = new int[data.split("\n")[0].split(",").length];
        for (int i = 0;i<data.split("\n")[0].split(",").length;i++){
            marked[i] = Integer.parseInt(data.split("\n")[0].split(",")[i]);
        }
        int[][] boards = new int[data.split("\n").length/6][25];
        for (int i=0;i<boards.length;i++){
            for (int a=0;a<5;a++) {
                for (int b=0;b<5;b++) {
                    List<String> list = Arrays.asList(data.split("\n")[(i * 6) + 2 + a].split("  "));
                    if (String.join(" ",list).charAt(0) == ' '){
                        boards[i][5 * a + b] = Integer.parseInt(String.join(" ", list).substring(1).split(" ")[b]);
                    } else {
                        boards[i][5 * a + b] = Integer.parseInt(String.join(" ", list).split(" ")[b]);
                    }
                }
            }
        }
        boolean shouldBreak = false;
        int[] winner = new int[0];
        int[] templist = new int[0];
        int sum = 0;
        int totalBoardsThatWin = 0;
        int[] winners = new int[boards.length];
        for (int i=4;i<marked.length;i++){
            for (int a=0;a<boards.length;a++){
                templist = new int[i+1];
                for (int b = 0;b<=i;b++){
                    templist[b] = marked[b];
                }
                if (Part1.checkIfWin(templist,boards[a]) != -1){
                    if (!(ArrayHelp.checkList(winners,a+1))) {
                        totalBoardsThatWin += 1;
                        for (int d = 0; d < winners.length; d++) {
                            if (winners[d] == 0) {
                                winners[d] = a + 1;
                                break;
                            }
                        }
                    }
                    if (totalBoardsThatWin == boards.length) {
                        shouldBreak = true;
                        winner = boards[a];
                        break;
                    }
                }
            }
            if (shouldBreak){
                for (int a=0;a<winner.length;a++){
                    if (!(ArrayHelp.checkList(templist,winner[a]))){
                        sum += winner[a];
                    }
                }
                System.out.println(templist[templist.length-1]);
                break;
            }
        }
        System.out.println(sum);
    }
}
