import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p27 {

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
        try{

            FastReader in = new FastReader();
            int n = in.nextInt();
            long x = in.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }


            // as each gondolas can carry at-most 2 children so always try to fit the small and big children together

            Arrays.sort(arr);
            int i = 0;
            int j = n-1;
            long ans = 0;

            while (i <= j){
                long leftC = arr[i];
                long rightC = arr[j];
                if(leftC+rightC <= x){
                    i++;
                    j--;
                    ans++;
                }else{
                    // the last have to go alone as no other children will be able  to fit it with it.
                    j--;
                    ans++;
                }
            }

            System.out.println(ans);

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
