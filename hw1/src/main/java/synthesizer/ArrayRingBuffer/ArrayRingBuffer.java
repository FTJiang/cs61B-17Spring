// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer.ArrayRingBuffer;

import java.util.Iterator;
import java.lang.reflect.Array;

import synthesizer.AbstractBoundedQueue.*;


//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(Class<T> type,int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

		this.capacity = capacity;
		
		//point to first full position
		this.first = 0;
		
		//last point to next empty position 
		this.last = 0;
		
		this.rb = (T[]) Array.newInstance(type,capacity);
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
	@Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
		
		if(isFull())
			throw new RuntimeException("Ring buffer overflow");
		else{
			rb[last++] = x;
			++fillCount;
			if(last == capacity)
				last = 0;
			
		}
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update 
		T temp = null;
		if(isEmpty())
			throw new RuntimeException("Ring buffer underflow");
		else{
		
			temp = rb[first++];
			--fillCount;
			if(first == capacity)
				first = 0;	
		}
		return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
		return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
	
	//replace item at position index with given value
	public void replace(int index,T value){
		rb[index] = value;
	}
	
	//help function for guitarstring to get item by index
	public T get(int index){		
		return rb[index];	
	}
	
	//get first
	public int getFirst(){
		return first;
	}
	
	//get last
	public int getLast(){
		return last;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
}
