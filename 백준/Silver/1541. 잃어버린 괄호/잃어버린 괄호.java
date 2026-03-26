import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("-");
        
        int plus = 0;
        String[] plusArr = strArr[0].split("\\+");
        for (int i = 0; i < plusArr.length; i++) {
            plus += Integer.parseInt(plusArr[i]);
        }
        
        int minus = 0;
        for (int i = 1; i < strArr.length; i++) {
            String[] minusArr = strArr[i].split("\\+");
            for (int j = 0; j < minusArr.length; j++) {
                minus += Integer.parseInt(minusArr[j]);
            }
        }
        
        System.out.println(plus - minus);
    }
}