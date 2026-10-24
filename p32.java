import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p32 {
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


    public static void main(String[] args) {
        try{
            FastReader in = new FastReader();
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            // so now we have done this

            long maxSum = arr[0];
            long currSum = arr[0];
            for (int i = 1; i < n; i++) {
                // so now we will check if the adding that value makes it less than 0 so no need to add that..
                currSum = Math.max(currSum+ arr[i], arr[i]);
                maxSum = Math.max(maxSum, currSum);
            }

            System.out.println(maxSum);

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
