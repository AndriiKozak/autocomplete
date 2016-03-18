/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.someone.javalab.autocomplete;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrii_Kozak1
 */
public class PrefixMatches {
    public Trie trie=new RWayTrie();
    public int add(String... strings){
        int res=0;
        for(String s:strings){
            String[] words=s.split("\\s+");
            for(String word:words)
                if (word.length()>1){
                    if (trie.add(new Tuple(word,word.length()))) res++;
                    System.out.println(word);
                }
                        
        }
        return res;
    }
    public int size(){
       return trie.size();
    }
    public boolean delete(String word){
        return trie.delete(word);
    }
    public boolean contains(String word){
        return trie.contains(word);
    }
    
    public Iterable<String> wordsWithPrefix(String pref, int k){
        List<String> res=new LinkedList();
        if (pref.length()<2) return res;
        Iterable<String> iWord = trie.wordsWithPrefix(pref);
        for(String word:iWord){
           if (word.length()-pref.length()<k) res.add(word);
           else break;
        }
    return res;    
    }
}