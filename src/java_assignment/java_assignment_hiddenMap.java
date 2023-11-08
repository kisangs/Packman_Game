package java_assignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class java_assignment_hiddenMap extends JFrame implements KeyListener {
	JLabel yball = new JLabel(new ImageIcon("imgage/characterleft1"));
	public java_assignment_hiddenMap() {
		final JFrame frame = new JFrame();
		final ImageIcon black = new ImageIcon("image/black.png"); //검은 배경 이미지
		final ImageIcon dotpoint = new ImageIcon("image/point.png");
		final ImageIcon wall = new ImageIcon("image/wall.png"); //벽 이미지
		final ImageIcon enemy1 = new ImageIcon("image/enemy1.jpg"); //퀴즈 내는 몬스터
		final ImageIcon characterup1 = new ImageIcon("image/characterup1.png"); //캐릭터 위에 입벌리고 있는 이미지
		final ImageIcon characterup2 = new ImageIcon("image/characterup2.png"); //캐릭터 위에 입닫고 있는 이미지
		final ImageIcon characterright1 = new ImageIcon("image/characterright1.png"); //캐릭터 오른쪽 입벌리고 있는 이미지
		final ImageIcon characterright2 = new ImageIcon("image/characterright2.png"); //캐릭터 오른쪽 입닫고 있는 이미지
		final ImageIcon characterleft1 = new ImageIcon("image/characterleft1.png"); //캐릭터 왼쪽 입열고 있는 이미지
		final ImageIcon characterleft2 = new ImageIcon("image/characterleft2.png"); //캐릭터 왼쪽 입닫고 있는 이미지
		final ImageIcon characterdown1 = new ImageIcon("image/characterdown1.png"); //캐릭터 아래 입열고 있는 이미지
		final ImageIcon characterdown2 = new ImageIcon("image/characterdown2.png"); //캐릭터 아래 입닫고 있는 이미지
		final ImageIcon hiddmap = new ImageIcon("image/hiddmap_1.png");
		final ImageIcon hiddmap2 = new ImageIcon("image/wall.png");

		addKeyListener(this);
	
	class KListener extends KeyAdapter{
	@Override
	public void keyPressed(KeyEvent e) {
		int X = yball.getX();
		int Y = yball.getY();
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			System.out.printf("(%d,%d)\n",X,Y);
			if(!(yball.getIcon()).equals(characterright1)){
				yball.setIcon(characterright1);
				if(yball.getX() < 560) {
					yball.setLocation(yball.getX()+15, yball.getY());
				}
			}
			else {
				yball.setIcon(characterright2);
				if(yball.getX() < 560) {
					yball.setLocation(yball.getX()+15, yball.getY());
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			System.out.printf("(%d,%d)\n",X,Y);
			if(!(yball.getIcon()).equals(characterleft1)){
				yball.setIcon(characterleft1);
				if(yball.getX() > 0) {
					yball.setLocation(yball.getX()-15, yball.getY());
				}
			}
			else {
				yball.setIcon(characterleft2);
				if(yball.getX() > 0) {
					yball.setLocation(yball.getX()-15, yball.getY());
				}
			}
			break;
		case KeyEvent.VK_UP:
			System.out.printf("(%d,%d)\n",X,Y);
			if(!(yball.getIcon()).equals(characterup1)){
				yball.setIcon(characterup1);
				if(yball.getY() > 10) {
					yball.setLocation(yball.getX(), yball.getY()-15);
				}
			}
			else {
				yball.setIcon(characterup2);
				if(yball.getY() > 10) {
					yball.setLocation(yball.getX(), yball.getY()-15);
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			System.out.printf("(%d,%d)\n",X,Y);
			if(!(yball.getIcon()).equals(characterdown1)){
				yball.setIcon(characterdown1);
				if(yball.getY() < 530) {
					yball.setLocation(yball.getX(), yball.getY()+15);
				}
			}
			else {
				yball.setIcon(characterdown2);
				if(yball.getY() < 530) {
					yball.setLocation(yball.getX(), yball.getY()+15);
				}
			}
			break;
			
		case KeyEvent.VK_CONTROL:
				if(yball.getX() == 569 && (yball.getY()>=380 && yball.getY()<=470)) {
				new java_assignment_hiddenMap();
				frame.setVisible(false);
				}
				if(yball.getX() == -1 && (yball.getY()>=380 && yball.getY()<=470)) {
					new java_assignment_hiddenMap2();
					frame.setVisible(false);
					}
			break;
			
			}
		}
	}
	
		
	
	KListener listener = new KListener();
	
	
	
	JPanel panel = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(hiddmap.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};

	
	frame.requestFocus();
	frame.addKeyListener(new KListener());
	frame.add(panel);
	panel.add(yball);

	yball.setLocation(300, 300);
	frame.setVisible(true);
	frame.setTitle("히든맵:OX퀴즈!");
	frame.setSize(615,640);
//	if(yball.getX()==569 || yball.getY() == 425) {
//		yball.setIcon(wall);
//	}
	
		}
		
		public static void main(String[] args) {
			new java_assignment_hiddenMap();
		}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	
}
