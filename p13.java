import java.util.Scanner;

public class p13 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int val = (1 << n) - 1; // 2^n -1
        StringBuilder sb = new StringBuilder();
        for(int i = val; i >= 0; i--){
            int temp = i ^ (i >> 1);
            String str = convertToBinary(temp,n);
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
    private static String convertToBinary(int val, int place){
        // it will give the binary conversion of string to the demanding places
        StringBuilder ans = new StringBuilder();
        while(val > 0){
            ans.insert(0,val & 1);
            val = val >> 1;
        }
        // so now based on the current length, we have to add that many zeros in the starting
        int currLen = ans.length();
        if(place - currLen > 0){
            for(int i = place-currLen; i > 0; i--){
                ans.insert(0,"0");
            }
        }

        return ans.toString();

    }
}
