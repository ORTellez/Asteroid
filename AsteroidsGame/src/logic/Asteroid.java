package logic;

public class Asteroid extends Thread{
	private int x = 0;
	private int y = 0;
	private int size = 0;
	
	public Asteroid(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public Asteroid() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	@Override
	public String toString() {
		return "Asteroid [x=" + x + ", y=" + y + ", size=" + size + "]";
	}

	@Override
	public void run() {
		System.out.println("Asteroid thread started");

		int xIncrement = 1;
		int yIncrement = 1;
		
		while(true){
			
			try {
				Thread.sleep(25); //velocidad del asteroide
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//rebote en paredes
			if (x < 0)
				xIncrement = 1;
			if (x > 450)
				xIncrement = -1;
			if (y < 0)
				yIncrement = 1;
			if (y > 450)
				yIncrement = -1;
			
			x = x + xIncrement;
			y = y + yIncrement;
		}

	}
	
}
