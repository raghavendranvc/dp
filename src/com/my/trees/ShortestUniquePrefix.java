package com.my.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

    //private static long globa_level = 0;

    class TrieNode {
        Map<Character, Long> wordCounts = null;
        long currentLevel = -1;

        public TrieNode(){
            wordCounts = new HashMap<>();
            //currentLevel = globa_level;
            //globa_level++;
        }

        public void add(Character character){
            wordCounts.put(character, wordCounts.getOrDefault(character,0L)+1);
        }

        public long getCount(Character character){
            return wordCounts.getOrDefault(character,0L);
        }
        public String toString(){
            return wordCounts.toString();
        }
    }

    private ArrayList<TrieNode> trieTree = new ArrayList<>();

    public ArrayList<String> prefix(ArrayList<String> A) {

        for(int i=0;i<A.size();i++){
            String str = A.get(i);
            for(int j=0;j<str.length();j++){
                if(trieTree.size() == j){
                    trieTree.add(new TrieNode());
                }
                trieTree.get(j).add(str.charAt(j));
            }
        }

        //System.out.println("Trie built="+trieTree);

        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            String str = A.get(i);
            StringBuilder uniquePrefix = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if(trieTree.get(j).getCount(str.charAt(j)) > 1L){
                    uniquePrefix.append(str.charAt(j));
                } else if(trieTree.get(j).getCount(str.charAt(j)) == 1L){
                    uniquePrefix.append(str.charAt(j));
                    break;
                }
            }
            result.add(uniquePrefix.toString());
        }

        return result;
    }

}
