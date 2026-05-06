import java.util.*;

public class p15 {
    static int permutationCount = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();

        char[] str = input.toCharArray();
        Arrays.sort(str); // sorting to get items in order



        String allPermutation = permutationWrapper(str);
        System.out.println(permutationCount);
        System.out.println(allPermutation);

    }
    private static String permutationWrapper(char[] str){
        boolean[] isUsed = new boolean[str.length]; // side array to maintain the usages

        StringBuilder allPermutations = new StringBuilder();
        generatePermutations(new StringBuilder(), allPermutations , isUsed, str);

        return allPermutations.toString();
    }


    /*


    =================================================================================
 *
 * 1. SORT the characters → ensures we explore in alphabetical order
 * 2. Use boolean[] `used` → tracks which characters are in current permutation
 * 3. Build recursively with StringBuilder `current` → append/pick characters
 * 4. SKIP duplicates smartly → prevents generating identical strings
 *
 * =================================================================================
 * THE DUPLICATE SKIP RULE (The "Aha!" Moment)
 * =================================================================================
 *
 * Consider "aab" sorted as [a₀, a₁, b] (indices shown for clarity)
 *
 * WITHOUT the rule, we'd generate duplicates:
 *   • Path A: pick a₀ first → "a₀a₁b" = "aab"
 *   • Path B: pick a₁ first → "a₁a₀b" = "aab"  ← SAME string!
 *
 * WHY? Because a₀ and a₁ are IDENTICAL characters. Swapping them creates
 * the same permutation. We only need ONE of these paths.
 *
 * THE RULE: Skip chars[i] if BOTH conditions are true:
 *   Condition 1: chars[i] == chars[i-1] (current is duplicate of previous)
 *   Condition 2: !used[i-1] (previous duplicate is STILL AVAILABLE)
 *
 * INTUITION: If the "previous twin" (a₀) is still on the table, picking the
 * "current twin" (a₁) would create the exact same permutations as picking a₀.
 * By forcing a₀ to be used BEFORE a₁, each unique pattern is generated exactly once.
 *
 * =================================================================================
 * COMPLETE WALKTHROUGH with "aab"
 * =================================================================================
 *
 * Level 0: current=""          used=[F,F,F]     available: [a₀, a₁, b]
 *   │
 *   ├── Try a₀ → current="a"   used=[T,F,F]     remaining: [a₁, b]
 *   │   │
 *   │   ├── Try a₁ → current="aa"  used=[T,T,F]   remaining: [b]
 *   │   │   │
 *   │   │   └── Try b → current="aab"  used=[T,T,T]  ✓ COMPLETE! Result #1
 *   │   │       ↑ Backtrack: remove b, used=[T,T,F]
 *   │   │
 *   │   └── Try b → current="ab"   used=[T,F,T]   remaining: [a₁]
 *   │       │
 *   │       └── Try a₁ → current="aba"  used=[T,T,T]  ✓ COMPLETE! Result #2
 *   │           ↑ Backtrack: remove a₁, used=[T,F,T]
 *   │       ↑ Backtrack: remove b, used=[T,F,F]
 *   │   ↑ Backtrack: remove a₀, used=[F,F,F]
 *   │
 *   ├── ❌ SKIP a₁!  (a₁==a₀ AND a₀ not used)
 *   │   Why? Using a₁ now would give "a₁..." = "a₀..." which we already did!
 *   │
 *   └── Try b → current="b"    used=[F,F,T]     remaining: [a₀, a₁]
 *       │
 *       ├── Try a₀ → current="ba"  used=[T,F,T]   remaining: [a₁]
 *       │   │
 *       │   └── Try a₁ → current="baa"  used=[T,T,T]  ✓ COMPLETE! Result #3
 *       │       ↑ Backtrack all the way...
 *       │
 *       └── ❌ SKIP a₁!  (a₁==a₀ AND a₀ not used)
 *           Same reason: a₀ is still available, using a₁ would duplicate "ba₀a₁"
 *
 * FINAL RESULTS (3 unique permutations):
 *   ["aab", "aba", "baa"]
 *
 * FORMULA CHECK: 3! / 2! = 6/2 = 3  ✓ Matches!


     */
    private static void generatePermutations(StringBuilder temp, StringBuilder sb, boolean[] isUsed, char[]str){
        if(temp.length() == str.length){
            permutationCount++;
            sb.append(temp).append("\n");
            return;
        }

        // RECURSIVE CASE: try each character at current position
        for(int i = 0; i < str.length; i++){

            // Pruning 1: Skip if character already used in this branch
            if(isUsed[i]){
                continue;
            }

            // Pruning 2: Skip duplicate to avoid identical permutations
            // Rule: if previous char is identical AND not yet used,
            // using current char would create the same string as using previous
            if((i > 0 && str[i-1] == str[i]) && !isUsed[i-1]){
                continue;
            }


            // add chars[i] to current permutation
            temp.append(str[i]);
            isUsed[i] = true;
            // recursive to fill the next position
            generatePermutations(temp, sb, isUsed, str);
            // so now removing the details for the next run(i.e Backtracking)
            temp.deleteCharAt(temp.length()-1);
            isUsed[i] = false;

        }
    }

}
