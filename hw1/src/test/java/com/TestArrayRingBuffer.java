
import org.junit.*;
import static org.junit.Assert.*;
import synthesizer.ArrayRingBuffer.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

	@Test
	public void isEmptyTest(){
		ArrayRingBuffer arb = new ArrayRingBuffer(Integer.class,10);
		assertEquals(arb.isEmpty(),true);
	}
	
	@Test
	public void peekTest(){
		ArrayRingBuffer arb = new ArrayRingBuffer(Integer.class,10);
		arb.enqueue(5);
		assertEquals(arb.peek(),5);		
	}
	
	@Test(expected = RuntimeException.class) 
	public void enqueueTest(){
		ArrayRingBuffer arb = new ArrayRingBuffer(Integer.class,4);
		arb.enqueue(5);
		assertEquals(5,arb.peek());	
		assertEquals(1,arb.getLast());
		arb.enqueue(4);
		arb.enqueue(3);
		arb.enqueue(2);
		assertEquals(4,arb.get(1));
		assertEquals(3,arb.get(2));
		assertEquals(2,arb.get(3));
		//assertEquals(0,arb.getLast());
		arb.enqueue(5);
	}
	
	@Test(expected = RuntimeException.class) 
	public void dequeueTest(){
		ArrayRingBuffer arb = new ArrayRingBuffer(Integer.class,4);
		arb.enqueue(5);
		arb.enqueue(6);
		arb.enqueue(7);
		arb.enqueue(8);
		assertEquals(5,arb.dequeue());
		assertEquals(6,arb.dequeue());
		assertEquals(7,arb.dequeue());
		assertEquals(8,arb.dequeue());
		assertTrue(arb.isEmpty());
		arb.dequeue();
	}
	

} 
