import java.util.Scanner;

public class p18 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();
        while(testcase-- > 0){
            int total = in.nextInt();
            int firstWin = in.nextInt();
            int secondWin = in.nextInt();
            raab(total, firstWin, secondWin);
        }
        in.close(); // to avoid memory leak
    }
    private static void raab(int total , int firstWin, int secondWin){
        // let's handle the edge cases first
        if(firstWin+secondWin > total){
            System.out.println("NO");
            return;
        }
        // if any one of become zero while other is not then it's not possilbe
        if((firstWin == 0 && secondWin != 0) || (firstWin != 0 && secondWin == 0)){
            System.out.println("NO");
            return;
        }
        // --
        // so now it can be possible by first taking all the draw matches then rotating one array to make it win
        // for eg  6 2 3
        // 1 2 3 4 5 6
        // 1 5 6 1 2 3
        // so in this case as 6 - 5 = 1 draw so we will have to rotate from index 1 for 2 times

        int draw = total-(firstWin+secondWin);
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = i+1;
        }
        // so now rotating the array as the start index will be draw and we can make the first win as number of time
        // making the draw
        Rotate(arr , draw , total-1, firstWin);

        // so now here for answer
        System.out.println("YES");
        for (int i = 0; i < total; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
        for (int i = 0; i < total; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


    }
    static void Rotate(int[] arr , int startIndex , int endIndex, int times){
        // so for the inplace array rotation we will use the reversal algorithm here
//        // first reverse the required size of array here
//        Reverse(arr , startIndex , endIndex);
        // so now reversing again the starting first required time then the remaining
        Reverse(arr , startIndex , startIndex+times-1);
        Reverse(arr , startIndex+times, endIndex);

        // reversing the array as the order priority of who win first matters
        Reverse(arr, startIndex , endIndex);
    }
    static void Reverse(int[] arr , int start , int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
