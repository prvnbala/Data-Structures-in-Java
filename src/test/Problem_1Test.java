package test;

import org.junit.Test;

import main.problem_set.String.Problem_1;

import static org.junit.jupiter.api.Assertions.*;

public class Problem_1Test {

    Problem_1 p1 = new Problem_1();

    @Test
    public void prefixCount() {
        String[] words;
        String prefix;

        words = new String[]{"apple", "app", "ap", "ball", "", "cap"};
        prefix = "app";
        assertEquals(2, p1.prefixCount(words, prefix));

        words = new String[]{"apple", "app", "ap", "ball", "", "cap"};
        prefix = "ap";
        assertEquals(3, p1.prefixCount(words, prefix));
    }



}

