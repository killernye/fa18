public class NBody {

	/** Returns an array of N planets. */
	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		in.readDouble();

		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; i += 1) {
			double pX = in.readDouble();
			double pY = in.readDouble();
			double vX = in.readDouble();
			double vY = in.readDouble();
			double ms = in.readDouble();
			String fN = in.readString();
			Planet p = new Planet(pX, pY, vX, vY, ms, fN);
			planets[i] = p;
		}

		return planets;
	}

	/** Read the radius of the universe in a givenfile.
	*	@param fileName Name of the given file
	*/
	public static double readRadius(String filename) {
		In in = new In(filename);

		// Read the first value N represents the number of planets
		in.readInt();

		return in.readDouble();
	}

	/** Drawing background.
	*	The default coordinate scale is the unit square
	*/
	public static void drawBackground() {


	}

	public static void main(String[] args) {
		// Collecting All Needed Input
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		double time = 0;
		int planetNum = planets.length;
		double[] xForces = new double[planetNum];
		double[] yForces = new double[planetNum];

		StdDraw.enableDoubleBuffering();
		

		while (time < T) {

			// Calculate the net x and y forces for each planet
			for (int i = 0; i < planetNum; i += 1) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			// update on each of the planets
			for (int i = 0; i < planetNum; i += 1) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();

			// Draw the background
			String backgroundToDraw = "./images/starfield.jpg";
			StdDraw.setScale(-radius, radius);
			StdDraw.picture(0, 0, backgroundToDraw);
			
			// Draw all of the planets
			for (Planet p : planets) {
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

			time += dt;
		}
	}
}