import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class p23 {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        char[] str = s.toCharArray();

        stringReorder(str);


//        Arrays.sort(str);
//        // so now here i will iterate over all index
//
//
//        // finding the max frequency in this case
//        int max = 0;
//        int temp = 0;
//        for(int i = 0; i < str.length; i++){
//            if(i > 0 && str[i-1] == str[i]){
//                temp++;
//                max = Math.max(temp,max);
//            }else{
//                temp = 0;
//            }
//        }
//
//        // so now if max is greater than the length
//        if(max > (str.length+1)/2){
//            System.out.println(-1);
//            return;
//        }
//
//
//        for(int i = 0; i < str.length; i++){
//            StringBuilder ans = new StringBuilder();
//            boolean[] taken = new boolean[str.length];
//            // append first value then continue
//            taken[i] = true;
//            ans.append(str[i]);
//            bruteForce(str, taken, ans);
//            if(found) break;
//        }
//
//        if(!found){
//            System.out.println(-1);
//        }

    }

    private static void stringReorder(char[] str){
        // so now first we have to build the frequency arr
        int[] freq = buildFreq(str);

        StringBuilder ans = new StringBuilder();

        int prev = -1;

        for(int i = 0; i < str.length; i++){

            int choose = findBestChar(prev, freq, str.length - i);

            if(choose == -1){
                System.out.println(-1);
                return;
            }

            ans.append((char)(choose + 'A'));

            prev = choose;
        }

        System.out.println(ans);

    }

    static int findBestChar(int prev , int[] freq, int len){

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == 0) continue;

            if(i == prev) continue;

            // taking this value as temp
            freq[i]--;

            if(isPossible(freq , len-1)){
                return i;
            }

            // otherwise try with another
            freq[i]++;

        }

        return -1;
    }

    private static boolean isPossible(int[] freq , int len){
        // so now taking the max value over here
        int max = -1;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > max){
                max = freq[i];
            }
        }

        // so now it's only possible if
        return (len+1)/2 >= max;
    }
    static int[] buildFreq(char[] str){
        int[] freq = new int[26];
        for (char c : str) {
            freq[c - 'A']++;
        }
        return freq;
    }

    private static void bruteForce(char[] arr, boolean[] taken, StringBuilder ans){
        if(found){
            return;
        }
        if(ans.length() == arr.length){
            found = true;
            System.out.println(ans);
            return;
        }
        // so now here
        for(int i = 0; i < arr.length; i++){
            // so now the case where can't have that value appended when the previous one is appended is same
            if( !taken[i] && arr[i] != ans.charAt(ans.length()-1) ){
                // so we can take this value and move on
                ans.append(arr[i]);
                taken[i] = true;
                bruteForce(arr,taken,ans);
                ans.deleteCharAt(ans.length()-1);
                taken[i] = false;
            }
        }
    }

}
