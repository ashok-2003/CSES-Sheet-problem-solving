import java.util.Scanner;

public class p21 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = in.next();
        }
        in.close();

        // so for this problem we can always approach left to right and top to bottom
        // so we have to check for the left one always and with that we have to check for the above one


        // so now let's convert that into the integer array
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = str[i].charAt(j)-'A';
            }
        }
        // so now this problem can be simplified as mex number

        GridColor(n , m , arr);

    }

    private static void GridColor(int n , int m , int[][] arr){
        // so now we have got the values so we have to just iterate to find the next value which
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr_val = arr[i][j];
                int top_val = -1;
                if(i > 0){
                    top_val = arr[i-1][j];
                }
                int left_val = -1;
                if(j > 0){
                    left_val = arr[i][j-1];
                }


                // so now we have to replace with least minimum value at this position
                int next_val = next_positive(curr_val,top_val,left_val);
                arr[i][j] = next_val;
            }
        }

        // so now our Array is filled up so now printing the value
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = (char)('A' + arr[i][j]);
                sb.append(ch);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static int next_positive(int a , int b , int c){
        // so we have to tell the next positive integer over here
        if(a != 0 && b != 0 && c != 0){
            return 0;
        }else if( a != 1 && b != 1 && c != 1){
            return 1;
        }else if( a != 2 && b != 2 && c != 2){
            return 2;
        }else{
            return 3;
        }
    }
}
