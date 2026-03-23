import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedTransferQueue;

public class p4 {
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
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            p4.FastReader in=new p4.FastReader();
            p4.FastWriter out = new p4.FastWriter();
            int n = in.nextInt(); // string input
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            // so now we have taken the input let's process it
            long ans = 0;
            for(int i = 1; i < n; i++){
                if(arr[i] < arr[i-1]){
                    // so now it means we have to perform the operation and make it larger than the previous value
                    long diff = (arr[i-1] - arr[i]);
                    ans += diff;
                    arr[i] += diff;
                }
            }
            out.println(ans);

            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

}
