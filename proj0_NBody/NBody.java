import java.util.Scanner;
public class NBody {
	
	public static double readRadius(String FileName){
		In in = new In(FileName);
		in.readInt();
		/* Keep looking until the file is empty. */
		if(!in.isEmpty()) 
			return in.readDouble();	
		return 0;
	}
	
	public static Planet[] readPlanets(String FileName){
		In in = new In(FileName);
		int num_planets = in.readInt();
		in.readDouble();
		Planet[] Planets = new Planet[5];
		/* Keep looking until the file is empty. */
		for(int i=0;i<5;++i){
			Planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
				in.readDouble(),in.readDouble(),in.readString());
		}
		return Planets;
	}	
	
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		/** read all planets */
		Planet[] Planets = NBody.readPlanets(filename);
		String bkImg = "images/starfield.jpg";
		double radius = NBody.readRadius(filename);
		double size = 2;
		StdDraw.clear();
		StdDraw.picture(0, 0, bkImg,size,size);
		/** Increase your time variable by dt */
		for(double time=0;time<T;time+=dt){
			double[] xForce = new double[5];
			double[] yForce = new double[5];
			/** calculate net forces of each planet*/
			for (int i=0;i<5;++i){
				xForce[i] = Planets[i].calcNetForceExertedByX(Planets);
				yForce[i] = Planets[i].calcNetForceExertedByY(Planets);
			}
			/** update velocity and position of planets */
			for (int i=0;i<5;++i){
				Planets[i].update(dt,xForce[i],yForce[i]);
			}
			//update drawing
			StdDraw.picture(0, 0, bkImg,size,size);
			for(Planet planet : Planets)
				planet.draw();
			/** Pause the animation for 10 milliseconds */
			StdDraw.show(10);
		}
	}

}
