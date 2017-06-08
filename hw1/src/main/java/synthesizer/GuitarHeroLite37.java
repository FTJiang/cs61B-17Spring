
import synthesizer.GuitarString.*;
import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;
import java.util.HashMap;
import java.util.Map;


/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHeroLite37 {
	private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
		Map<Character,GuitarString> map = new HashMap<>();
		for(int i=0;i<37;++i){
			map.put(keyboard.charAt(i),new GuitarString(440*Math.pow(2,(0 - 24) / 12)));
		}
	   

        while (true) {

			try{
				/* check if the user has typed a key; if so, process it */
				if (StdDraw.hasNextKeyTyped()) {
					char key = StdDraw.nextKeyTyped();
						GuitarString temp = map.get(key);
						temp.pluck();
					
				}
				double sample = 0.0;
				for(GuitarString string:map.values()){
					sample += string.sample();
					string.tic();
				}
				
				StdAudio.play(sample);
			}catch(Exception error){
				;
			}

        }
    }
}

