import java.util.*;

public class p16 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long val = recursionSolution(arr,0, 0,0);
        System.out.println(val);

    }

    private static long recursionSolution(int[] arr, int index, long sumA, long sumB){
        // so now each time we will give the value either to a or b
        if(index == arr.length){
            // so it means we have reached the limit return the diff in this case
            return Math.abs(sumA - sumB);
        }
        // so now here we have two options
        long addA = recursionSolution(arr, index+1, sumA+arr[index] , sumB);
        long addB = recursionSolution(arr, index+1, sumA, sumB+arr[index]);
        return  Math.min(addA , addB);
    }
}
