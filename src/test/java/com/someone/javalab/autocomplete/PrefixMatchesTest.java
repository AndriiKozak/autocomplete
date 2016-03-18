/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Andrii_Kozak1
 */
public class PrefixMatchesTest {
    PrefixMatches PMT;
    
    public PrefixMatchesTest() {
        PMT=new PrefixMatches();
        PMT.add("abc abcd abce abcde abcdef");
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class PrefixMatches.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String strings = "abc abcd abce abcde abcdef";
        PrefixMatches instance = new PrefixMatches();
        int expResult = 5;
        int result = instance.add(strings);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class PrefixMatches.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PrefixMatches instance = PMT;
        int expResult = 5;
        int result = PMT.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class PrefixMatches.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String word = "abc";
        PrefixMatches instance = PMT;
        boolean expResult = true;
        boolean result = instance.delete(word);
        assertEquals(expResult, result);

    }

    /**
     * Test of contains method, of class PrefixMatches.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String word = "abc";
        PrefixMatches instance = PMT;
        boolean expResult = true;
        boolean result = instance.contains(word);
        assertEquals(expResult, result);
    }

    /**
     * Test of wordsWithPrefix method, of class PrefixMatches.
     */
    @Test
    public void testWordsWithPrefix() {
        System.out.println("wordsWithPrefix");
        String pref = "abc";
        int k = 2;
        PrefixMatches instance = PMT;
        List expResult = new LinkedList();
        expResult.add("abc");
        expResult.add("abcd");
        expResult.add("abce");

        
        Iterable<String> result = instance.wordsWithPrefix(pref,k);
        for(String word:result){
            assertEquals(word,expResult.remove(0));
        }
    }
    
}
