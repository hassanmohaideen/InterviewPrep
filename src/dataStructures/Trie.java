package dataStructures;

public class Trie {

    TrieNode<Character> root;

    public Trie() {
        root = new TrieNode<>(null);
    }

    public void insert(char[] word) {
        TrieNode<Character> curr = root;
        int currCharIndex = 0;
        while (currCharIndex < word.length) {
            char currChar = word[currCharIndex];
            if (curr.children.containsKey(currChar)) {
                curr = curr.children.get(currChar);
                currCharIndex++;
            } else {
                curr.children.put(currChar, new TrieNode<>(currChar));
            }
        }
        curr.children.put('*', null);
    }

    public boolean isPrefix(char[] word) {
        TrieNode<Character> curr = root;
        int currCharIndex = 0;
        while (currCharIndex < word.length) {
            char currChar = word[currCharIndex];
            if (curr.children.containsKey(currChar)) {
                curr = curr.children.get(currChar);
                currCharIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

}
