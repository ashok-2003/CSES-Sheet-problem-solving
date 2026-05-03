import java.util.Scanner;

public class p11 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-- > 0){
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(isPossible(a, b));
        }

        in.close(); // closing the input to avoid the leak;
    }
    private static String isPossible(long a , long b) {
        boolean ans = solution(a,b);
        if(ans){
            return "YES";
        }else{
            return "NO";
        }
    }
    private static boolean solution(long a , long b){
        // so now this returns whether making the solution is possible or not using the brute force
        if(a == 0 && b == 0){
            return true;
        }
        if(a < 0 || b < 0){
            return false;
        }

        // so now doing the normal calculation here at each step, we can have two moves each time.
        boolean left = solution(a-2, b-1);
        boolean right = solution(a-1,b-2);
        return left || right;
    }
}


