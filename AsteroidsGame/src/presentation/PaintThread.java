package presentation;

import javax.swing.JPanel;

import logic.Cosmos;

public class PaintThread extends Thread{
	private JPanel panel = null;
	private Cosmos myCosmos = null;

	public PaintThread(JPanel panel, Cosmos myCosmos) {
		super();
		this.panel = panel;
		this.myCosmos = myCosmos;
	}
	
	@Override
	public void run() {
		System.out.println("PainThread started");
		int x = 0;
		int y = 0;
		int xp = 0;
		int yp = 0;
		int size = 0;
		
		boolean dead = true;
		while (dead) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			panel.getGraphics().clearRect(0, 0, 500, 500);
			
			for (int i = 0; i < myCosmos.getAsteroids().size(); i++) {
				x = myCosmos.getAsteroids().get(i).getX();
				y = myCosmos.getAsteroids().get(i).getY();
				size = myCosmos.getAsteroids().get(i).getSize();
				
				panel.getGraphics().drawOval(x, y, size, size);
				
				if ((xp >= x && xp <= x+size) && (yp >= y && yp <= y+size))
				{
					dead = false;
					
					System.out.println("GAME OVER!");
				}
				
			}
			xp=myCosmos.getMyPlayer().getX();
			yp=myCosmos.getMyPlayer().getY();
			int xPoints[] = {xp, xp-10, xp, xp+10};
			int yPoints[] = {yp, yp+20, yp+13, yp+20};
			panel.getGraphics().drawPolygon(xPoints, yPoints, 4);
		}
	}
}
