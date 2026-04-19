import java.util.*;

public class p8 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close(); // input stream closed not needed any more

        long sum = ((long) n * (n + 1)) / 2L;
        if (sum % 2 != 0) {
            System.out.println("NO");
        }else{
            // so now if the sum is even it mean that we can divide the number into two equal sum set
            equalSet(n,sum);
        }


    }
    private static void equalSet(int n, long sum){
        /**
         * Greedy approach: Pick largest numbers first until next would exceed halfSum.
         * The remaining difference (diff) is always < last, and since we have all
         * numbers 1 to last available, diff can always be found.
         *
         * Proof: After loop, tempSum + last > halfSum, so diff = halfSum - tempSum < last.
         * Since numbers 1..last are all available, diff is always reachable.
         */

        long halfSum = sum / 2;
        List<Integer> ls = new ArrayList<>();
        long tempSum = 0;
        int last = n;
        while (tempSum + last <= halfSum) {
            // adding value in temp in the reverse order till it equals to Half Sum
            tempSum += last;
            ls.add(last);
            last--;
        }
        // it might be possible that value do not reach the first half
        if (tempSum < halfSum) {
            int diff = (int) (halfSum - tempSum);
            ls.add(diff);
        }

        StringBuilder sb = new StringBuilder();
        // so now printing the first half
        sb.append("YES\n");
        sb.append(ls.size()).append("\n");
        for (int i : ls) {
            sb.append(i).append(" ");
        }
        sb.append("\n");

        sb.append(n - ls.size()).append("\n");
        int val = ls.get(ls.size() - 1);
        for (int i = 1; i <= last; i++) {
            if (i == val) continue; // skip the value that we added in the previous list
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
