/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.someone.javalab.autocomplete;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Andrii_Kozak1
 */
public class RWayTrie implements Trie{
    Node root=new Node();
    @Override
    public boolean add(Tuple tuple){
    return add(root,tuple.getWord(),tuple.getWeight(),tuple.getWord());    
    }
    private boolean add(Node node, String postfix, Integer weight,String word){
        if (postfix.isEmpty()) {
            if (node.weight==null){
            node.weight=weight;
            node.word=word;
            return true;
            } else 
                return false;
        }
        else return add(node.bornChild(postfix.charAt(0)),postfix.substring(1),weight,word);
    }
    public boolean contains(String word){
        return contains(root, word);
    }
    private boolean contains(Node node,String postfix){
        if (node==null) return false;
        if (postfix.isEmpty()) return (node.weight!=null);
        return contains(node.child(postfix.charAt(0)),postfix.substring(1));
    } 
    public boolean delete(String word){
        return delete(root,word);
    }
    private boolean delete(Node node, String postfix){
        if (node==null) return false;
        if (postfix.isEmpty()){ 
            if (node.weight==null) return false;
            else {
                node.weight=null;
                return true;
            }
        }
    boolean result = delete(node.child(postfix.charAt(0)),postfix.substring(1));
    
    // deleting unnessesary node. 
    if ((node.child(postfix.charAt(0))!=null)&&(node.child(postfix.charAt(0)).isObsolete()))
        node.killChild(postfix.charAt(0));
    return result;
    }
    
    public int size(){
       return size(root);   
    }
    private int size(Node node){
        if (node==null) return 0;
        int s=(node.weight==null)?0:1;
        for(int i=0;i<Node.R;i++) s+=size(node.childs[i]);
        return s;
    }
    public Iterable<String> words(){
        List<String> result=new LinkedList();
        Queue<Node> queue =new LinkedList(); 
        Node node;
        queue.add(root);
        while (!queue.isEmpty()){
         node=queue.remove();
         if (node.weight!=null) result.add(node.word);
         for(int i=0;i<Node.R;i++){
             if (node.childs[i]!=null) queue.add(node.childs[i]);
         }
        }
        return result;
    }
    public Iterable<String> wordsWithPrefix(String pref){
        List<String> result=new LinkedList();
        Queue<Node> queue =new LinkedList(); 
        Node node=root;
        while (!pref.isEmpty()){
            node=node.child(pref.charAt(0));
            pref=pref.substring(1);
            if (node==null) return result;
        }  
        queue.add(node);
        while (!queue.isEmpty()){
         node=queue.remove();
         if (node.weight!=null) result.add(node.word);
         for(int i=0;i<Node.R;i++){
             if (node.childs[i]!=null) queue.add(node.childs[i]);
         }
        }
        return result;
    }
}
