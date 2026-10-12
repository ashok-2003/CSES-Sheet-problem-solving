import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p28 {
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


    public static void main(String[] args){
        try{
            FastReader in = new FastReader();
            int n = in.nextInt();
            int m = in.nextInt();
            long[] tickets = new long[n];
            long[] maxPrice = new long[m];

            for (int i = 0; i < n; i++) {
                tickets[i] = in.nextLong();
            }

            Arrays.sort(tickets);
            StringBuilder sb = new StringBuilder();

            int[] taken = new int[n]; // initially all values points to itself only
            for (int i = 0; i < n; i++) {
                taken[i] = i;
            }


            for (int i = 0; i < m; i++) {
                long price = in.nextLong();
                // so now finding the closet ticket for that price
                int index = binarySearch(tickets, price);

                // so now if the index is less than 0 return -1 and skip it

                int val = findFirst(taken, index);
                if(val == -1){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(tickets[val]).append("\n");
                    taken[val] = val-1;
                }
            }

            System.out.println(sb);


        }catch (Exception e){
            System.out.println(e);
            return;
        }
    }

    static int binarySearch(long[] arr , long target){
        // we have to get the celling in the case of same numbers
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end;

    }

    static int findFirst(int[] arr , int index){
        if(index < 0 ) return -1;
        int current = index;
        while (current >= 0 && arr[current] != current){
            current = arr[current]; // so it means that travelling through the values
        }

        int freeSpot = current;

        // so now updating the path for the future calls
        current = index; // so now this time we know the value which is the start in this case
        while (current >= 0 && arr[current] != current){
            int nextOnPath = arr[current];
            arr[current] = freeSpot;
            current = nextOnPath;
        }

        return freeSpot;

    }

    static int recFindFirst(int[] arr, int index){

        // this is faster

        if(index < 0) return -1;
        if(index == arr[index]) return  index;
        arr[index] = findFirst(arr , arr[index]);
        return arr[index];
    }
}
