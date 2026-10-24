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
            long[] arrival = new long[n];
            long[] depart = new long[n];
            for (int i = 0; i < n; i++) {
                arrival[i] = in.nextLong();
                depart[i] = in.nextLong();
            }

            Arrays.sort(arrival);
            Arrays.sort(depart);

            // so now while we iterate over the array then we count the number of person on the room at the same time
            int ans = 0;
            int i = 0;
            int j = 0;
            while (i < n && j < n){
                // so each time we have to found which is big and we have to iterate to the next larger
                if(arrival[i] > depart[j]){
                    j++;
                }else{
                    i++;
                }

                // so now each time we have to get the diff and find out the max diff as this is log book of people
                // coming and leaving

                int diff = Math.abs(i - j);
                ans = Math.max(ans , diff);

            }

            System.out.println(ans);


        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
