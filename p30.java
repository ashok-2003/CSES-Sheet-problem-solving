import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p30 {
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
            long[][] arr = new long[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextLong();
                arr[i][1] = in.nextLong();
            }

            Arrays.sort(arr, (a,b) -> Long.compare(a[1], b[1]));

            // so now what we have to is that find the most number of movies that we can see
            int ans = 1;
            long val = arr[0][1];
            for (int i = 0; i < n; i++) {
                if(arr[i][0] >= val){
                    ans++;
                    val = arr[i][1];
                }
            }

            System.out.println(ans);

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
