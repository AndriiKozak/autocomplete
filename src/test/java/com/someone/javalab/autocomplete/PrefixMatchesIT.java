/*
 *  This task is done to study purposes. Rights somehow distributed between lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

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
public class PrefixMatchesIT {
    PrefixMatches PM33;
    public PrefixMatchesIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PM33 = PMFactory.load();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class PrefixMatches.
     */
    @Test
    public void testAdd() {
    assertEquals(PM33.add("the"), 0);
    assertEquals(PM33.add("nochancethrerissuchword"), 1);
    }

    /**
     * Test of size method, of class PrefixMatches.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        assertEquals(PMFactory.getTotal(), PM33.size());
        
    }

    /**
     * Test of delete method, of class PrefixMatches.
     */
    @Test
    public void testDelete() {
        assertEquals(true, PM33.delete("table"));
        assertEquals(PM33.delete("nochancethrerissuchword"), false);
    }

    /**
     * Test of contains method, of class PrefixMatches.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        assertEquals(PM33.contains("nochancethrerissuchword"), false);
        assertEquals(PM33.contains("attention"), true);
    }

    /**
     * Test of wordsWithPrefix method, of class PrefixMatches.
     */
    @Test
    public void testWordsWithPrefix_String_int() {
        System.out.println("wordsWithPrefix");
        String pref = "tes";
        int k = 3;
        PrefixMatches instance = PM33;
        int expResult = 6;
        int count=0;
        Iterable<String> result = instance.wordsWithPrefix(pref, k);
        for (String word:result) count++; 
        assertEquals(expResult, count);
       
    }

    /**
     * Test of wordsWithPrefix method, of class PrefixMatches.
     */
    
    
}
