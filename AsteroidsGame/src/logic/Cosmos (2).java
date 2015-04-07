package logic;

import java.util.Vector;

public class Cosmos {
	private Vector<Asteroid> asteroids = new Vector<Asteroid>();
	
	public Cosmos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vector<Asteroid> getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(Vector<Asteroid> asteroids) {
		this.asteroids = asteroids;
	}

	@Override
	public String toString() {
		return "Cosmos [asteroids=" + asteroids + "]";
	}

}
