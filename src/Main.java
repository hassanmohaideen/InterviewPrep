import dataStructures.Trie;
import graphs.DirectedGraph;

public class Main {
    public static void main(String[] args) {
        int[][] edgeMatrix = {
            {0, 1},
            {1, 4},
            {0, 4},
            {0, 5},
            {1, 3},
            {3, 2},
            {3, 4},
            {1, 2},
            {2, 4},
            {4, 3}
        };

        DirectedGraph graph = new DirectedGraph(edgeMatrix);
        graph.printBFSPath(0, 3);
    }
}