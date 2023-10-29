package graphs;

import dataStructures.TreeNode;

import java.util.*;

public class DirectedGraph {
    List<TreeNode<Integer>> nodes;
    public DirectedGraph(int[][] edgeMatrix) {
        nodes = new ArrayList<>();
        if (edgeMatrix[0].length != 2) {
            createUndirectedGraphFromAdjMatrix(edgeMatrix);
        } else {
            createDirectedGraphFromEdgeMatrix(edgeMatrix);
        }
    }

    public void createUndirectedGraphFromAdjMatrix(int[][] adjMatrix) {
        for (int i=0; i<adjMatrix.length; i++) {
            nodes.add(new TreeNode(i));
        }

        for (int i=0; i<adjMatrix.length; i++) {
            for (int j=-0; j<adjMatrix[i].length; j++) {
                nodes.get(i).addChild(nodes.get(j));
            }
        }
    }

    public void createDirectedGraphFromEdgeMatrix(int[][] edgeMatrix) {
        int size = determineNumberOfNodesFromEdgeMatrix(edgeMatrix);
        for (int i=0; i<size; i++) {
            nodes.add(new TreeNode(i));
        }

        for (int[] matrix : edgeMatrix) {
            int start = matrix[0];
            int end = matrix[1];
            nodes.get(start).addChild(nodes.get(end));
        }
    }

    public int determineNumberOfNodesFromEdgeMatrix(int[][] edgeMatrix) {
        Set<Integer> seen = new HashSet<>();
        for (int[] matrix : edgeMatrix) {
            for (int j : matrix) {
                seen.add(j);
            }
        }
        return seen.size();
    }

    public void printDFSPath(int rootData, int nodeToFindData) {
        Set<TreeNode<Integer>> seen = new HashSet<>();
        printDFSPath(nodes.get(rootData), nodes.get(nodeToFindData), seen);
    }

    public void printDFSPath(
        TreeNode<Integer> root,
        TreeNode<Integer> nodeToFind,
        Set<TreeNode<Integer>> seen
    ) {
        System.out.println(root.getData());
        seen.add(root);

        if (Objects.equals(root.getData(), nodeToFind.getData())) {
            System.out.println("Found the node!");
            return;
        }

        for (TreeNode<Integer> child: root.getChildren()) {
            if (!seen.contains(child) && !seen.contains(nodeToFind)) {
                printDFSPath(child, nodeToFind, seen);
            }
        }
    }

    public void printBFSPath(int rootData, int nodeToFindData) {
        printBFSPath(nodes.get(rootData), nodes.get(nodeToFindData));
    }

    public void printBFSPath(TreeNode<Integer> root, TreeNode<Integer> nodeToFind) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode<Integer>> seen = new HashSet<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode<Integer> nodeChecking = queue.poll();
            System.out.println(nodeChecking.getData());

            if (nodeChecking.getData().equals(nodeToFind.getData())) {
                System.out.println("Found the node!");
                return;
            }

            for (TreeNode<Integer> child: nodeChecking.getChildren()) {
                if (!seen.contains(child)) {
                    queue.add(child);
                    seen.add(child);
                }
            }
        }
    }
}
