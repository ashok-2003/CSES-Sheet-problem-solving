import java.util.Scanner;

public class p24{
    public static void main(String[] args){
        int n = 9; // taking grid with the border around to avoid out of bound
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        char[] str = s.toCharArray();
        boolean[][] isVisited = new boolean[n][n];
        // making border to true
        for(int i = 0; i < n; i++){
            isVisited[0][i] = true;
            isVisited[i][0] = true;
            isVisited[n-1][i] = true;
            isVisited[i][n-1] = true;
        }

        // so now we have to find all the ways for it

        int ans = findPath(isVisited, str, 1 , 1 , 0);
        System.out.println(ans);
    }

    static final char[] dir = {'D','U','L','R'};
    static final int[] dirR = {1,-1,0,0};
    static final int[] dirC = {0, 0, -1, 1};


    public static int findPath(boolean[][] isVisited, char[] str, int r, int c, int step){
        // so now first the case to return 0 when the way is already visited..
        if(isVisited[r][c]){
            return 0;
        }
        // so now for the case where we can move top and bottom but not left and right
        if(  open(r-1,c , isVisited) && open(r+1, c , isVisited)  && !open(r, c+1, isVisited) && !open(r,c-1, isVisited) ) {
            return 0; // as we can go left and right but not up and down so it means that we have divided into two halfs.
        }
        if(open(r, c+1 , isVisited) && open(r, c-1, isVisited) && !open(r+1, c , isVisited) && !open(r-1, c , isVisited) ){
            return 0;
        }

        if(r == 7 && c == 1){
            // so now if the step is not 48 so we have to return 0
            if(step == 48){
                return 1;
            }else{
                return 0;
            }
        }

        char currVal = str[step];
        isVisited[r][c] = true;
        int ans = 0;
        for(int i = 0; i < 4; i++){
            if(currVal != '?' && dir[i] != currVal) continue;
            // so now otherwise

            int nr = r + dirR[i];
            int nc = c + dirC[i];
            if(!open(nr, nc, isVisited)) continue;


            ans += findPath(isVisited, str, nr , nc, step+1);

        }
        isVisited[r][c] = false;

        return ans;
    }

    static boolean open(int r, int c, boolean[][] visited){
        return !visited[r][c];
    }

    static int openNeighborCount(int r, int c, boolean[][] visited){
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            if(open(r + dirR[i], c + dirC[i], visited)) cnt++;
        }
        return cnt;
    }
}