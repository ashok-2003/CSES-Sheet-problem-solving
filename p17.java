import java.util.*;
public class p17 {
    public static void main(String[] args){
        int n = 8;
        Scanner in = new Scanner(System.in);
        boolean[][] isReserved = new boolean[n][n];
        for(int i = 0; i < 8; i++){
            String s = in.next();
            char[] str = s.toCharArray();
            for(int j = 0; j < str.length; j++){
                if(str[j] == '*'){
                    isReserved[i][j] = true;
                }
            }
        }

        int ans = waysToPlaceQueen(n, 0, isReserved, new boolean[n][n]);
        System.out.println(ans);

    }
    private static int waysToPlaceQueen(int n,int i, boolean[][] isReserved , boolean[][] position){
        if(i == n){
            return 1;
        }
        // so now here for that
        int ans = 0;
        for(int x = 0; x < n; x++){
            // try placing the queen at this place
            if(!isReserved[i][x] && isValidMoveOptimized(position, i , x , n)){
                // so now marking this as used.
                position[i][x] = true;
                ans += waysToPlaceQueen(n,i+1, isReserved, position);
                // backtracking the changed value
                position[i][x] = false;
            }
        }
        return  ans;
    }
    private static boolean isValidMove(boolean[][] position , int i , int j, int n){
        // n represent the matrix size, and i and j are row and column.

        // we don't need to check left and right as we are increasing the row each time.
        // so we need to check the vertical of it.
        for(int k = 0; k < n; k++){
            if(position[k][j]){
                return  false;
            }
        }
        // checking all diagonals
        for(int k = 0; k < n; k++){
            if(i+k < n && j+k < n && position[i+k][j+k]) return false;
            if(i-k >= 0 && j+k < n && position[i-k][j+k]) return false;
            if(i+k < n && j-k >= 0 && position[i+k][j-k]) return false;
            if(i-k >= 0 && j-k >= 0 && position[i-k][j-k]) return false;
        }

        return true;
    }
    private static boolean isValidMoveOptimized(boolean[][] position, int i, int j, int n){
        // so now we just need to check the upper part only as we are filling up top to bottom, so
        // we don't need to even check the lower part,
        // and similarly we don't even need to check the lower diagonals

        for(int k = 0; k < i; k++){
            if(position[k][j]) return false;
        }
        for(int k = 1; k <= i; k++){
            if(j+k < n && position[i-k][j+k]) return false;
            if(j-k >= 0 && position[i-k][j-k]) return false;
        }

        return true;
    }


}