package AOC_Helper_Classes;

public class ArrayHelp {
    public static boolean checkList(int[] list, int key){
        for (int i=0;i<list.length;i++){
            if (key == list[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean checkList(char[] list, char key){
        for (int i=0;i<list.length;i++){
            if (key == list[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean checkList(String[] list, String key){
        for (int i=0;i<list.length;i++){
            if (key.equals(list[i])){
                return true;
            }
        }
        return false;
    }
}
