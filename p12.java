import java.util.Scanner;
public class p12 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        // so now we have to find the frequency of all alphabets.
        int[] freq = new int[26];
        char[] str = input.toCharArray();
        for(char ch : str){
            freq[(ch - 'A')]++;
        }

        int singleFreq = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0){
                singleFreq++;
            }
        }
        // so now if the singleFreq is a one, and it's an odd length string, then we can still continue
        if(singleFreq > 1 || (str.length % 2 == 0 && singleFreq > 0)){
            System.out.println("NO SOLUTION");
            return;
        }
        // so now continuing to make the solution.
        char[] ans = new char[str.length];
        int left = 0;
        int right = str.length-1;
        for(int i = 0; i < 26; i++){
            while (freq[i] >= 2){
                ans[left++] = (char)('A' + i);
                ans[right--] = (char)('A' + i);
                freq[i] -= 2;
            }
        }
        // so now for if there is one more left in the case of odd
        for(int i = 0; i < 26; i++){
            if(freq[i] == 1){
                ans[left] = (char)('A' + i);
                freq[i]--;
            }
        }

        String s = new String(ans);
        System.out.println(s);


    }
}
