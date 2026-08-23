import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

public class p20 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        // so now we have to re-construct the matrix so we are using recursion to construct the matrix over here

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        // brute force

//        knightMatrix(0, 0, n, arr, 0);



        // we can use the queue to get to solve this question.. it would be kind of BFS approach.. where we take
        // each index and mark the places

        optimizedKnightMatrix(arr,n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);




    }

    private static void optimizedKnightMatrix(int[][] arr , int n){
        // and now we know the knight can have total of 8 move
        int[][] moves = {
                {2, 1}, {2, -1},
                {-2, 1}, {-2, -1},
                {1, 2}, {1, -2},
                {-1, 2}, {-1, -2}
        };

        Queue<int[]> queue = new LinkedList<>();
        // so now here we will offer the element to the queue

        arr[0][0] = 0;
        queue.offer(new int[]{0,0,0});
        while (!queue.isEmpty()){
            // so now here we have to perform operation like we have to add the values in the queue where values
            // are not equal to zero
            int[] temp = queue.remove();
            int i = temp[0];
            int j = temp[1];
            int val = temp[2];

            // so now adding to the queue for all possible moves..
            for(int[] curr : moves){
                int next_i = curr[0] + i;
                int next_j = curr[1] + j;

                // so now if the next_i and next_j are in bound then we can offer to queue
                if(next_i >= 0 && next_i < n && next_j >= 0 && next_j < n && arr[next_i][next_j] == -1){
                    arr[next_i][next_j] = val+1;
                    queue.offer(new int[]{next_i, next_j ,val+1});
                }
            }
        }


    }

    // brute force
    private static void knightMatrix(int i , int j, int n, int[][] arr , int currTurn){
        // so now dealing with the Edge cases
        if(i >= n || j >= n || i < 0 || j < 0){
            return;
        }
        if (arr[i][j] != -1 && arr[i][j] <= currTurn) {
            return;
        }
        // so now otherwise we have to make the value update and move forward
        arr[i][j] = currTurn;

        // so now we can move to direction
        knightMatrix(i+1, j+2, n, arr , currTurn+1);
        knightMatrix(i+1, j-2, n, arr, currTurn+1);

        knightMatrix(i-1, j+2, n, arr , currTurn+1);
        knightMatrix(i-1, j-2, n, arr, currTurn+1);

        knightMatrix(i+2, j+1, n, arr, currTurn+1);
        knightMatrix(i+2, j-1, n, arr, currTurn+1);


        knightMatrix(i-2, j+1, n, arr, currTurn+1);
        knightMatrix(i-2, j-1, n, arr, currTurn+1);

    }



}
