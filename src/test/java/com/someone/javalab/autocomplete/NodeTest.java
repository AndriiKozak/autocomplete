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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Andrii_Kozak1
 */
public class NodeTest {
    Node testNode;
    Node zNode;
    public NodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
     
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testNode=new Node();
        zNode=new Node();
        testNode.childs[Node.R-1]=zNode;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of child method, of class Node.
     */
    @Test
    public void testChild() {
        
        
       
        System.out.println("child");
        char c = 'z';
        Node instance = testNode;
        Node expResult = zNode;
        Node result = instance.child(c);
        assertEquals(expResult, result);

     
        
    }

    /**
     * Test of bornChild method, of class Node.
     */
    @Test
    public void testBornChild() {
        System.out.println("bornChild");
        char c = 'a';
        Node instance = testNode;        
        Node result = instance.bornChild(c);
        Node expResult = instance.child(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of isObsolete method, of class Node.
     */
    @Test
    public void testIsObsolete() {
        System.out.println("isObsolete");
        Node instance = new Node();
        boolean expResult = true;
        boolean result = instance.isObsolete();
        assertEquals(expResult, result);
        assertEquals(0,0);
    }

    /**
     * Test of killChild method, of class Node.
     */
    @Test
    public void testKillChild() {
        System.out.println("killChild");
        char c = 'z';
        Node instance = testNode;
        instance.killChild(c);
        Node expResult=null;
        Node result=instance.child(c);
        assertEquals(expResult,result);
      
    }
    
}
