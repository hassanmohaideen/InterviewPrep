import dataStructures.Trie;
import graphs.Dijkstras;
import graphs.DirectedGraph;
import sorting.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<List<Integer>>();
        LinkedList<Integer> curr = new LinkedList<Integer>();
        Arrays.sort(candidates);
        backTracking(ans, curr, candidates, target, 0);
        return new ArrayList<>(ans);
    }

    public static void backTracking(
            HashSet<List<Integer>> ans,
            LinkedList<Integer> curr,
            int[] candidates,
            int target,
            int pos
    ) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
        } else if (target > 0) {
            for (int i=pos; i<candidates.length; i++) {
                if (i != pos && candidates[i] == candidates[i - 1])
                    continue;
                curr.addLast(candidates[i]);
                backTracking(ans, curr, candidates, target-candidates[i], i+1);
                curr.removeLast();
            }
        }
    }

}