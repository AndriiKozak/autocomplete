/*
 *  This task is done to study purposes. Rights somehow distributed between
 *  lectors given task, textbooks, and me. 
 */
package com.someone.javalab.autocomplete;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Andrii_Kozak1
 */
public class RWayTrie implements Trie {

    private volatile int version = 0;
    private Node root = new Node();

    @Override
    public boolean add(Tuple tuple) {
        boolean res = add(root, tuple.getWord(),
                tuple.getWeight(), tuple.getWord());
        if (res) {
            version++;
        }
        return res;
    }

    private boolean add(Node node, String postfix,
            Integer weight, String word) {
        if (postfix.isEmpty()) {
            if (node.weight == null) {
                node.weight = weight;
                node.word = word;
                return true;
            } else {
                return false;
            }
        } else {
            return add(node.bornChild(postfix.charAt(0)),
                    postfix.substring(1), weight, word);
        }
    }

    @Override
    public boolean contains(String word) {
        return contains(root, word);
    }

    private boolean contains(Node node, String postfix) {
        if (node == null) {
            return false;
        }
        if (postfix.isEmpty()) {
            return node.weight != null;
        }
        return contains(node.child(postfix.charAt(0)), postfix.substring(1));
    }

    @Override
    public boolean delete(String word) {
        boolean res = delete(root, word);
        if (res) {
            version++;
        }
        return res;
    }

    private boolean delete(Node node, String postfix) {
        if (node == null) {
            return false;
        }
        if (postfix.isEmpty()) {
            if (node.weight == null) {
                return false;
            } else {
                node.weight = null;
                return true;
            }
        }
        boolean result = delete(node.child(postfix.charAt(0)),
                postfix.substring(1));

        // deleting unnessesary node. 
        boolean isObsolete = true;
        if (postfix.charAt(0) <= 'z' && postfix.charAt(0) >= 'a') {
            if (node.child(postfix.charAt(0)) != null) {
                if (node.child(postfix.charAt(0)).weight != null) {
                    isObsolete = false;
                } else {
                    for (int i = 0; i < Node.R; i++) {
                        if (node.child(postfix.charAt(0)).childs[i] != null) {
                            isObsolete = false;
                            break;
                        }
                    }
                }
                if (isObsolete) {
                    node.childs[postfix.charAt(0) - 'a'] = null;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        int s = (node.weight == null) ? 0 : 1;
        for (int i = 0; i < Node.R; i++) {
            s += size(node.childs[i]);
        }
        return s;
    }

    @Override
    public Iterable<String> words() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new WidthIterator(root, version);
            }
        };
    }

    @Override
    public Iterable<String> wordsWithPrefix(String pref) {
        String meltingPref = pref;
        Node node = root;
        while (!meltingPref.isEmpty()) {
            node = node.child(meltingPref.charAt(0));
            meltingPref = meltingPref.substring(1);
            if (node == null) {
                return new LinkedList();
            }
        }
        final Node FNODE = node;
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new WidthIterator(FNODE, version);
            }
        };
    }

    private class WidthIterator implements Iterator<String> {

        private Queue<Node> queue = new LinkedList();
        private String next;
        private int onVersion;

        WidthIterator(Node node, int onVersion) {
            this.onVersion = onVersion;
            queue.add(node);
            update();
        }

        @Override
        public String next() {
            if (version != this.onVersion) {
                throw new ConcurrentModificationException();
            }
            String result;
            if (next == null) {
                throw new NoSuchElementException();
            } else {
                result = next;
            }
            next = null;
            update();
            return result;
        }

        @Override
        public boolean hasNext() {
            return !(next == null);
        }

        private void update() {
            Node node;
            while (!queue.isEmpty()) {
                node = queue.remove();
                for (int i = 0; i < Node.R; i++) {
                    if (node.childs[i] != null) {
                        queue.add(node.childs[i]);
                    }
                    if (node.weight != null) {
                        next = node.word;
                        break;
                    }
                }

            }
        }
    }

    private static class Node {

        static final int R = 26;
        Integer weight;
        String word;
        Node[] childs = new Node[R];

        public Node child(char c) {
            if ((c - 'a') >= 0 && (c - 'a') < R) {
                return childs[c - 'a'];
            } else {
                return null;
            }
        }

        public Node bornChild(char c) {
            if ((c - 'a') >= 0 && (c - 'a') < R) {
                if (childs[c - 'a'] == null) {
                    childs[c - 'a'] = new Node();
                }
                return childs[c - 'a'];
            } else {
                return null;
            }
        }
    }
}
