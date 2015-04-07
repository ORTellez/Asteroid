package logic;

import java.util.Scanner;

public class Player extends Thread{
	private int x = 0;
	private int y = 0;
	
	public Player(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Player [x=" + x + ", y=" + y + "]";
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
	@Override
	public void run() {
		
//		Scanner myKey=new Scanner(System.in);
//		String key="";
		System.out.println("Player thread started");
		
		while(true){
			
			try {
				Thread.sleep(200); //velocidad del asteroide
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//key=myKey.nextLine();
		}
	}
	
}