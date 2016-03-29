/*
 *  This task is done to study purposes. Rights somehow distributed between
 *  lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

/**
 *
 * @author Andrii_Kozak1
 */
public interface Trie {

    boolean add(Tuple tuple);

    boolean contains(String word);

    Iterable<String> words();

    Iterable<String> wordsWithPrefix(String pref);

    boolean delete(String word);

    int size();
}
