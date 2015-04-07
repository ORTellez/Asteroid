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
		int size = 0;
		
		while (true) {
			try {
				Thread.sleep(100);
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
			}
		}
	}


}
