/*
 *  This task is done to study purposes. Rights somehow distributed between lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;
/**
 *
 * @author Andrii_Kozak1
 */
public class Node {
    final static int R=26;
    Integer weight;
    String word;
    Node[] childs=new Node[R];
    public Node child(char c){
        if (((c-'a')>=0)&&((c-'a')<R)) return childs[c-'a']; 
        else return null;
    }
    public Node bornChild(char c){
        if (((c-'a')>=0)&&((c-'a')<R)) {
            if (childs[c-'a']==null) childs[c-'a']=new Node();
            return childs[c-'a'];
        }
        else return null;
    }
    public boolean isObsolete(){
        if(weight!=null) return false;
        for(int i=0;i<R;i++) 
            if (childs[i]!=null) return false;
        return true;
    }
    public void killChild(char c){
         if (((c-'a')>=0)&&((c-'a')<R)) childs[c-'a']=null;
    };
}
