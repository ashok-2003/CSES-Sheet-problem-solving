import java.util.*;

public class p8 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // number input taken
        in.close(); // input stream closed not needed any more

        long sum = ((long) n * (n + 1)) / 2L;
        if (sum % 2 != 0 || n < 3) {
            System.out.println("NO");
            return; // early return
        }

        // so now if the sum is even it mean that we can divide the number into two equal sum set \
        long half = sum / 2;
        List<Integer> ls = new ArrayList<>();
        long temp = 0;
        int last = n;
        while (temp + last <= half) {
            // adding value in temp in the reverse order
            temp += last;
            ls.add(last);
            last--;
        }
        // so now in this loop it will iterate the value of till the half
        // it might be possible that value do not reach the first half
        if (temp < half) {
            int val = (int) (half - temp);
            ls.add(val);
        }

        StringBuilder sb = new StringBuilder();
        // so now printing the first half
        sb.append("YES\n");
        sb.append(ls.size()).append("\n"); // printed the first half size
        for (int i : ls) {
            sb.append(i + " ");
        }
        sb.append("\n");

        sb.append(n - ls.size()).append("\n");
        int val = ls.get(ls.size() - 1);
        for (int i = 1; i <= last; i++) {
            if (i == val) continue; // skip the value that we added in the previous list
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
