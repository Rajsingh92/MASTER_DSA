/**
Find All Anagrams in a String |  Medium | Amazon, Facebook, Google |

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
 */

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<Integer>();
        if (s == null || p == null || s.length() < p.length())
            return indices;
        int sLength = s.length();
        int pLength = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (isAnagrams(sCount, pCount))
            indices.add(0);
        for (int i = pLength; i < sLength; i++) {
            char prevC = s.charAt(i - pLength), curC = s.charAt(i);
            sCount[prevC - 'a']--;
            sCount[curC - 'a']++;
            if (isAnagrams(sCount, pCount))
                indices.add(i - pLength + 1);
        }
        return indices;
    }

    public boolean isAnagrams(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i])
                return false;
        }
        return true;
    }
}
