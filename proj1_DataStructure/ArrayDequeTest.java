/** Performs some basic linked list tests. */
public class ArrayDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}
	
	public static boolean checkGet(int expected, int actual) {
		if (expected != actual) {
			System.out.println("get() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		
		ArrayDeque<String> ad1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, ad1.isEmpty());

		ad1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, ad1.size()) && passed;
		passed = checkEmpty(false, ad1.isEmpty()) && passed;
		
		ad1.addLast("middle");
		passed = checkSize(2, ad1.size()) && passed;

		ad1.addLast("back");
		passed = checkSize(3, ad1.size()) && passed;

		for(int i=0;i<7;++i)
			ad1.addLast("middle");
		passed = checkSize(10, ad1.size()) && passed;
		//passed = checkSize(16, ad1.items.length) && passed;
		System.out.println("Printing out deque: ");
		ad1.printDeque();
		
		printTestStatus(passed);
		
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		
		ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, ad1.isEmpty());

		ad1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, ad1.isEmpty()) && passed;

		ad1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, ad1.isEmpty()) && passed;
		
		ad1.addLast(20);
		
		// should not be empty 
		passed = (20==ad1.removeLast()) && checkEmpty(true, ad1.isEmpty()) && passed;
		
		//should return 11,12,13
		for(int i=10;i<15;++i)
			ad1.addLast(i);
		ad1.removeLast();
		ad1.removeFirst();
		ad1.printDeque();
		
		printTestStatus(passed);
		
	}

	public static void getTest() {
		System.out.println("Running get test.");
		
		ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
		boolean passed = checkEmpty(true, ad1.isEmpty());
		for(int i=10;i<18;++i)
			ad1.addLast(i);
		passed = checkGet(10,ad1.get(0)) && checkGet(17,ad1.get(7)) && passed;
		printTestStatus(passed);
		
	}
	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		getTest();
	}
} 