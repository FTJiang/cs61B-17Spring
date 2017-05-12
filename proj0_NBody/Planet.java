
public class Planet {
	/** private field of class */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	/** construct new planet */
	public Planet(double xP, double yP, double xV,
            double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	/** construct object by object */
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
		
	}
	
	/** calculate distance between rocinante and this planet */
	public double calcDistance(Planet rocinante){
		double x = this.xxPos - rocinante.xxPos;
		double y = this.yyPos - rocinante.yyPos;
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	}
	
	/** calculate net force of two direction */
	public double calcForceExertedBy(Planet rocinante){
		double r = this.calcDistance(rocinante);
		return 6.67e-11d * this.mass * rocinante.mass /Math.pow(r,2);
	}
	
	/** calculate force in X direction */
	public double calcForceExertedByX(Planet rocinante){
		double r = this.calcDistance(rocinante);
		double dx = rocinante.xxPos - this.xxPos;
		double F1 = calcForceExertedBy(rocinante);
		return F1 * dx / r;
	}
	
	/** calculate force in Y direction */
	public double calcForceExertedByY(Planet rocinante){
		double r = this.calcDistance(rocinante);
		double dy = rocinante.yyPos - this.yyPos;
		double F1 = calcForceExertedBy(rocinante);
		return F1 * dy / r;
	}
	
	/** calculate net force in X direction */
	public double calcNetForceExertedByX(Planet[] Planets){
		double Fx = 0.0;
		for(int i=0; i< Planets.length;++i){
			if(Planets[i] != this)
				Fx += this.calcForceExertedByX(Planets[i]);
		}
		return Fx;
	}
	
	/** calculate net force in Y direction */
	public double calcNetForceExertedByY(Planet[] Planets){
		double Fy = 0.0;
		for(int i=0; i< Planets.length;++i){
			if(Planets[i] != this)
				Fy += this.calcForceExertedByY(Planets[i]);
		}
		return Fy;
	}	
	
	/** update velocity and position */
	public void update(double dt, double Fx, double Fy){
		double ax = Fx / mass;
		double ay = Fy / mass;
		this.xxVel += dt*ax;
		this.yyVel += dt*ay;
		this.xxPos += dt*xxVel;
		this.yyPos += dt*yyVel;
	}
	
	/** draw planets on pictures */
	public void draw(){
		String planetImg = "images/"+this.imgFileName;
		//when x=1, it will be right most, y=1 it will at top
		StdDraw.picture(this.xxPos / 2.50e+11 + 0.5, this.yyPos / 2.50e+11 + 0.5, planetImg);
	}
	
}

