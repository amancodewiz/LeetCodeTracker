import java.util.*;
/**
class Solution {
    
     //  Returns true if 's' follows the same pattern as 'pattern'.
     // - pattern: a string of chars, e.g. "abba"
     // - s: space-separated words, e.g. "dog cat cat dog"
     // We need a bijection: each pattern char ↔ exactly one word (no two chars map to same word, and vice-versa).
     
    
    public boolean wordPattern(String pattern, String s) {
        // 1) Split the sentence into words (robust to multiple spaces)
        String[] words = s.trim().split("\\s+");

        // 2) If counts differ, pattern cannot match
        if (pattern.length() != words.length) return false;

        // 3) Two-way mapping to enforce bijection
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        // 4) Walk both in lockstep
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String w = words[i];

            // (a) If we already mapped this char, it must map to the same word
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(w)) return false;
            } else {
                charToWord.put(ch, w);
            }

            // (b) If we already mapped this word, it must map to the same char
            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != ch) return false;
            } else {
                wordToChar.put(w, ch);
            }
        }

        // All checks passed: bijection holds
        return true;
    }
} 
 */

//=============================================================================================
//Method 2 (Using Index)
import java.util.*;

class Solution {
    /**
     * Check if the string s follows the same pattern as 'pattern'.
     * Uses two maps that store the last index (+1) where we saw each
     * pattern character and each word. If those indices ever disagree,
     * the mapping is inconsistent.
     */
    public boolean wordPattern(String pattern, String s) {
        String[] tokens = s.trim().split("\\s+");   // split by spaces (handles multiple spaces)

        int n = pattern.length();
        int i = 0;

        // If token count differs from pattern length, it cannot match
        if (tokens.length != n) return false;

        // Maps: char -> last seen index (+1), word -> last seen index (+1)
        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<String, Integer> wordToIndex = new HashMap<>();

        while (i < n) {
            char ch = pattern.charAt(i);
            String word = tokens[i];

            // Previous indices (0 means "never seen before")
            int prevCharIdx  = charToIndex.getOrDefault(ch, 0);
            int prevWordIdx  = wordToIndex.getOrDefault(word, 0);

            // If they differ, then either:
            //  - this char was seen with a different word earlier, or
            //  - this word was seen with a different char earlier.
            if (prevCharIdx != prevWordIdx) return false;

            // Record current position as last seen (store i+1, see explanation below)
            charToIndex.put(ch, i + 1);
            wordToIndex.put(word, i + 1);

            i++;
        }

        return true;
    }
}


