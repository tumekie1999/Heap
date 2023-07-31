import java.util.Arrays;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T>{
  private static final int DEFAULT_CAPACITY = 50;
  protected int count;
  protected T[] tree;

  /**
   * Creates an empty binary tree.
   */
  public ArrayBinaryTree(){
    count = 0;
    tree = (T[]) new Object[DEFAULT_CAPACITY];
  }

  /**
   * Creates a binary tree with the specified element as its root.
   *
   * @param element the element which will become the root of the new tree
   */
  public ArrayBinaryTree(T element){
    count = 1;
    tree = (T[]) new Object[DEFAULT_CAPACITY];
    tree[0] = element;
  }

  /**
   * Private method to expand capacity if full.
   */
  protected void expandCapacity(){
    tree = Arrays.copyOf(tree, tree.length*2);
  }

  /**
   * Returns the root element of the tree.
   *
   * @return element stored at the root
   * @throws EmptyCollectionException if the tree is empty
   */
  public T getRootElement() throws EmptyCollectionException{
    if (isEmpty()){
      throw new EmptyCollectionException("ArrayBinaryTree");
    }
    return tree[0];
  }

  /**
   * Returns true if this binary tree is empty and false otherwise.
   * 
   * @return true if this binary tree is empty, false otherwise
   */
  public boolean isEmpty(){
    return (count == 0);
  }

  /**
   * Returns the integer size of this binary tree.
   *
   * @return the integer size of this binary tree
   */
  public int size(){
    return count;
  }

  /**
   * Returns true if this tree contains an element that matches the
   * specified target element and false otherwise.
   *
   * @param targetElement the element being sought in the tree
   * @return true if the element is in this tree
   */
  public boolean contains(T targetElement){
    T temp;
    boolean found = false;
    try{
      temp = find(targetElement);
      found = true;
    }catch (Exception ElementNotFoundException){
      found = false;
    }
    return found;
  }

  /**
   * Returns a reference to the specified target element if it is
   * found in this binary tree.  Throws a ElementNotFoundException if
   * the specified target element is not found in the binary tree.
   *
   * @param targetElement the element being sought in the tree
   * @return true if the element is in the tree
   * @throws ElementNotFoundException if the element is not in the tree
   */
  public T find(T targetElement) throws ElementNotFoundException{
    T result = null;
    boolean found = false;

    for (int i = 0; i < tree.length && !found; i++){
      if (tree[i] != null){
        if (targetElement.equals(tree[i])){
          found = true;
          result = tree[i];
        }
      }
    }

    if(!found){
      throw new ElementNotFoundException("ArrayBinaryTree");
    }

    return result;
  }

  /**
   * Returns the string representation of this binary tree.
   *
   * @return a string representation of the binary tree
   */
  public String toString(){
    String result = "";
    for (int i=0; i<count; i++){
      result += tree[i]+" ";
    }
    return result;
  }
}

