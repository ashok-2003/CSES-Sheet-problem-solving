import java.io.*;
import java.util.StringTokenizer;

public class p7 {
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
            p7.FastReader in=new p7.FastReader();
            p7.FastWriter out = new p7.FastWriter();
            int val = in.nextInt();
            // so now the answer can be induced via this principle
            // https://susam.net/mutually-attacking-knights.html
            // so we can find the number on way two knight can sit on  (N * N) chess board
            // then we can subtract the number of ways know that two knights can attack each other

            // so least requirement of two knight to attack each other is 2 * 3 chess board at their can be two ways.
            // so now number of (2*3) rect.. in (N*N) is and we will also get same number of (3 * 3) matrix also.

            // so total number of data is 2*2(n-1)(n-2)


            for(int i = 1; i <= val; i++){
                long total = (( (long)i*i ) * ( (long)i*i-1) )/2L;
                long attack = 4*(long)(i-1)*(i-2);

                out.println(total- attack);
            }

            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}