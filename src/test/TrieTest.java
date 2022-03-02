package test;

import main.data_structure_implementation.Trie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    Trie trie = new Trie();

    @BeforeEach
    void setUp() {
        trie.insert("apple");
    }

    @Test
    public void search() {
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
    }

    @Test
    public void startsWith() {
        assertTrue(trie.startsWith("app"));
    }
}