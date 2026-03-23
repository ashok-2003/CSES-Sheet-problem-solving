import java.io.*;
import java.util.StringTokenizer;

public class p6 {
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
            p6.FastReader in=new p6.FastReader();
            p6.FastWriter out = new p6.FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                long n = in.nextLong();
                long m = in.nextLong();
                // so now if you see this in the row we have square like for 2nd row we got 4 then next row start with 5
                // similarly in 4 is even row then it is 16 and 5 is odd row so it become 4row square + 1
                // similar patter in the col but in opposite direction
                long ans = getAns(n , m);

                out.println(ans);
            }

            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }


    }
     static  long getAns(long n , long m){
         if(n > m){
             // so it means that row number is major here so passing it to the row here
             return  RowDominated(n , m);
         }else{
             return ColumnDominated(m , n);
         }
     }
     static long ColumnDominated(long number , long position){
        // so now this is column dominated so we have to treat the col here
        long odd = number % 2 != 0 ? number : number-1;
        long sqr = (odd * odd); // got the square so now we have to induce the number
        // if the number was odd then we have to decrease the count only otherwise add it
        if(number % 2 != 0){
            // so it is odd
            return sqr - (position-1);
        }else{
            // so the number is even
            return sqr + position;
        }

    }
    static long RowDominated(long number , long position){
        // so now this is Row dominated so we have to treat the row here
        long even = number % 2 == 0 ? number : number-1;
        long sqr = (even * even); // got the square so now we have to induce the number
        // if the number was even then we have to decrease the count only otherwise add it
        if(number % 2 == 0){
            // so it is even
            return sqr - (position-1);
        }else{
            // so the number is odd
            return sqr + position;
        }

    }


}