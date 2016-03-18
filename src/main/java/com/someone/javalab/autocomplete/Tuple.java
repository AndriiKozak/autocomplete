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
public class Tuple {
    private String word;
    private Integer weight;
    Tuple(String word, Integer weight){
        this.word=word;
        this.weight=new Integer(weight);
    }
    Integer getWeight(){
        return weight;
    }
    String getWord(){
        return word;
    }
}
