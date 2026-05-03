import java.io.*;
import java.util.StringTokenizer;

public class p11 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args){
        try {
            p11.FastReader in = new p11.FastReader();
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder(1000000);
            while (n-- > 0) {
                long a = in.nextLong();
                long b = in.nextLong();
//            System.out.println(isPossible(a, b));  // Brute force solution

                // so in each step we remove exactly 3 coins.
                // so bare minimum if it's a solution, then it should be
                // divided by 3, but now there can be a case where a = 9 and b = 0.
                // so that's why one pile cannot be much larger than others.
                // so the max solution is when we are removing 2 from one pile and 1 from another pile like 6, 3.
                // so a should not be greater than 2 * b

                if ((a + b) % 3 == 0 && (Math.max(a, b) <= 2 * Math.min(a, b))) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
            System.out.print(sb);


        }catch (Exception e) {
            System.out.println(e);
            return;
        }
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


