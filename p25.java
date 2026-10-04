import java.io.*;
import java.util.*;

public class p25 {
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
            p25.FastReader in=new p25.FastReader();
            p25.FastWriter out = new p25.FastWriter();
            int input =in.nextInt();
            long[] arr = new long[input];
            for (int i = 0; i < input; i++) {
                arr[i] = in.nextLong();
            }


            int count = 1;
            Arrays.sort(arr);
            for (int i = 1; i < input; i++) {
                if(arr[i-1] != arr[i]){
                    count++;
                }
            }

            out.println(count);


            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
