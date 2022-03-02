package StringUtil;

import java.util.Arrays;

public class StringUtil {
    public static String reverse(String word) {
        char[] letters = word.toCharArray();
        int l = 0, r = letters.length - 1;
        while(l < r) {
            char temp = letters[l];
            letters[l] = letters[r];
            letters[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(letters);
    }
}
