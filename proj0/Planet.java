public class Planet {
	static final double G = 6.67e-11;
	double xxPos;  // Current x Position
	double yyPos;
	double xxVel;  // Current velocity in the x direction
	double yyVel;
	double mass;
	String imgFileName;

	/** Constructor 1. */
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Constructor 2: make an identical Planet object. */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass  = p.mass;
		imgFileName = p.imgFileName;
	}

	/** Updata the planet's position and velocity instance variables
	*	@param dt A small period of time during which the given forces
	*	exerted on the planet
	*	@param fX The force exerted in the X direction
	*	@param fY The force exerted in the Y direction
	*/
	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += dt * aX;
		yyVel += dt * aY;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

	/** Calculates the force exerted by all planets in a given array
	* 	upon the current Planet in the X direction.
	*	@param planets A given array of planets
	*/
	public double calcNetForceExertedByX(Planet[] planets) {
		double netForce = 0;
		for (Planet p: planets) {
			if (!this.equals(p)) {
				netForce += calcForceExertedByX(p);
			}
		}
		return netForce;
	}

	/** The same thing as the above method only in the Y direction. */
	public double calcNetForceExertedByY(Planet[] planets) {
		double netForce = 0;
		for (Planet p: planets) {
			if (!this.equals(p)) {
				netForce += calcForceExertedByY(p);
			}
		}
		return netForce;
	}

	/** Calculates the force exerted on this planet by the given planet
	* 	in the X direction.
	*	@param p A given Planet
	*/
	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		return force * dx / r;
	}

	/** Calculates the force exerted on this planet by the given planet
	*	in the Y direction.
	* 	@param p A given Planet
	*/
	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		return force * dy / r;
	}

	/** Calculates the force exerted on this planet by the given planet.
	*	@param p a given planet
	*/
	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		return (G * mass * p.mass) / (r * r);
	}

	/** Calculates the distance between two Planets.
	*	@param p target Planet
	*	@return distance between p and this Planet
	*/
	public double calcDistance(Planet p) {
		double dx = xxPos - p.xxPos;
		double dy = yyPos - p.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

}