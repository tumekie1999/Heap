# An Array-based Heap
## Purpose
The purpose of this lab is to work with a heap class, finish the
implementation to gain a greater understanding of the concepts related to heaps.

## Evaluation
Students will be awarded up to 10 points for successfully completing this lab
as outlined below.

## Prelab
Complete the following questions using your text prior to beginning the lab
activities. Put your answers in `result.txt`.

1. What is a heap data structure? (Use definition from your text)
2. What is the difference between a minheap and a maxheap?
3. Look at the diagram below.  Is this a minheap or maxheap?

![heap](./images/heap.png)

4. What is a different definition of a "heap" as used in computer science?
5. What is a complete binary tree? (Use text definition)

## Heap concept
Heaps are very useful data structures in computer science. They provide
`O(logn)` insertions and `O(logn)` retrievals. The objects stored in a heap must be `Comparable`.

The definition for a heap—as you should have already discovered by answering
your pre-lab questions is a binary tree with following properties:
* Must be complete (but not necessarily full).
* For a minheap, for each node, the `value` of the node is `<=` to both the left and right children.

### Insertion
When you insert a new node into a heap, the location is predetermined.
Since a heap must be complete, insert into the first empty location on the
lowest level. Following the insertion, you should "swap to the top" with this
node and its parent until the minheap property is restored. If the swap doesn’t
result in a heap, you should continue swapping up the tree until the heap
property is restored. This method is completed for you in the lab, but its
concept is shown below.

1. Assume you have a minheap as shown below:
```
     3
    /  \
   5    7
  / \  /
 8  10 6   <- next available location
```
2. You insert a node 2. To retain completeness property, it must
   go below the 7 as its right child. The tree is no longer a minheap, however,
   since 2 < 7.
```
     3
    /  \
   5    7 <- 7 and 2 violate minheap property
  / \  / \
 8  10 6  2 <-
```
3. To restore the minheap property, 2 swaps up (swap to the top) with 7.  This
   results in a subtree rooted in 2, which is a minheap.
```
     3
    /  \
   5    2
  / \  / \
 8  10 6  7
```
4. The entire tree (rooted in 3) is still not a heap, however, so the process
   is repeated until 2 arrives at the root.
```
     3 <-               2
    /  \               /  \
   5    2 <-   =>     5    3
  / \  / \           / \  / \
 8  10 6  7         8  10 6  7
```
### Removal
When a value is removed from the heap, the location of the key is
predetermined: always remove the item located in the root location. This would
result in a rootless tree as shown below:
```
       <- root has been removed
    /  \
   5    3
  / \  / \
 8  10 6  7
```
1. To retain the completeness property, the only node that can replace the root
   is the lowest on the right (7), so it becomes the new root.
```
     7
    /  \
   5    3
  / \  /
 8  10 6
```
2. We reverse the "swap to top" action to restore heap property; instead using
   a "swap and drop" action. The first swap would be with 7 and 3 because 3 is the smaller of the two children's of 7.
```
     3
    /  \
   5    7
  / \  /
 8  10 6
```
3. If necessary, the swapping would continue until the heap property is restored. After another swap (6 and 7) the minheap proptery is restored.
```
     3
    /  \
   5    6
  / \  /
 8  10 7
```

## Task 1: study the insert method
The starter code implements `ArrayHeap` by extending `ArrayBinaryTree`, which uses an array to store the tree and implements `contains` and `find`. The `ArrayHeap` adds `addElement` and `removeMin` so that the array-based binary tree behaves like a minheap. The UML class diagram for this design is as follows:

![class diagram](./images/class_diagram.png)

Study the code and answer the following questions in `result.txt`:
1. Explain how the `addElement` method works.
2. Draw the heap created in `ArrayHeapTester.java` in its binary tree form (you mimic the ASCII drawing in the previous section).
3. Redraw the heap as it exists after inserting `4`.

## Task 2: implement the remove method
The pseudo code for the remove algorithm (discussed in class) is as follows:
1. Pluck the root by getting the item at location 0 in the tree array
2. Replace the root with the lowest value in the tree. Remember that we are keeping track of the insertion point, which is `count`. Since the insertion point is always next to the last item added, we can replace the plucked root with `tree[count-1]`.
3. By replacing the root, the shape property has been restored. Unfortunately
   we potentially have a non-heap based on the value we just put in the root
   position. The `heapifyRemove` method will solve this problem for us.
4. Since you’ve restored both the shape and heap properties, all that is left to
   do is return the object and you are done.

After you have implemented `removeMin` all test cases in `ArrayHeapTester.java` should pass. Please include the output from the test cases in `result.txt`.
