/*
 *  This task is done to study purposes. Rights somehow distributed between lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

/**
 *
 * @author Andrii_Kozak1
 */
public interface Trie {
    public boolean add(Tuple tuple);
    public boolean contains(String word);
    public Iterable<String> words();
    public Iterable<String> wordsWithPrefix(String pref);
    public boolean delete(String word);
    public int size();
}
