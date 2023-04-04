import dataStructures.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("testing".toCharArray());
        System.out.println(trie.isPrefix("test".toCharArray()));
        System.out.println(trie.isPrefix("tst".toCharArray()));
    }
}