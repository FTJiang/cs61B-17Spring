class LinkedListDeque<Item> {
	/** Node class */
	private class Node{
		public Item item;
		public Node prev;
		public Node next;
		
		public Node(Item i){
			item = i;
			next = prev = null;
		}
	}
	
	/** use circular sentinel topology */
	private Node sentinel;
	private int size;
	
	public LinkedListDeque(){
		sentinel  = new Node(null);
		//prev and next point to itself
		sentinel.next = sentinel.prev = sentinel;
		size = 0;
	}

	
	public void addFirst(Item item){
		/** not involve any looping or recursion **/
		Node newNode = new Node(item);
		newNode.next = sentinel.next;
		newNode.prev = sentinel;
		sentinel.next.prev = newNode;
		sentinel.next = newNode;
		++size;
	}

	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		/** size must take constant time */
		return size;
	}
	
		
 	public void addLast(Item item){
		// not involve any looping or recursion 
		Node newNode = new Node(item);
		newNode.next = sentinel;
		newNode.prev = sentinel.prev;
		sentinel.prev.next = newNode;
		sentinel.prev = newNode;
		++size;
	}
	
	public void printDeque(){
		Node curr = sentinel.next;
		//can not use curr != null, because sentinel is not null
		while(curr != sentinel){  
			System.out.println(curr.item);
			curr = curr.next;
		}
	}
	
	public Item removeFirst(){
		//not involve any looping or recursion 
		Item value = sentinel.next.item;
		if(value != null){
			sentinel.next = sentinel.next.next;
			sentinel.next.prev = sentinel;
			--size;
		}
		return value;
	}
	
	public Item removeLast(){
		// not involve any looping or recursion 
		Item value = sentinel.prev.item;
		if(value != null){
			sentinel.prev = sentinel.prev.prev;
			sentinel.prev.next = sentinel;
			--size;
		}
		return value;		
	}
	
	public Item get(int index){
		//get must use iteration, not recursion 
		if(index > size)
			return null;
		Node curr = sentinel;
		for(int i=0;i<index;++i){
			curr = curr.next;
		}
		return curr;
	}
	
	
}