import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p31 {
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
           long target = in.nextLong();

           long[][] arr = new long[n][2];

            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextLong();
                arr[i][1] = i;
            }

            Arrays.sort(arr , (a,b) -> Long.compare(a[0], b[0]));

            // so now we can count it from starting and ending
            int left = 0;
            int right  = n-1;
            while(left < right){
                long sum = arr[left][0] + arr[right][0];
                if(sum == target){
                    System.out.println((arr[left][1]+1) + " " + (arr[right][1]+1)); // for index 1 convention
                    return;
                }else if(sum < target){
                    // as target is bigger so we have to increase the sum
                    left++;
                }else{
                    right--;
                }
            }

            System.out.println("IMPOSSIBLE");


        }catch (Exception e){
            System.out.println(e);
            return;
        }
    }
}
