import java.io.*;
import java.util.StringTokenizer;

public class p3 {
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
            p3.FastReader in=new p3.FastReader();
            p3.FastWriter out = new p3.FastWriter();
            String s = in.next(); // string input
            char[] str = s.toCharArray();
            int max = 1;
            int curr = 1;
            for (int i = 1; i < str.length; i++) {
                if(str[i] == str[i-1]){
                    curr++;
                    max = Math.max(curr , max);
                }else{
                    curr = 1; // reset to the new value
                }
            }
            out.print(max);

            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

}
