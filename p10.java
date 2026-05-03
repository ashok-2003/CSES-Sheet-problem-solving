import java.util.*;
public class p10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // so now finding the factorial of this number

        /*
        this solution will not actually work as the long have limit of

        9.2 quintillion (9,223,372,036,854,775,807) this is how much long can store

        20! ≈ 2.4 quintillion
        21! ≈ 51 quintillion

        long fact = factorial(n);
        System.out.println(trailingZero(fact));

        so yeh their is trick into this question

         */


        // so for every trailing zero, there are various rules.
        // 1. it should be a minimum of 5 * 2. and for checking it, we can only check the multiple of 5 as there will be at
        //  least the same number of multiple of 2.
        // so now it works till 24, but in the case of 25 instead of multiplying with 2, we can multiply by 4 to get 2 zeros
        // as 25 * 4 = 100.  similarly, we can get 125 * 8 = 1000, so we get the three trailing zeros.
        // so based on this concept, multiply 5 in 5 each time, and we get the extra zeros
        // as in case of 25: 25/5 + 25/25 = 6 zeros

        long ans = 0;
        long rem = 5;
        while(n / rem != 0){
            ans += (n/rem);
            rem = rem * 5;
        }

        System.out.println(ans);

    }
    private static long factorial(int n){
        long ans = 1;
        for(int i = 1; i <= n; i++){
            ans = ans * i;
        }
        return ans;
    }
    private static int trailingZero(long n){
        int maxTrail = 0;
        int tempTrail = 0;
        while(n > 0){
            if(n % 10 == 0){
                tempTrail++;
                maxTrail = Math.max(maxTrail,tempTrail);
                n = n/10;
            }else{
                tempTrail = 0;
                n = n/10;
            }
        }
        return maxTrail;
    }
}
