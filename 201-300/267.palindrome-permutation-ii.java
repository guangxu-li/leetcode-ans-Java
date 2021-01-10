import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=267 lang=java
 *
 * [267] Palindrome Permutation II
 */

// @lc code=start
class Solution {
    private void generate(List<String> palindromes, int[] count, String palindrome, int bound) {
        if (palindrome.length() == bound) {
            palindromes.add(palindrome);
        } else {
            for (int i = 0; i < 256; i++) {
                if (count[i] > 0) {
                    count[i] -= 2;
                    generate(palindromes, count, (char) i + palindrome + (char) i, bound);
                    count[i] += 2;
                }
            }
        }
    }

    public List<String> generatePalindromes(String s) {
        int[] count = new int[256];
        int odds = 0;
        
        for (char c : s.toCharArray()) {
            count[c]++;
            odds += count[c] % 2 == 0 ? -1 : 1;
        }

        if (odds > 1) {
            return new ArrayList<>();
        }

        String center = "";
        for (int i = 0; i < 256; i++) {
            if (count[i] % 2 == 1) {
                center += (char) i;
                count[i]--;

                break;
            }
        }

        List<String> palindromes = new ArrayList<>();
        generate(palindromes, count, center, s.length());

        return palindromes;
    }
}
// @lc code=end

