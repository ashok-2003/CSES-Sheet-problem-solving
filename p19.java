import java.util.Scanner;

public class p19 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close(); // closing the input
        // so now we will start with 0 1 2 3 ... for both row and columns.
        // as if you notice a pattern then at each of the index if we have the 1st row and column
        // then if both are odd index or even then we add both numbers ... and if it's opposite then we subtract them

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[0][i] = i;
        }
        // so now initial array is filled up so now filling the remaining array
        // as you can see that array in second half got flipped so that's the strong sing of xor pattern
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = (i ^ j);
            }
        }

        // printing the value
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
