package AOC_2015.day4;

import AOC_Helper_Classes.*;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part2 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String data = ReadInput.getString("AOC_2015.day4");
        System.out.println(data);
        MessageDigest md = MessageDigest.getInstance("MD5");
        for (int i=0;i<10000000;i++) {
            md.update((data + i).getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            if(myHash.substring(0,6).equals("000000")){
                System.out.println(i);
                break;
            }
        }
    }
}
