# InterviewPrep

|        Data Structures         |          Algorithms         |           Concepts            |
|:------------------------------:|:---------------------------:|:-----------------------------:|
|       Arrays and HashMaps      |                             |                               |
|          Linked Lists          | BFS                         |       Bit Manipulation        |
|    Trees, Tries, and Graphs    | DFS                         |    Memory (Stack vs. Heap)    |
|       Stacks and Queues        | Binary Search               |           Recursion           |
|             Heaps              | Merge Sort                  |      Dynamic Programming      |
|       Vectors/ArrayLists       | Quick Sort                  |     Big O Time and Space      |
|          Hash Tables           | Dijkstra’s Algorithm        |           MapReduce           |
|           AVL Trees            | Rabin-Karp Substring Search |        Graph Coloring         |
|        Red-Black Trees         | Bellman-Ford Algorithm      |    P, NP, and NP-Complete     |
|     Minimum Spanning Trees     | Floyd-Warshall Algorithm    | Combinatorics and Probability |
|            B-Trees             | A*                          |      Regular Expressions      |
|         Interval Trees         |                             |         Backtracking          |
|        Bipartite Graph         |                             |                               |
# Things to do during the interview
1. Ask clarifying questions
2. Propose a solution. Talk out loud and let them know what you are thinking. 
3. Think about edge cases
4. Write the code for the problem
5. Go through some test cases
6. Confirm the runtime and space complexities
# Data Structures
## Arrays and HashMaps
* When having to do something with subarrays of ints, think about using cumulative sums
  * This is especially useful when needing to do something with an array with itself (multiply a product of array by itself)
* When needing something that is Kth position (largest or smallest)
  * We can use the Quick Select method from an unsorted array. 
     * We divide the array into smaller and larger than the pivot. 
     * Then we figure out where the pivot position is and decide which side we need to continue the algorithm on.
  * We can use a minHeap or a maxHeap
    * minHeap - when needing to get the kth LARGEST item
      * Make a heap of size k
      * Add items to the heap
      * When you reach k+1 items, remove root item - this is the maximum item
    * minHeap - when needing to get the kth SMALLEST item
      * Make a heap of size k
      * Add items to the heap
      * When you reach k+1 items, remove root item - this is the minimum item
* Don't just try to traverse the array from left to right (0..arr.length). 
  * Traverse it the reverse way. 
  * You can traverse it from the middle to the left and the right.
* Two Pointers - traverse an array from left and right
  * Used with arrays it goes from left and then right
  * Can be used with LinkedList to find out if there is a cycle
* You don't always have to look for values ahead of you. You can look for them behind you as you iterate through the array.
* Think about using a sliding window when needing to find a the max subarray containing values
## Linked Lists (Single/Double)
* Lots of questions rely on using FAST and SLOW pointers (has a cycle, get Kth from last, etc)
* Sometimes deleting a node is just to remove connections to the node and let GC handle it
* Setting two nodes to be K nodes apart is very useful!
## Trees, Tries, and Graphs
* Think about these as conjoined linked lists
* A tree and a trie are graphs
* You can use a global variable if you want to keep track of data outside while iterating through the nodes
### Binary Trees
* There is top down and bottom up approaches solving some of the issues
* Top down
  * You put the conditional check BEFORE recursively going down into each child node
  * Another way of thinking, is that you do the work at the parent node and then go down to the children. 
    * In this way you might need to have a way of transferring the data from the top node downwards.
* Bottom up 
  * You put the conditional check AFTER recursively going down into each child node
  * Another way of thinking, is that you do the work at the child node and then send it upwards
    * In this way you have to think of creative ways of transferring the data upwards
      * Maybe this is another data class to hold the info
      * Maybe it has to do with sending integer values (that represent something else)
* When determining whether to go top down or bottom up think about how you would solve the question. 
  * Do you need information from the bottom nodes to resolve the current node? 
  * Do you need information from the top node to resolve the current node?
* Sometimes top-down and bottom-up are not the ways to go - instead think of preorder, inorder, and postorder traversal
* Completeness of a tree just means that you don't encounter a null node while BFS through the tree before encountering a non-null node
* Getting the height of a tree is easy!
```java
private int height(TreeNode root) {
  // An empty tree has height 0
  if (root == null) {
    return 0;
  }
    return 1 + Math.max(height(root.left), height(root.right));
}
```
## Stack and Queues
### Stacks
* LIFO - last in first out
* When doing something that relies on using previous data, stacks are very helpful
  * You can use another data structure to keep track of previous stack values (such as lowest number)
### Queue
* FIFO - first in first out
* This is good when you want to make sure to do some work right after finishing the work you are doing. You want to QUEUE up something!
## Heaps
* Can be used as a binary tree representation using an array
  * The indices are:
    * Parent = i
    * Left = 2i + 1
    * Right = 2i + 2
    * To find the parent = (i-1)/2
### Min/Max Heaps
* Think about using this in the reverse way. Instead of just getting the minimum value, we can get the Kth largest value. 
  * We can use a max heap to get the Kth smallest value. 
* Min/Max heaps have other applications
  * K way merge of K sorted arrays
  * Determining how many meeting rooms are needed for given intervals
* Think about using this when you need to get the minimum value of the next thing happening
# Algorithms
## BFS
* This can be used for finding the shortest path from A to B
## DFS
* This is really useful for determining if there is path from A to B
* This can be used for finding if there is a cycle 
## Binary Search
* It's quite easy, just make sure to get the indices right
* The conditional is that left <= right
* The left and right change to become either mid + 1 or mid - 1
* The mid point is the starting point + the difference between the (high - low)/2
* Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.
```python
def binary_search(array) -> int:
    def condition(value) -> bool:
        pass

    left, right = min(search_space), max(search_space) # could be [0, n], [1, n] etc. Depends on problem
    while left < right:
        mid = left + (right - left) // 2
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    return left
```
# Concepts
## Backtracking
* A lot of backtracking involves passing a bunch of parameters into a recursive call. The parameters are usually something like: 
  * The data structure that is going to hold the answer: List<List<Integer>> ans
  * The data structure that is going to hold the current permutation: List<Integer> curr
  * The data structure that holds integers that we take from (in the example of permutations the list of nums to make the permutations of): Int[] nums
  * The integer representing the index from a. which to start from or b. from which to just simply take the value from nums
* The typical backtracking algorithm is something like: 
  * Create parameters that will hold values
  * Make a call to the recursive helper function (this function really acts like a second for loop)
  * The recursive helper function algo looks like - 
    * Add the current permutation parameter to the answer parameter
    * Loop through the numbers in the array 
      * Add the item to the current permutation
      * Make a recursive call to the helper function
      * Remove the item from the current permutation
* Example - 
```java
public Set<List<Integer>> subsets(int[] nums, Set<List<Integer>> ans, List<Integer> curr, int start) {
  ans.add(new ArrayList<Integer>(curr));
  for (int i=start; i<nums.length; i++) {
      curr.add(nums[i]);
      subsets(nums, ans, curr, i+1);
      curr.remove(curr.size()-1);
  }
  return ans;
}
```
* After making the recursive call, you will typically have to remove the element that you just added. The idea is that you choose one element and then not choose the next.
* Getting unique combinations can mean that you sort the values first, and then not taking the value in the for-loop if it is the same as the value passed in through the recursive function. 
  * See - https://leetcode.com/problems/combination-sum-ii/
```java
public void backTracking(
    HashSet<List<Integer>> ans,
    LinkedList<Integer> curr,
    int[] candidates,
    int target,
    int pos
) {
    if (target == 0) {
        ans.add(new ArrayList<Integer>(curr));
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
```
* Take a look at the `if (i != pos && candidates[i] == candidates[i - 1])` this is meant to be that we don't take the next value if it is the same as the previous value (aka a duplicate)
## Merging Arrays
* You can merge items by going through the array and then adding them to an item that you are going to put together
* Think about merging backwards for sorted arrays
* Think about using multiple pointers
* Think about using heaps
## Intervals
* Determining whether intervals are overlapping you just have to see if the start of one is in the range of the other
* When you are adding an interval into a list of intervals (and merging so that there are no-overlapping intervals). 
  * You can first add the interval into the list in the sorted order
  * Then you go through the intervals in the list and see whether or not you need to merge it with the next interval in the list
