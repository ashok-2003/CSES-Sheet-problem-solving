import java.io.*;
import java.util.StringTokenizer;

public class p5 {
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
            p5.FastReader in=new p5.FastReader();
            p5.FastWriter out = new p5.FastWriter();
            int n = in.nextInt();
            // so now we can always print first the odd number then the even number as solution or vice-versa
            // but the n should be greater than 3 for that case
            if(n > 1 && n <= 3){
                out.print("NO SOLUTION");
                out.close(); // explicitly close the buffer writer otherwise value will not print as it store them
                // in memory and only print when the buffer writer overflow or close explicitly
                return;
            }

            // so now in the other case we have solution
            // print the odd first in the reverse order
            // so make the n1 as odd and n2 as even number
            int n1 = n%2 == 0 ? n-1 : n; // odd number
            int n2 = n%2 == 0 ? n : n-1; // even number
//            out.print(n1 + " " + n2);

            for(int i = n1; i > 0; i -= 2){
                out.print(i+ " ");
            }
            for(int i = n2; i > 0; i -= 2){
                out.print(i+ " ");
            }

            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

}