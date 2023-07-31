/**
 * ArrayHeap provides an array implementation of a minheap.
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T>{
  /**
   * Creates an empty heap.
   */
  public ArrayHeap(){
    super();
  }

  /**
   * Adds the specified element to this heap in the appropriate
   * position according to its key value.  
   *
   * @param obj the element to be added to the heap
   */
  public void addElement(T obj){
    if (!(obj instanceof Comparable)){
      throw new NonComparableElementException("ArrayHeap");
    }

    if(count == tree.length){
      expandCapacity();
    }

    tree[count] = obj;
    count++;

    if (count > 1){
      heapifyAdd();
    }
  }

  /**
   * swap a parent with a child
   */
  private void swap(int parent, int child){
    T temp = tree[parent];
    tree[parent] = tree[child];
    tree[child] = temp;
  }

  /**
   * Reorders this heap to maintain the ordering property after
   * adding a node.
   */
  private void heapifyAdd(){
    int child = count - 1; // start from last node added
    int parent = (child-1)/2; // find parent location

    boolean done = false;
    while (parent >= 0 && ! done){
      if (((Comparable) tree[parent]).compareTo(tree[child]) > 0){
        swap(parent, child);
        child = parent;
        parent = (child-1)/2;
      }else{
        done = true;
      }
    }
  }

  /**
   * Remove the element with the lowest value in this heap and
   * returns a reference to it. Throws an EmptyCollectionException if
   * the heap is empty.
   *
   * @return a reference to the element with the lowest value in this heap
   * @throws EmptyCollectionException if the heap is empty
   */
  public T removeMin() throws EmptyCollectionException{
    T result = null;
    if (isEmpty()){
      throw new EmptyCollectionException("ArrayHeap");
    }else if(count == 1){
      result = tree[0];
      tree[0] = null;
      count = 0;
    }else{
      result = tree[0];
      tree[0] = tree[count-1]; // replace root with last node added
      count--;
      heapifyRemove();
    }
    return result;
  }

  /**
   * Reorders this heap to maintain the ordering property
  * after the minimum element has been removed.
   */
  private void heapifyRemove(){
    int parent = 0, left = 1, right = 2; boolean done = false;
    while(!done){
      if (left >= count){ done = true; } // none of the children exists
      else if (right >= count){ // only left child exists
        if (((Comparable) tree[left]).compareTo(tree[parent]) < 0){
          swap(parent, left);
        }
        done = true;
      }else{ // both children exist
        int next = right;
        if(((Comparable) tree[left]).compareTo(tree[right]) < 0){
          next = left;
        }
        if (((Comparable) tree[next]).compareTo(tree[parent]) < 0){
          swap(parent, next);
        }else{ done = true;}
        // prepare for next iteration
        parent = next; left = parent*2 + 1; right = parent*2 + 2;
      }
    }
  }

  /**
   * Returns the element with the lowest value in this heap.
   * Throws an EmptyCollectionException if the heap is empty.
   *
   * @return the element with the lowest value in this heap
   * @throws EmptyCollectionException if the heap is empty
   */
  public T findMin() throws EmptyCollectionException{
    if (isEmpty()){
      throw new EmptyCollectionException("ArrayHeap");
    }
    return tree[0];
  }
}


