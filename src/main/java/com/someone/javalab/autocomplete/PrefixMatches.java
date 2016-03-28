/*
 *  This task is done to study purposes. Rights somehow distributed between lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

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
                if (word.length()>2){
                    if (trie.add(new Tuple(word,word.length()))) res++;
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
        if (pref.length()<2) return new LinkedList();
        
    return new Iterable<String>(){
        @Override
        public Iterator<String> iterator(){
            return new PrefIterator(trie.wordsWithPrefix(pref), pref.length()+k);
        }
    };    
    }
    public Iterable<String> wordsWithPrefix(String pref){
        return wordsWithPrefix(pref,3);
    }
    static private class PrefIterator implements Iterator<String>{
        Iterator<String> iterator;
        int l;
        String next;
        PrefIterator(Iterable<String> iterable, int l){
            this.l=l;
            iterator=iterable.iterator();
            update();
        }
        @Override
        public boolean hasNext(){
            return next!=null;
        }
        @Override
        public String next(){
            if (next==null) throw new NoSuchElementException();
            String res=next;
            update();
            return res;
        }
        final void update(){
            String possibleNext;
            next=null;
            if (iterator.hasNext()) {possibleNext=iterator.next();
                if (possibleNext.length()<l) next=possibleNext;
                }
        }
    }
}
