import java.util.Scanner;

public class p14 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // so now the main intuition is to move the n-1 from A to B with the help of c
        // then move the nth disk from a to c
        // then shift the n-1 disk from B to C using A
        StringBuilder sb = new StringBuilder();
        sb.append((1<<n)-1).append("\n"); // appending the number of moves (2^n-1)
        towerOfHanoi(n, 1 , 3 , 2, sb);
        System.out.println(sb);


    }

    /*
    N - represent the number of disks.
    From representing that from which tower, do we have to move the disk (also called as source)
    To: represent that where do we have to move (also called as destination)
    Aux: represent the auxiliary tower (also called the helper tower)


    Move 1-2 from A → B (solving 2-disk subproblem)
    Move disk 3 from A → C (the "pivot" move)
    Move 1-2 from B → C (solving 2-disk subproblem again)

     */
    private static void towerOfHanoi(int n, int A, int C, int B, StringBuilder sb){
        if(n == 0){
            return;
        }
        // so now first of all, move the disk from A to B using c
        towerOfHanoi(n-1, A, B, C, sb);
        // so now moving the nth Disk from A to C using the B
        sb.append(A).append(" ").append(C).append("\n");
        // so now shifting the other to the same
        // shifting B To C using A
        towerOfHanoi(n-1, B, C, A, sb);
    }
}
