/*
 *  This task is done to study purposes. Rights somehow distributed between lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Andrii_Kozak1
 */
public class RWayTrieTest {

    RWayTrie testTrie;

    public RWayTrieTest() {
       

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
         testTrie = new RWayTrie();

        testTrie.add(new Tuple("abc", 3));
        testTrie.add(new Tuple("abcd", 4));
        testTrie.add(new Tuple("abce", 4));
        testTrie.add(new Tuple("abcde", 5));
        testTrie.add(new Tuple("abcdef", 6));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class RWayTrie.
     */
    @Test
    public void testAddTupleMock() {
        System.out.println("addTupleMock");
        Tuple mockTuple = mock(Tuple.class);
        when(mockTuple.getWord()).thenReturn("element");
        RWayTrie instance = new RWayTrie();
        boolean expResult = true;
        boolean result = instance.add(mockTuple);
        assertEquals(expResult, result);
        verify(mockTuple, times(2)).getWord();
        verify(mockTuple).getWeight();

    }
    public void testAddTrue() {
        boolean result=testTrie.add(new Tuple("ab",2));
        assertEquals(result,true);
    }
    public void testAddFalse() {
        boolean result=testTrie.add(new Tuple("abc",3));
        assertEquals(result,false);
    }
    /**
     * Test of contains method, of class RWayTrie.
     */
    @Test
    public void testContainsTrue() {
        System.out.println("contains");
        String word = "cba";
        RWayTrie instance = testTrie;
        boolean expResult = false;
        boolean result = instance.contains(word);
        assertEquals(expResult, result);
        assertEquals(true, instance.contains("abc"));
        assertEquals(true, instance.contains("abcd"));
        assertEquals(true, instance.contains("abce"));
        assertEquals(true, instance.contains("abcde"));
        assertEquals(true, instance.contains("abcdef"));
    }
    public void testContainsFalse(){
        assertEquals(false,testTrie.contains("Random Word"));
    }
    @Test
    public void testDelete() {
        System.out.println("delete");
        String word = "woodspeaker";
        RWayTrie instance = testTrie;
        boolean expResult = false;
        boolean result = instance.delete(word);
        assertEquals(expResult, result);
        assertEquals(true, instance.delete("abc"));
        testTrie.add(new Tuple("abc", 3));
    }

    /**
     * Test of size method, of class RWayTrie.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        RWayTrie instance = testTrie;
        int expResult = 5;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of words method, of class RWayTrie.
     */
    @Test
    public void testWords() {
        System.out.println("words");
        RWayTrie instance = testTrie;
        List expResult = new LinkedList();
        expResult.add("abc");
        expResult.add("abcd");
        expResult.add("abce");
        expResult.add("abcde");
        expResult.add("abcdef");

        Iterable<String> result = instance.words();
        for (String word : result) {
            assertEquals(word, expResult.remove(0));
        }

    }

    /**
     * Test of wordsWithPrefix method, of class RWayTrie.
     */
    @Test
    public void testWordsWithPrefix() {
        System.out.println("wordsWithPrefix");
        String pref = "abcd";

        RWayTrie instance = new RWayTrie();
        List expResult = new LinkedList();
        expResult.add("abcd");
        expResult.add("abcde");
        expResult.add("abcdef");

        Iterable<String> result = instance.wordsWithPrefix(pref);
        for (String word : result) {
            assertEquals(word, expResult.remove(0));
        }
    }

}
