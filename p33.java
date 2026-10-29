import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p33 {
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
           for(int i = 0; i < n; i++){
               arr[i] = in.nextLong();
           }

           // so now we have done that so we need to sort the Array then take the median and then adjust the value
            // according to that

            Arrays.sort(arr);

           int mid = n/2;

           // so now adding the value accordingly to make it equal

            long req = 0;
            for (int i = 0; i < n; i++) {
                req += Math.abs(arr[mid] - arr[i]);
            }

            System.out.println(req);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
