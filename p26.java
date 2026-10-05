import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p26 {
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
            int m = in.nextInt();
            long k = in.nextLong();


            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            long[] apartment = new long[m];
            for (int i = 0; i < m; i++) {
                apartment[i] = in.nextLong();
            }


            // so now we have n,m and
            Arrays.sort(arr);
            Arrays.sort(apartment);

            // so now we have to find out the apartments that can be taken by them

            int i = 0;
            int j = 0;
            long ans = 0;
            while(i < arr.length && j < apartment.length){
                // so now first taking the element A
                long val = arr[i];
                long valL = arr[i] - k;
                long valR = arr[i] + k;

                // so now we have to compare the value in each case here
                if(apartment[j] >= valL && apartment[j] <= valR){
                    ans++;
                    i++;
                    j++;
                }else if(apartment[j] < valL){
                    j++;
                }else{
                    i++; // as in this case apartment value is actually greater than the current arr
                }
            }

            System.out.println(ans);


        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
