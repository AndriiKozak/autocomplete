/*
 *  This task is done to study purposes. Rights somehow distributed between lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
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
    @Override
    public boolean contains(String word){
        return contains(root, word);
    }
    private boolean contains(Node node,String postfix){
        if (node==null) return false;
        if (postfix.isEmpty()) return (node.weight!=null);
        return contains(node.child(postfix.charAt(0)),postfix.substring(1));
    } 
    @Override
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
    
    @Override
    public int size(){
       return size(root);   
    }
    private int size(Node node){
        if (node==null) return 0;
        int s=(node.weight==null)?0:1;
        for(int i=0;i<Node.R;i++) s+=size(node.childs[i]);
        return s;
    }
    @Override
    public Iterable<String> words(){
        return new Iterable<String>(){
            @Override
            public Iterator<String> iterator(){
                return new WidthIterator(root);
            }
    };
    }
    @Override
    public Iterable<String> wordsWithPrefix(String pref){
        Node node=root;
        while (!pref.isEmpty()){
            node=node.child(pref.charAt(0));
            pref=pref.substring(1);
            if (node==null) return new LinkedList();
        } 
        final Node fnode=node;
        return new Iterable<String>(){
            @Override
            public Iterator<String> iterator(){
                return new WidthIterator(fnode);
            }
        };
    }
    static private class WidthIterator implements Iterator<String> {
        private Queue<Node> queue =new LinkedList();
        private String next; 
        WidthIterator(Node node){
            queue.add(node);
            update();
        }
        @Override
        public String next(){
            String result;
            if (next==null) throw new NoSuchElementException();
                    else result=next;
            next=null;
            update();
        return result;
        }
        @Override
        public boolean hasNext(){
            return !(next==null);
        }
        private void update(){
           Node node;
           while (!queue.isEmpty()){
            node=queue.remove();
            for(int i=0;i<Node.R;i++){
                 if (node.childs[i]!=null) queue.add(node.childs[i]);
                 if (node.weight!=null) {next=(node.word);break;}
                } 
        
            }
        }
    }
}        

