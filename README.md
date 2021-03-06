# n-ary-Heapsort
An implementation of Heapsort with a heap of branch factor n, where n can vary.

The purpose of this project was to analyze how the branch factor of the heap affects the time for Heapsort to sort a certain array; more specifically, how the runtime of the maxHeapify() method was affected by the number of branches of the heap.

From the series of trials carried out (2<= n <= 10), it was concluded that a branch factor of 5 gave the fastest average running time. The reason why the best branch factor is an intermediate and not an extreme can be attributed to two major trade-offs. With an increasing branch factor, for the same value of ‘N’, the heap has a height that is smaller than the height of a heap with a smaller branching factor by a constant value. This means there are a smaller number of levels for the tree, but a greater number of elements for each level (except the first). This allows for firstly, a reduced number of calls to heapify in the recursive method (because of a decreased height), and secondly, the program to access a larger number of continuous element indices (a greater number of “fast” indexes). These factors speed up the running time of the algorithm. However, the trade-off with an increasing branch factor is the increased amount of work (because a greater number of children need to be compared) at each call to heapify, and a larger number of “slow” indexes to be skipped over. These trade-offs favor an intermediate value for the optimum branch factor, which was found to be 5. 

Refer to the "Project" text file for more details!
