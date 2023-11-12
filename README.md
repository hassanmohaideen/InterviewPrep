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
* When needing something that is Kth position (largest or smallest), we can use the Quick Select method from an unsorted array. 
   * We divide the array into smaller and larger than the pivot. Then we figure out where the pivot position is and decide which side we need to continue the algorithm on.
* Don't just try to traverse the array from left to right (0..arr.length). 
  * Traverse it the reverse way. 
  * You can traverse it from the middle to the left and the right.
* Two Pointers - traverse an array from left and right
  * Used with arrays it goes from left and then right
  * Can be used with LinkedList to find out if there is a cycle
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
* Bottom up 
  * You put the conditional check AFTER recursively going down into each child node
* When determining whether to go top down or bottom up think about how you would solve the question. 
  * Do you need information from the bottom nodes to resolve the current node? 
  * Do you need information from the top node to resolve the current node?
* Getting the height of a tree is easy!
```java
private int height(TreeNode root) {
  // An empty tree has height -1
  if (root == null) {
    return -1;
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
  * The indicies are:
    * Parent = i
    * Left = 2i + 1
    * Right = 2i + 2
    * To find the parent = (i-1)/2
### Min/Max Heaps
* Think about using this in the reverse way. Instead of just getting the minimum value, we can get the Kth largest value. 
  * We can use a max heap to get the Kth smallest value. 
# Algorithms
## Binary Search
* It's quite easy, just make sure to get the indices right
* The conditional is that left <= right
* The left and right change to become either mid + 1 or mid - 1
* The mid point is the starting point + the difference between the (high - low)/2
```java
public int search(int[] nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = nums.length - 1;
        
        // Under this condition
        while (left <= right) {
            // Get the middle index and the middle value.
            int mid = left + (right - left) / 2;
            
            // Case 1, return the middle index.
            if (nums[mid] == target) {
                return mid;
            } 
            // Case 2, discard the smaller half.
            else if (nums[mid] < target) {
                left = mid + 1;   
            } 
            // Case 3, discard the larger half.
            else {
                right = mid - 1;
            }
        }
        
        // If we finish the search without finding target, return -1.
        return -1;
    }
```
# Concepts
## Backtracking
* A lot of backtracking involves passing a bunch of parameters into a recursive call.
* The parameters are usually something like: 
  * The data structure that is going to hold the answer: List<List<Integer>> ans
  * The data structure that is going to hold the current permutation: List<Integer> curr
  * The data structure that holds integers that we take from (in the example of permutations the list of nums to make the permutations of): Int[] nums
  * The integer representing the index from a. which to start from or b. from which to just simply take the value from nums
* After making the recursive call, you will typically have to remove the element that you just added. The idea is that you choose one element and then not choose the next.