/*
 *  This task is done to study purposes.
 *  Rights somehow distributed between lectors given task,
 *  textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Andrii_Kozak1
 */
public class PMFactory {

    private static int total;

    public static PrefixMatches load() {
        PrefixMatches result = new PrefixMatches();
        try {
            BufferedReader b
                    = new BufferedReader(new FileReader("words-333333.txt"));
            b.readLine();
            String s = b.readLine();
            String[] words;
            total = 0;
            while (s != null) {
                words = s.split("\\s+");
                if (words[2].length() > 2) {
                    total++;
                }
                result.add(words[2]);
                s = b.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getTotal() {
        return total;
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

}
