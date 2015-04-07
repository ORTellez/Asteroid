package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import logic.Asteroid;
import logic.Cosmos;
import logic.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.ServerSocket;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AsteroidsApplication {
	private Cosmos myCosmos = null;
	private Random myRandom = new Random();
	private PaintThread myPaintThread = null;
	private Player myPlayer=null;

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JToolBar toolBar;
	private JPanel panel;
	private JButton btnStartCosmos;
	private JButton btnAddAsteroids;
	private JButton btnPaintPanel;
	private JButton btnStartPaintthread;
	private JButton btnPlay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsteroidsApplication window = new AsteroidsApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AsteroidsApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnStartCosmos = new JButton("Start Cosmos");
		btnStartCosmos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCosmos = new Cosmos();
				System.out.println(myCosmos);
			}
		});
		toolBar.add(btnStartCosmos);
		
		btnAddAsteroids = new JButton("Add Asteroids");
		btnAddAsteroids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Asteroid myAsteroid = new Asteroid(myRandom.nextInt(450),myRandom.nextInt(450),myRandom.nextInt(50)); 
				myAsteroid.start();
				myCosmos.getAsteroids().add(myAsteroid);
				System.out.println(myCosmos);
			}
		});
		toolBar.add(btnAddAsteroids);
		
		btnPaintPanel = new JButton("Paint Panel");
		btnPaintPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				int y = 0;
				for(int i = 0; i<myCosmos.getAsteroids().size();i++){
					x = myCosmos.getAsteroids().get(i).getX();
					y = myCosmos.getAsteroids().get(i).getY();
					
					panel.getGraphics().drawOval(x, y, 10, 10);
				}
			}
		});
		
		btnPlay = new JButton("Add player");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPlayer=new Player(myRandom.nextInt(450),myRandom.nextInt(450));
				myPlayer.start();
				myCosmos.setMyPlayer(myPlayer);
				System.out.println(myCosmos);
			}
		});
		toolBar.add(btnPlay);
		toolBar.add(btnPaintPanel);
		btnPlay.setFocusable(false);
		
		btnStartPaintthread = new JButton("Start PaintThread");
		btnStartPaintthread.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyDown) {
				if(keyDown.getKeyCode() == KeyEvent.VK_UP)
				{
					myPlayer.setY(myPlayer.getY() - 2);
				}
				else if(keyDown.getKeyCode() == KeyEvent.VK_DOWN)
				{
					myPlayer.setY(myPlayer.getY() + 2);
				}
				else if(keyDown.getKeyCode() == KeyEvent.VK_LEFT)
				{
					myPlayer.setX(myPlayer.getX() - 2);
				}
				else if(keyDown.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					myPlayer.setX(myPlayer.getX() + 2);
				}
			}
		});
		btnStartPaintthread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPaintThread = new PaintThread(panel, myCosmos);
				myPaintThread.start();
				toolBar.setEnabled(false);
			}
		});
		toolBar.add(btnStartPaintthread);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setFocusable(true);
	}

}
