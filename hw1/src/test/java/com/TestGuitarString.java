package synthesizer;

/* Since this test is part of a package, we have to import the package version of StdAudio. */
/* Don't worry too much about this, we'll get there in due time. */
import edu.princeton.cs.introcs.StdAudio;

import org.junit.Test;
import static org.junit.Assert.*;
import synthesizer.GuitarString.*;

/** Tests the GuitarString class.
 *  @author Josh Hug
 */

public class TestGuitarString {
    @Test
    public void testPluckTheAString() {
        double CONCERT_A = 440.0;
        GuitarString aString = new GuitarString(CONCERT_A);
        aString.pluck();
        for (int i = 0; i < 50000; i += 1) {
            StdAudio.play(aString.sample());
            aString.tic();
        }
    }


	@Test
	public void testPluck(){
		GuitarString s = new GuitarString(11025.0d);
        double[] values = s.pluck();
		double[] expected = new double[s.getCapacity()];
		int i = 0;
		for(double value:s){
			expected[i++] = value;
		}
		assertArrayEquals(expected,values,0.002);
	}
	
    @Test
    public void testTic() {
        // Create a GuitarString of frequency 11025, which
        // is an ArrayRingBuffer of length 4. 
        GuitarString s = new GuitarString(11025);
        s.pluck();
		
		assertEquals(4,s.getCapacity());

        // Record the front four values, ticcing as we go.
        double s1 = s.sample();
        s.tic();
        double s2 = s.sample();
        s.tic(); 
        double s3 = s.sample();
        s.tic();
        double s4 = s.sample();

        // If we tic once more, it should be equal to 0.996*0.5*(s1 + s2)
        s.tic();

        double s5 = s.sample();
        double expected = 0.996 * 0.5 * (s1 + s2);

        // Check that new sample is correct, using tolerance of 0.001.
        // See JUnit documentation for a description of how tolerances work
        // for assertEquals(double, double)
        assertEquals(expected, s5, 0.001);

    }


/*	
    @Test
	public void PosIteratorTest(){
		
		GuitarString gs = new GuitarString(3);
		gs.enqueue(5.0);
		gs.enqueue(6.0);
		gs.enqueue(7.0);
		double[] expected = {5.0,6.0,7.0};
		double[] actual = new double[3];
		int i=0;
		
		for(double num:gs){
			actual[i++] = num;
		}
		assertArrayEquals(expected,actual,0.002);		
	}
	

	@Test
	public void replaceTest(){
		GuitarString gs = new GuitarString(3);
		gs.enqueue(5.0);
		gs.enqueue(6.1);
		gs.enqueue(7.2);
		gs.replace(0,2.0);
		gs.replace(1,3.5);
		gs.replace(2,4.5);
		double[] expected = {2.0,3.5,4.5};
		double[] actual = new double[3];
		int i = 0;
		for(double num:gs){
			actual[i++] = num;
		}
		assertArrayEquals(expected,actual,0.002);
	}*/
} 
