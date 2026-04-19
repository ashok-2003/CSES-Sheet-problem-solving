import java.util.*;
public class p9 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int ans = powTwo(n);
        System.out.println(ans);
    }
    private static int powTwo(int n){
        int modulo = (int)1e9+7;
        // this function return the 2 power n
        int ans = 1;
        for(int i = 0; i < n; i++){
            ans = (ans * 2) % modulo;
        }
        return ans;
    }
}
