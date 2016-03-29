/*
 *  This task is done to study purposes. Rights somehow distributed between
 *  lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

/**
 *
 * @author Andrii_Kozak1
 */
public class Tuple {

    private String word;
    private Integer weight;

    Tuple(String word, Integer weight) {
        this.word = word;
        this.weight = weight;
    }

    Integer getWeight() {
        return weight;
    }

    String getWord() {
        return word;
    }
}
