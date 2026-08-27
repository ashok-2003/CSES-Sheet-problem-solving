import java.util.Scanner;

public class p22 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long val = in.nextLong();
            long sol = optimizedFindNum(val);
            sb.append(sol).append("\n");
        }
        in.close();
        System.out.println(sb);


    }
    private static long findNum (long pos){
        // so now in the case where the number is less than <= 9

        // case 1 if the number is less than 9 then direct answer
        // case 2 if the number is between 10 and 99 we have 90 number so it become 90*2 = 180 + 9 = 189
        // case 3 when the number is between the 100 to 999 so it become 900*3 = 2700 => 2700+189 = 2889
        // case 4 when number is between the 1000 to 9999 so it become 9000*4= 36000+.

        long count = 9;
        long digit = 1;
        while(pos > count * digit){
            pos = pos - (count * digit);
            count *= 10;
            digit++;
        }
        // so now we have subtracted the required value

        long indexNumber = (pos-1)/digit;
        // so now in this we have to add the number digit in it
        long start = 1;
        for (int i = 1; i < digit; i++) {
            start *= 10;
        }

        indexNumber += start;
        long digitIndex = (pos-1) % digit;

        // so now for the indexNumber that we have to get the digit index
        // and we already know the which number digit is it so let's do that
        long loop = digit - digitIndex-1; // as we are getting the remainder in the last
        while (loop > 0){
            indexNumber = indexNumber/10;
            loop--;
        }
        return indexNumber%10;


    }
    private static long optimizedFindNum(long pos){
        // so now we have to find out what's the number is and which index we need
        long start = 1;
        long digit = 1;
        long count = 9;
        while (pos > (count * digit)){
            pos = pos - (count * digit);
            count *= 10;
            start *= 10;
            digit++;
        }
        // so now to find the digit
        long number = start + ( (pos-1) / digit );
        long digitIndex = (pos-1)%digit;

        long loop = digit - digitIndex - 1;
        while (loop-- > 0){
            number = number / 10;
        }
        return number%10;
    }
}
