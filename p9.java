import java.util.*;
public class p9 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        long ans = powTwo(n);
        System.out.println(ans);
    }
    private static long powTwo(int n){
        int modulo = (int)1e9+7;
        // this function return the 2 power n
        long ans = 1;
        long base = 2;

        // this work on the principal like 2^8 can be written as 2^4 * 2^4 then so on
        while(n > 0){
            if(n % 2 == 1){
                ans = (ans * base) % modulo;
            }

            base = (base * base) % modulo;
            n = n/2;
        }

        return ans;
    }
}
