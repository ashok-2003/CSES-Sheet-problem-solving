import java.io.*;
import java.util.StringTokenizer;

public class p1 {
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
            Main.FastReader in=new Main.FastReader();
            Main.FastWriter out = new Main.FastWriter();
            long input =in.nextLong();
            while(input != 1){
                // so now here if it is odd then we have to multiply it by 3 and add one
                // if it is even then divide by two
                out.print(input+ " ");
                if(input % 2L == 0L){
                    input = input / 2L;

                }else{
                    input = (input * 3L)+1L;
                }
            }
            out.println(input);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
