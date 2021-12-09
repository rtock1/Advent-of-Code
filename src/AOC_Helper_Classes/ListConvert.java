package AOC_Helper_Classes;

public class ListConvert {
    public static int[] strtoint(String[] a){
        int[] end = new int[a.length];
        for (int i=0;i<a.length;i++){
            end[i] = Integer.parseInt(a[i]);
        }
        return end;
    }
    public static char[] strtochar(String[] a){
        char[] end = new char[a.length];
        for (int i=0;i<a.length;i++){
            end[i] = a[i].charAt(0);
        }
        return end;
    }
}
