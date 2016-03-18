/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
