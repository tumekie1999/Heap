public class ArrayHeapTester{
  public static void main(String [] args){
    //Create the heap
    ArrayHeap<Integer> h = new ArrayHeap<Integer>();

    // add items
    h.addElement(new Integer(5));
    h.addElement(new Integer(3));
    h.addElement(new Integer(7));
    h.addElement(new Integer(1));
    h.addElement(new Integer(6));
    h.addElement(new Integer(2));
    h.addElement(new Integer(10));

    System.out.println("test insert()");
    System.out.println("expect:\t1 3 2 5 6 7 10");
    System.out.println("got:\t"+h);

    // remove items
    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t2 3 7 5 6 10");
    System.out.println("got:\t"+h);

    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t3 5 7 10 6");
    System.out.println("got:\t"+h);

    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t5 6 7 10");
    System.out.println("got:\t"+h);

    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t6 10 7");
    System.out.println("got:\t"+h);

    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t7 10");
    System.out.println("got:\t"+h);

    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t10");
    System.out.println("got:\t" + h);

    System.out.println("test remove()");
    h.removeMin();
    System.out.println("expect:\t");
    System.out.println("got:\t"+h);
  }
}
