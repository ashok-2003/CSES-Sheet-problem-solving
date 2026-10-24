import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p29 {
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
        try {
            FastReader in = new FastReader();
            int n = in.nextInt();
            long[][] arr = new long[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextLong();
                arr[i][1] = in.nextLong();
            }

            // so now we have imported the full array so we have to sort it
            Arrays.sort(arr, (a,b)-> Long.compare(a[1], b[1]) );

            // so now while we iterate over the array then we count the number of person on the room at the same time
            int ans = 0;

            for(int i = 0; i < n; i++){
                int temp = 0;
                // so we will start with the time of the lowest first and find out which all are in that time
                for(int j = i; j < n; j++){
                    if(arr[j][0] <= arr[i][1]){
                        temp++;
                    }
                }

                ans = Math.max(ans , temp);
            }


            System.out.println(ans);


        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
