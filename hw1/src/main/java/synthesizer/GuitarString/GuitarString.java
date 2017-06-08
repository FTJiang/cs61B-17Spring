
package synthesizer.GuitarString;

import synthesizer.ArrayRingBuffer.*;
import java.util.Iterator;
import java.util.Random;

public class GuitarString implements Iterable<Double>{
	
	private Random random;
	
	private ArrayRingBuffer<Double> buffer;
	/** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
	/*
	public GuitarString(int capacity){
		buffer = new ArrayRingBuffer<Double>(Double.class,capacity);
		random = new Random();
	}*/
	
	public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
		int capacity =  (int)Math.round(SR / frequency);
		buffer = new ArrayRingBuffer<Double>(Double.class,capacity);
		while(!buffer.isFull()){
			buffer.enqueue(0.0);
		}
    }

	/* Pluck the guitar string by replacing the buffer with white noise. */
	/* return double array is just for test purpose */
    public double[] pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
		double[] values = new double[buffer.getCapacity()];
		int i = 0;
		while(!buffer.isEmpty()){
			buffer.dequeue();
		}
		while(!buffer.isFull()){
			double r = Math.random() - 0.5;
			buffer.enqueue(r);
			values[i++] = r;
		}
		return values;
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
		double ave = DECAY*(buffer.dequeue() + buffer.peek())*0.5;
		buffer.enqueue(ave);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
		if(buffer.isEmpty())
			return 0;
        return buffer.peek();
    }
	
	public int getCapacity(){
		return buffer.getCapacity();
	}
	
	// need override iterator method to tell java how to instantiate iterator
	@Override
	public Iterator<Double> iterator(){
		
		return new PosIterator();
	}
	
	private class PosIterator implements Iterator<Double>{
		
		private int position;
		
		public PosIterator(){
			position = buffer.getFirst();
		}
		
		@Override
		public boolean hasNext(){
			if(!buffer.isFull())
				return position!=buffer.getLast();
			return position!=buffer.getCapacity();
		}
		
		@Override
		public Double next(){
			double temp;
			if(position==buffer.getCapacity()){
				position=0;
			}
			temp = buffer.get(position++);
			return temp;	
		}
	}
	

	public void enqueue(Double val){
		buffer.enqueue(val);
	}
	
	public Double dequeue(){
		return buffer.dequeue();
	}
	
	public Double get(int index){
		return buffer.get(index);
	}
	
	public void replace(int index,Double val){
		buffer.replace(index,val);
	}
	
}