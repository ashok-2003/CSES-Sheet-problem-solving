import java.io.*;
import java.util.StringTokenizer;

public class p2 {
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
            p2.FastReader in=new p2.FastReader();
            p2.FastWriter out = new p2.FastWriter();
            int n=in.nextInt();
            // so now here we have to add to the sum of number
            long currSum = 0;
            for (int i = 0; i < n - 1; i++) {
                int val = in.nextInt();
                currSum += val;
            }
            // getting the required sum
            long requiredSum = ((long)n * (n+1))/2;
            long requiredVal = (requiredSum - currSum);
            out.print(requiredVal);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

}