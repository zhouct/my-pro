package com.zc.base.algorithms.his;

import java.util.*;

public class WordsFind {

    public static void main(String[] args) {
        WordsFind wordsFind = new WordsFind();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(wordsFind.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie(new HashMap<>());
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(set, trie, board, i, j);
            }
        }
        return new ArrayList<>(set);
    }

    private void findWords(Set<String> set, Trie trie, char[][] board, int i, int j) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0){
            return;
        }
        if(!trie.children.containsKey(board[i][j])){
            return;
        }
        char ch = board[i][j];
        board[i][j] = '#';
        int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int k = 0; k < pos.length; k++) {
            findWords(set, trie.children.get(ch), board, i + pos[k][0], j + pos[k][1]);
        }
        if(trie.children.get(ch).word != ""){
            set.add(trie.children.get(ch).word);
        }
        board[i][j] = ch;
    }

    /**
     * 字典树
     */
    class Trie{

        String word;

        Map<Character, Trie> children;

        public Trie(Map<Character, Trie> children) {
            this.word = "";
            this.children = children;
        }

        public void insert(String word){
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                if(!trie.children.containsKey(word.charAt(i))){
                    trie.children.put(word.charAt(i), new Trie(new HashMap<>()));
                }
                trie = trie.children.get(word.charAt(i));
            }
            trie.word = word;
        }
    }


}
