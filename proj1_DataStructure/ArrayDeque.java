class ArrayDeque<Item> {
	/** use circular sentinel topology */
	
	private Item[] items;
	private int front; //point to first element
	private int rear;  //point to last element
	private int N;
	
	public ArrayDeque(){
		N = 8;
		items = (Item[]) new Object[N];
		front = 4;
		rear = 5;
	}
	
	public void resize(int capacity){
		if(capacity < N){
			/** want to shrink size of array */
			float R = size()/capacity;//usage ratio
			while(R < 0.25){
				capacity = capacity>>1;
				R = size()/capacity;
			}
		}
		/** move elements from front through end to new array */
		Item[] a = (Item[]) new Object[capacity];
		int i = capacity>>1;
		int s = size();
		front++;
		while(s > 0){
			--s;
			a[i++] = items[front++];
			if(front == N)
				front = 0;
		}
		front = (capacity>>1)-1;
		rear = i;
		items = a;
		N = capacity;
	}
	
	public void addFirst(Item item){
		/**  take constant time **/
		int s = size();
		if(s == N-1)
			resize(2*N);
		items[front--] = item;
		if(front == -1)
			//point front to last element
			front = N - 1;
	}
	
	public void addLast(Item item){
		/** take constant time **/
		int s = size();
		if(s == N-1)
			resize(2*N);
		items[rear++] = item;
		if(rear == N)
			rear = 0;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public int size(){
		/** take constant time, (N - fron + rear)%N */
		return (N - front + rear - 1) % N;
	}
	
	public void printDeque(){
		int i = front+1;
		int s = size();
		while(s > 0){
			--s;
			System.out.println(items[i++]);
			if(i == N)
				i = 0;
		}
	}
	
	public Item removeFirst(){
		// take constant time, front++
		Item value = items[front+1];
		//nullify first item
		items[front+1] = null;
		if(++front == N-1)
			front = 0;
		return value;
	}
	
	public Item removeLast(){
		// take constant time, rear--
		Item value = items[rear-1];
		//nullify last item
		items[rear-1] = null;
		if(--rear == 0)
			rear = N;	
		return value;
	}
	
	//get real index of items
	private int real_index(int index){
		int real_index = front + 1 + index ;
		if(real_index >= N)
			real_index = index - (N - front - 1);
		return real_index;
	}
	
	public Item get(int index){
		// take constant time 
		return items[real_index(index)];
	}
	
}