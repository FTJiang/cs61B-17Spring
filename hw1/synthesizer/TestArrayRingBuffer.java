
import org.junit.*;
import static org.junit.Assert.*;
import ArrayRingBuffer.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
	private ArrayRingBuffer arb;
	
	@BeforeClass
	public static void setup(){
		ArrayRingBuffer arb = new ArrayRingBuffer(10);
	}
	
	@Test
	public void isEmptyTest(){
		assertEquals(arb.isEmpty(),true);
	}
	
	@Test
	public void enqueueTest(){
		
	}
	
	@Test
	public void dequeueTest(){
		
	}
	
	@Test
	public void capacityTest(){

	}
	
	@Test
	public void fillCountTest(){
		
	}
	
	
	@Test
	public void isFullTest(){
		
	}
	
	@Test
	public void peekTest(){
		
	}
	
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
