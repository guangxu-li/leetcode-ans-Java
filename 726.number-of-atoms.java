import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 */

// @lc code=start
class Solution {
    private String getAtom(char[] cs, int i) {
        StringBuilder atom = new StringBuilder().append(cs[i++]);
        while (i < cs.length && Character.isLowerCase(cs[i])) {
            atom.append(cs[i++]);
        }

        return atom.toString();
    }

    private String getCnt(char[] cs, int i) {
        StringBuilder cnt = new StringBuilder();
        while (i < cs.length && Character.isDigit(cs[i])) {
            cnt.append(cs[i++]);
        }

        return cnt.toString();
    }

    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> atoms = new ArrayDeque<>();
        atoms.push(new TreeMap<>());

        char[] cs = formula.toCharArray();
        int i = 0;
        while (i < cs.length) {
            if (cs[i] == '(') {
                atoms.push(new TreeMap<>());
                i++;
            } else if (cs[i] == ')') {
                String cntStr = getCnt(cs, i + 1);
                int mul = cntStr.length() == 0 ? 1 : Integer.parseInt(cntStr);

                Map<String, Integer> t = atoms.pop();
                Map<String, Integer> nt = atoms.peek();

                for (Map.Entry<String, Integer> entry : t.entrySet()) {
                    String k = entry.getKey();
                    int v = entry.getValue();

                    nt.put(k, nt.getOrDefault(k, 0) + v * mul);
                }

                i += 1 + cntStr.length();
            } else {
                String atom = getAtom(cs, i);
                String cntStr = getCnt(cs, i + atom.length());
                int cnt = cntStr.length() == 0 ? 1 : Integer.parseInt(cntStr);

                Map<String, Integer> target = atoms.peek();
                target.put(atom, target.getOrDefault(atom, 0) + cnt);

                i += atom.length() + cntStr.length();
            }
        }

        Map<String, Integer> counts = atoms.pop();
        List<String> keys = new ArrayList<>(counts.keySet());

        StringBuilder nf = new StringBuilder();
        for (String key : keys) {
            nf.append(key);
            if (counts.get(key) > 1) {
                nf.append(counts.get(key));
            }
        }

        return nf.toString();
    }
}
// @lc code=end

