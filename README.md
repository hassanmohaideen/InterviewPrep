# InterviewPrep

|      Data Structures     |          Algorithms         |            Concepts           |
|:------------------------:|:---------------------------:|:-----------------------------:|
| Linked Lists             | BFS                         | Bit Manipulation              |
| Trees, Tries, and Graphs | DFS                         | Memory (Stack vs. Heap)       |
| Stacks and Queues        | Binary Search               | Recursion                     |
| Heaps                    | Merge Sort                  | Dynamic Programming           |
| Vectors/ArrayLists       | Quick Sort                  | Big O Time and Space          |
| Hash Tables              | Dijkstra’s Algorithm        | MapReduce                     |
| AVL Trees                | Rabin-Karp Substring Search | Graph Coloring                |
| Red-Black Trees          | Bellman-Ford Algorithm      | P, NP, and NP-Complete        |
| Minimum Spanning Trees   | Floyd-Warshall Algorithm    | Combinatorics and Probability |
| B-Trees                  | A*                          | Regular Expressions           |
| Interval Trees           |                             |                               |
| Bipartite Graph          |                             |                               |

# Interview Pointers
## Arrays and Hashing
* When needing something that is Kth position (largest or smallest), we can use the Quick Select method. 
   * We divide the array into smaller and larger than the pivot. Then we figure out where the pivot is continue on.
* Don't just try to traverse the array from 0..arr.length. Traverse it the reverse way. You can traverse it from the middle to the left and the right.
## Two Pointers
* Used with arrays it goes from left and then right
* Can be used with LinkedList to find out if there is a cycle
## Stack
* LIFO - last in first out
* When doing something that relies on using previous data, stacks are very helpful
  * You can use another data structure to keep track of previous stack values (such as lowest number)
## Heaps
* Can be used as a binary tree representation using an array
  * The indicies are:
    * Parent = i
    * Left = 2i + 1
    * Right = 2i + 2
    * To find the parent = (i-1)/2
## Linked Lists (Single/Double)
* Lots of questions rely on using FAST and SLOW pointers (has a cycle, get Kth from last, etc)
* Sometimes deleting a node is just to remove connections to the node and let GC handle it
* Setting two nodes to be K nodes apart is very useful!