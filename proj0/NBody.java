public class NBody {

	public static void main(String[] args) {

		// Get command line args
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];

		// Read in bodies and universe radius from file
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);

		// Set scale of universe
		StdDraw.setScale(-radius, radius);

		// Drawing the background image
		StdDraw.picture(0, 0, "images/starfield.jpg");

		// Drawing bodies in their original position
		for (int i = 0; i < planets.length; i++) {
			planets[i].draw();
		}

		double time = 0;
		while (time < T) {

			// Create arrays for storing net forces of each body
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];

			// Calculate forces for each body and add to the array
			for (int i = 0; i < planets.length; i++) {

				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}	

			// Update bodies
			for (int j = 0; j < planets.length; j++) {

				planets[j].update(dt, xForces[j], yForces[j]);
			}

			// Draw the bodies
			for (int k = 0; k < planets.length; k++) {
				planets[k].draw();
			}

			// Show the drawing
			StdDraw.show();
			StdDraw.pause(10);

			// Increase time
			time += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    			  StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

	}

	public static double readRadius(String filename) {

		In in = new In(filename);

		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();

		return radius;

	}

	public static Planet[] readPlanets(String filename) {

		In in = new In(filename);

		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();

		Planet planet1 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), "images/" + in.readString());
		Planet planet2 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), "images/" + in.readString());
		Planet planet3 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), "images/" + in.readString());
		Planet planet4 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), "images/" + in.readString());
		Planet planet5 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), "images/" + in.readString());		

		Planet[] planets = new Planet[5];
		planets[0] = planet1;
		planets[1] = planet2;
		planets[2] = planet3;
		planets[3] = planet4;
		planets[4] = planet5;

		return planets;

	}
}