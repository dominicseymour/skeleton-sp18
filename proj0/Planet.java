import java.lang.Math;

public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {

		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;

	}

	public Planet(Planet p) {

		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet planet) {

		return Math.sqrt((Math.pow(this.xxPos - planet.xxPos, 2.0) + Math.pow(this.yyPos - planet.yyPos, 2.0)));
	}

	public double calcForceExertedBy(Planet planet) {

		return  ((6.67 * Math.pow(10.0, -11.0)) * this.mass * planet.mass) / (calcDistance(planet) * calcDistance(planet));
	}

	public double calcForceExertedByX(Planet planet) {

		return (calcForceExertedBy(planet) * (planet.xxPos - this.xxPos)) / calcDistance(planet);
	}

	public double calcForceExertedByY(Planet planet) {

		return (calcForceExertedBy(planet) * (planet.yyPos - this.yyPos)) / calcDistance(planet);
	}

	public double calcNetForceExertedByX(Planet[] array) {

		double netForceExertedByX = 0.0;

		for (int i = 0; i < array.length; i++) {

			if (array[i].mass != this.mass) {
				netForceExertedByX += calcForceExertedByX(array[i]);
			}
		}

		return netForceExertedByX;
	}

	public double calcNetForceExertedByY(Planet[] array) {

		double netForceExertedByY = 0.0;

		for (int i = 0; i < array.length; i++) {

			if (!this.equals(array[i])) {
				netForceExertedByY += calcForceExertedByY(array[i]);
			}
		}

		return netForceExertedByY;
	}

	public void update(double seconds, double xForce, double yForce) {

		double accelerationX = xForce / mass;
		double accelerationY = yForce / mass;

		xxVel = xxVel + seconds * accelerationX;
		yyVel = yyVel + seconds * accelerationY;

		xxPos = xxPos + seconds * xxVel;
		yyPos = yyPos + seconds * yyVel;

	}

	public void draw() {

		StdDraw.picture(xxPos, yyPos, imgFileName);
	}

}