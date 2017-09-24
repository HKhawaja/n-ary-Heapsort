import java.lang.management.*;   // NOTE

public class Heapsort {

    public static void main (String[] args) {
	
	ThreadMXBean bean = ManagementFactory.getThreadMXBean();   // NOTE
	
	int N = Integer.parseInt(args[0]);
	int branch1 = Integer.parseInt(args[1]);
	int branch2 = Integer.parseInt(args[2]);
	int branch3 = Integer.parseInt(args[3]);
	int branch4 = Integer.parseInt(args[4]);
	int branch5 = Integer.parseInt(args[5]);
	int branch6 = Integer.parseInt(args[6]);
	int branch7 = Integer.parseInt(args[7]);
	int branch8 = Integer.parseInt(args[8]);
	int branch9 = Integer.parseInt(args[9]);
	
	System.out.println ("Generating " + N + " random numbers");
	int[] a = new int[N];
	for (int i=0; i<N; ++i) a[i] = (int)(Math.random()*(1<<30));

	// To test a particular sorting algorithm, I make a copy of the original
	// array, and then record the current "user time".  After running the
	// sort, I compute the elapsed time by taking the difference between the
	// time and the time from before the sort.

	// Here I make 10 copies of the input array, each to be sorted with 
	// Heapsort using a different branch factor
	
	int[] arr1 = new int[N];
	int[] arr2 = new int[N];
	int[] arr3 = new int[N];
	int[] arr4 = new int[N];
	int[] arr5 = new int[N];
	int[] arr6 = new int[N];
	int[] arr7 = new int[N];
	int[] arr8 = new int[N];
	int[] arr9 = new int[N];
	int[] arr10 = new int[N];
	
	for (int i=0; i<N; ++i) {
	    arr1[i] = a[i];
	    arr2[i] = a[i];
	    arr3[i] = a[i];
	    arr4[i] = a[i];
	    arr5[i] = a[i];
	    arr6[i] = a[i];
	    arr7[i] = a[i];
	    arr8[i] = a[i];
	    arr9[i] = a[i];
	    arr10[i] = a[i];
	}
	
	/*
	long t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	
	insertionSort(arr1);
	//print (arr1);
	System.out.printf ("Insertion sort took %f seconds.\n",     // NOTE
	                  (bean.getCurrentThreadUserTime()-t) / 1e9);
	*/		   
	
	long t;
	
	// Heapsort with first branch factor 
	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr2, branch1);
	//print (arr2);
	System.out.printf ("Heapsort with branch " + branch1 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);

	
	// Heapsort with second branch factor
	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr3, branch2);
	//print (arr3);
	System.out.printf ("Heapsort with branch " + branch2 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);
	
	
	// And so on...
	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr4, branch3);
	//print(arr4);
	System.out.printf ("Heapsort with branch " + branch3+ " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);

	
	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr5, branch4);
	//print(arr5);
	System.out.printf ("Heapsort with branch " + branch4 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);
	

	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr6, branch5);
	//print(arr6);
	System.out.printf ("Heapsort with branch " + branch5 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);
	
	
	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr7, branch6);
	//print(arr7);
	System.out.printf ("Heapsort with branch " + branch6 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);


	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr8, branch7);
	//print(arr8);
	System.out.printf ("Heapsort with branch " + branch7 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);

	
	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr9, branch8);
	//print(arr9);
	System.out.printf ("Heapsort with branch " + branch8 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);


	t = bean.getCurrentThreadUserTime();   // NOTE  (t is a *long*)
	heapsort(arr10, branch9);
	print(arr10);
	System.out.printf ("Heapsort with branch " + branch9 + " took %f seconds.\n",     // NOTE
			   (bean.getCurrentThreadUserTime()-t) / 1e9);


	//check(arr1, arr10);
	
    }
    
    /////////////////////////////////////////////////////////////////////////
    // This method prints the contents of an array.  You might use it during
    // debugging.
    /////////////////////////////////////////////////////////////////////////

    public static void print(int[] a) {
	for (int i=0; i<a.length; ++i)
	    System.out.println (a[i]);
	System.out.println();
    }

    /////////////////////////////////////////////////////////////////////////
    // This method compares the contents of two arrays.  You might use it
    // during debugging to compare the results of two different algorithms.
    /////////////////////////////////////////////////////////////////////////

    public static void check(int[] a, int[] b) {
	for (int i=0; i<a.length; ++i)
	    if (a[i] != b[i]) 
		throw new RuntimeException ("Error in sorting results");
    }

    /////////////////////////////////////////////////////////////////////////
    // Here's the insertion sort.
    /////////////////////////////////////////////////////////////////////////

    public static void insertionSort(int[] a) {

	int n = a.length;

	for (int i=1; i<n; ++i) {
	    
	    int t = a[i];
	    int j = i-1;
	    while (j >= 0 && t < a[j]) {
		a[j+1] = a[j];
		j--;
	    }
	    a[j+1] = t;
	}
    }

    public static void swap(int[] a, int i, int j)
    {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    public static void heapify(int[] heap, int index, int size, int branch)
    {
	
	int largest;
	int leftChild = index * branch + 1;
	// This means there are no children
	if (leftChild >= size)
	    return;
	else 
	    largest = leftChild;
	
	// find the largest from all the remaining children
	for (int i = leftChild+1; i< leftChild + branch; i++) {
	    
	    // incomplete number of children
	    if (i >= size) 
		break;
	    else {
		if (heap[i] > heap[largest])
		    largest = i;
	    }
	}
	
	if (heap[largest] > heap[index]) {
	    swap(heap, index, largest);
	    heapify(heap, largest, size, branch);
	}
	
    }

    // find out for all variants
    public static void buildHeap(int[] heap, int branch)
    {
	if (heap.length%branch == 0 || heap.length%branch ==1) {
	    
	    for (int i = heap.length / branch - 1; i >= 0; i--)
		{
		    heapify(heap, i, heap.length, branch);
		}
	}
	
	else {
	    for (int i = heap.length/branch; i>=0; i--) {
		heapify (heap,i,heap.length,branch);
	    }
	    
	}
    }

    public static void heapsort(int[] heap, int branch)
    {
	buildHeap(heap,branch);
	int sizeSorted = 0;
	for (int i = heap.length-1; i>=1; i--) {
	    swap (heap, i, 0);
	    sizeSorted++;
	    heapify (heap, 0, heap.length-sizeSorted,branch);
	}
    }
}

