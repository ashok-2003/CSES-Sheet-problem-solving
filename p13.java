import java.util.Scanner;

public class p13 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int val = (1 << n) - 1; // 2^n -1
        StringBuilder sb = new StringBuilder();
        for(int i = val; i >= 0; i--){
            int temp = i ^ (i >> 1);
            String str = convertToBinary(temp,n);
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
    private static String convertToBinary(int val, int place){
        // it will give the binary conversion of string to the demanding places
        StringBuilder sb = new StringBuilder();
        for(int i = place-1; i >= 0; i--){
            sb.append((val >> i) & 1); // as this will make sure that 01 should not be written as 1
        }
        return sb.toString();

    }
}
