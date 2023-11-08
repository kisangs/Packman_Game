package java_assignment;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class java_assignment_game2 {
	
	private static Random random, random2, random3;
	private static int ch, cw, e1h, e1w, dot, locate, em1, em2, em3, point, e2w, e2h, e3w, e3h, locate2, locate3;
	private static Icon enemyup, enemydown, enemyleft, enemyright, enemylocate;
	private static Icon enemyup2, enemydown2, enemyleft2, enemyright2, enemylocate2;
	private static Icon enemyup3, enemydown3, enemyleft3, enemyright3, enemylocate3;
	private static int gamecount, ch2, cw2, seat1, seat2, seat3, seat4, seat5, life2;
	
	public java_assignment_game2() {
		final JFrame frame = new JFrame();
		final ImageIcon life = new ImageIcon("image/life.png");
		final ImageIcon dotpoint = new ImageIcon("image/point.png");
		final ImageIcon wall = new ImageIcon("image/wall.png");
		final ImageIcon enemy1 = new ImageIcon("image/enemy1.jpg");
		final ImageIcon enemy2 = new ImageIcon("image/enemy2.jpg");
		final ImageIcon enemy3 = new ImageIcon("image/enemy3.jpg");
		final ImageIcon characterup1 = new ImageIcon("image/characterup1.png");
		final ImageIcon characterup2 = new ImageIcon("image/characterup2.png");
		final ImageIcon characterright1 = new ImageIcon("image/characterright1.png");
		final ImageIcon characterright2 = new ImageIcon("image/characterright2.png");
		final ImageIcon characterleft1 = new ImageIcon("image/characterleft1.png");
		final ImageIcon characterleft2 = new ImageIcon("image/characterleft2.png");
		final ImageIcon characterdown1 = new ImageIcon("image/characterdown1.png");
		final ImageIcon characterdown2 = new ImageIcon("image/characterdown2.png");
		final ImageIcon score1 = new ImageIcon("image/score1.png"); //점수판의 "점" 글씨 이미지
		final ImageIcon score2 = new ImageIcon("image/score2.png"); //점수판의 "수" 글씨 이미지
		final ImageIcon one = new ImageIcon("image/1.png"); //점수판 "1" 이미지
		final ImageIcon two = new ImageIcon("image/2.png"); //점수판 "2" 이미지
		final ImageIcon three = new ImageIcon("image/3.png"); //점수판 "3" 이미지
		final ImageIcon four = new ImageIcon("image/4.png"); //점수판 "4" 이미지
		final ImageIcon five = new ImageIcon("image/5.png"); //점수판 "5" 이미지
		final ImageIcon six = new ImageIcon("image/6.png"); //점수판 "6" 이미지
		final ImageIcon seven = new ImageIcon("image/7.png"); //점수판 "7" 이미지
		final ImageIcon eight = new ImageIcon("image/8.png"); //점수판 "8" 이미지
		final ImageIcon nine = new ImageIcon("image/9.png"); //점수판 "9" 이미지
		final ImageIcon zero = new ImageIcon("image/0.png"); //점수판 "0" 이미지
		final ImageIcon black = new ImageIcon("image/black.png"); //검은 배경 이미지
		final ImageIcon S = new ImageIcon("image/s.png");
		final ImageIcon T = new ImageIcon("image/t.png");
		final ImageIcon A = new ImageIcon("image/a.png");
		final ImageIcon G = new ImageIcon("image/g.png");
		final ImageIcon E = new ImageIcon("image/e.png");
		final ImageIcon stage1 = new ImageIcon("image/stage1.png");
		final ImageIcon stage2 = new ImageIcon("image/stage2.png");
		final ImageIcon stage3 = new ImageIcon("image/stage3.png");

		final JDialog dialog = new JDialog();
		final JTextField pwd = new JTextField(10);
		final JTextField name = new JTextField(10);
		final JLabel score = new JLabel();
		final JLabel name1 = new JLabel("로그인 후 당신의 점수를 업데이트하시기 바랍니다");
		final JLabel id = new JLabel("아이디:");
		final JLabel pass = new JLabel("비밀번호:");
		final JButton submit = new JButton("*점수업데이트*");
		final JButton clogin = new JButton("*로그인 확인*");
		
		random = new Random();
		random2 = new Random();
		random3 = new Random();

		dialog.setSize(400, 200);
		dialog.setVisible(false);
		dialog.setLayout(new FlowLayout());
		dialog.add(id);
		dialog.add(name);
		dialog.add(pass);
		dialog.add(pwd);
		dialog.add(score);
		dialog.add(name1);
		dialog.add(clogin);
		dialog.add(submit);
		
		ch=17;  cw=9; 
		e1h=10;  e1w=9; 
		e2h=8;  e2w=9;
		e3h=6;  e3w=9;
		dot=180; point=0;
		em1=3; em2=1; em3=1;
		enemylocate=black; enemylocate2=black; enemylocate3=black;
		life2=4; gamecount=0;


		final JLabel[][] map = new JLabel[21][20];

		for (int i=0; i<21; i++) {
			for(int j=0; j<20; j++) {
				map[i][j] = new JLabel();
			}
		}


		class enemymove1 implements ActionListener { 
			public void actionPerformed(ActionEvent event)
			{
				if(em1<=0) locate = 1+random.nextInt(4);
				else { locate = 1; em1--; }
					switch(locate) {
						case 1:
							if(!(map[e1h-1][e1w].getIcon()).equals(wall)) {
								if(!(map[e1h-1][e1w].getIcon()).equals(enemy2)) {
									if(!(map[e1h-1][e1w].getIcon()).equals(enemy3)) {
										if(!(map[e1h-1][e1w].getIcon()).equals(S)) {
											if(!(map[e1h-1][e1w].getIcon()).equals(T)) {
												if(!(map[e1h-1][e1w].getIcon()).equals(A)) {
													if(!(map[e1h-1][e1w].getIcon()).equals(G)) {
														if(!(map[e1h-1][e1w].getIcon()).equals(E)) {
															if(!(map[e1h-1][e1w].getIcon()).equals(stage1)) {
																if(!(map[e1h-1][e1w].getIcon()).equals(stage2)) {
																	if(!(map[e1h-1][e1w].getIcon()).equals(stage3))
										enemyup=map[e1h-1][e1w].getIcon();
										map[e1h-1][e1w].setIcon(enemy1);
										map[e1h][e1w].setIcon(enemylocate);
										enemylocate=enemyup;
										e1h--;
									}}}}}}}}}}
							break;
						case 2:
							if(!(map[e1h+1][e1w].getIcon()).equals(wall)) {
								if(!(map[e1h+1][e1w].getIcon()).equals(enemy2)) {
									if(!(map[e1h+1][e1w].getIcon()).equals(enemy3)) {
										enemydown=map[e1h+1][e1w].getIcon();
										map[e1h+1][e1w].setIcon(enemy1);
										map[e1h][e1w].setIcon(enemylocate);
										enemylocate=enemydown;
										e1h++;
									}}}
							break;
						case 3:
							if(!(map[e1h][e1w-1].getIcon()).equals(wall)) {
								if(!(map[e1h][e1w-1].getIcon()).equals(enemy2)) {
									if(!(map[e1h][e1w-1].getIcon()).equals(enemy3)) {
										enemyleft=map[e1h][e1w-1].getIcon();
										map[e1h][e1w-1].setIcon(enemy1);
									map[e1h][e1w].setIcon(enemylocate);
									enemylocate=enemyleft;
									e1w--;
									}}}
							break;
						case 4:
							if(!(map[e1h][e1w+1].getIcon()).equals(wall)) {
								if(!(map[e1h][e1w+1].getIcon()).equals(enemy2)) {
									if(!(map[e1h][e1w+1].getIcon()).equals(enemy3)) {
									enemyright=map[e1h][e1w+1].getIcon();
									map[e1h][e1w+1].setIcon(enemy1);
									map[e1h][e1w].setIcon(enemylocate);
									enemylocate=enemyright;
									e1w++;
									}}}
							break;
					}
					if(e1h==ch && e1w==cw) {
						ch2 = ch; cw2 = cw;
						ch = 17; cw = 9;
						map[ch][cw].setIcon(characterup1);    
						life2 = life2 - 1;
						
						if(!(map[e1h][e1w].getIcon()).equals(dotpoint)) {
							enemylocate=black;}
						else {enemylocate=dotpoint;}
						map[ch2][cw2].setIcon(black);
						
						switch(life2){ 
							    case 0: {for(int i=0; i<20; i++) {
										for(int j=0; j<20; j++) {
											map[i][j].setIcon(wall);
										}
									score.setText("포인트:"+point);
									dialog.setVisible(true);}}  

							    case 1: { map[20][0].setIcon(black);}
							    break;

							    case 2:{ map[20][1].setIcon(black);}
							    break;
							    
							    case 3:{ map[20][2].setIcon(black);}
							    break;

			}
						}

				if(e1h==7 && e1w==9) { map[8][9].setIcon(wall); }
			}
		}
		
		final enemymove1 enemymove1 = new enemymove1();
		Timer enemymo1 = new Timer(100, enemymove1);
		enemymo1.start();
		
		
		class enemymove2 implements ActionListener { 
			public void actionPerformed(ActionEvent event)
			{
				if(em2<=0) locate2 = 1+random2.nextInt(4);
				else { locate2 = 1; em2--; }
					switch(locate2) {
						case 1:
							if(!(map[e2h-1][e2w].getIcon()).equals(wall)) {
								if(!(map[e2h-1][e2w].getIcon()).equals(enemy1)) {
									if(!(map[e2h-1][e2w].getIcon()).equals(enemy3)) {
										if(!(map[e2h-1][e2w].getIcon()).equals(S)) {
											if(!(map[e2h-1][e2w].getIcon()).equals(T)) {
												if(!(map[e2h-1][e2w].getIcon()).equals(A)) {
													if(!(map[e2h-1][e2w].getIcon()).equals(G)) {
														if(!(map[e2h-1][e2w].getIcon()).equals(E)) {
															if(!(map[e2h-1][e2w].getIcon()).equals(stage1)) {
																if(!(map[e2h-1][e2w].getIcon()).equals(stage2)) {
																	if(!(map[e2h-1][e2w].getIcon()).equals(stage3))
										enemyup2=map[e2h-1][e2w].getIcon();
										map[e2h-1][e2w].setIcon(enemy2);
										map[e2h][e2w].setIcon(enemylocate2);
									enemylocate2=enemyup2;
									e2h--;
									}}}}}}}}}}
							break;
						case 2:
							if(!(map[e2h+1][e2w].getIcon()).equals(wall)) {
								if(!(map[e2h+1][e2w].getIcon()).equals(enemy1)) {
									if(!(map[e2h+1][e2w].getIcon()).equals(enemy3)) {
										enemydown2=map[e2h+1][e2w].getIcon();
										map[e2h+1][e2w].setIcon(enemy2);
										map[e2h][e2w].setIcon(enemylocate2);
										enemylocate2=enemydown2;
										e2h++;
									}}}
							break;
						case 3:
							if(!(map[e2h][e2w-1].getIcon()).equals(wall)) {
								if(!(map[e2h][e2w-1].getIcon()).equals(enemy1)) {
									if(!(map[e2h][e2w-1].getIcon()).equals(enemy3)) {
										enemyleft2=map[e2h][e2w-1].getIcon();
										map[e2h][e2w-1].setIcon(enemy2);
										map[e2h][e2w].setIcon(enemylocate2);
										enemylocate2=enemyleft2;
										e2w--;
									}}}
							break;
						case 4:
							if(!(map[e2h][e2w+1].getIcon()).equals(wall)) {
								if(!(map[e2h][e2w+1].getIcon()).equals(enemy1)) {
									if(!(map[e2h][e2w+1].getIcon()).equals(enemy3)) {
										enemyright2=map[e2h][e2w+1].getIcon();
										map[e2h][e2w+1].setIcon(enemy2);
										map[e2h][e2w].setIcon(enemylocate2);
										enemylocate2=enemyright2;
										e2w++;
									}}}
							break;
					}
					if(e2h==ch && e2w==cw) {
						ch2 = ch; cw2 = cw;
						ch = 17; cw = 9;
						map[ch][cw].setIcon(characterup1);    
						life2 = life2 - 1;
						
						if(!(map[e2h][e2w].getIcon()).equals(dotpoint)) {
							enemylocate2=black;}
						else {enemylocate2=dotpoint;}
						map[ch2][cw2].setIcon(black);
						
						switch(life2){ 
							    case 0: {for(int i=0; i<20; i++) {
										for(int j=0; j<20; j++) {
											map[i][j].setIcon(wall);
										}
									score.setText("포인트:"+point);
									dialog.setVisible(true);}}  

							    case 1: { map[20][0].setIcon(black);}
							    break;

							    case 2:{ map[20][1].setIcon(black);}
							    break;
							    
							    case 3:{ map[20][2].setIcon(black);}
							    break;

			}
						}
			}
		}
		
		
		final enemymove2 enemymove2 = new enemymove2();
		Timer enemymo2 = new Timer(100, enemymove2);
		enemymo2.start();
		
		class enemymove3 implements ActionListener { 
			public void actionPerformed(ActionEvent event)
			{
				if(em3<=0) locate3 = 1+random3.nextInt(4);
				else { locate3 = 1; em3--; }
					switch(locate3) {
						case 1:
							if(!(map[e3h-1][e3w].getIcon()).equals(wall)) {
								if(!(map[e3h-1][e3w].getIcon()).equals(enemy1)) {
									if(!(map[e3h-1][e3w].getIcon()).equals(enemy2)) {
										if(!(map[e3h-1][e3w].getIcon()).equals(S)) {
											if(!(map[e3h-1][e3w].getIcon()).equals(T)) {
												if(!(map[e3h-1][e3w].getIcon()).equals(A)) {
													if(!(map[e3h-1][e3w].getIcon()).equals(G)) {
														if(!(map[e3h-1][e3w].getIcon()).equals(E)) {
															if(!(map[e3h-1][e3w].getIcon()).equals(stage1)) {
																if(!(map[e3h-1][e3w].getIcon()).equals(stage2)) {
																	if(!(map[e3h-1][e3w].getIcon()).equals(stage3))
										enemyup3=map[e3h-1][e3w].getIcon();
										map[e3h-1][e3w].setIcon(enemy3);
										map[e3h][e3w].setIcon(enemylocate3);
										enemylocate3=enemyup3;
										e3h--;
									}}}}}}}}}}
							break;
						case 2:
							if(!(map[e3h+1][e3w].getIcon()).equals(wall)) {
								if(!(map[e3h+1][e3w].getIcon()).equals(enemy1)) {
									if(!(map[e3h+1][e3w].getIcon()).equals(enemy2)) {
										enemydown3=map[e3h+1][e3w].getIcon();
										map[e3h+1][e3w].setIcon(enemy3);
										map[e3h][e3w].setIcon(enemylocate3);
										enemylocate3=enemydown3;
										e3h++;
									}}}
							break;
						case 3:
							if(!(map[e3h][e3w-1].getIcon()).equals(wall)) {
								if(!(map[e3h][e3w-1].getIcon()).equals(enemy1)) {
									if(!(map[e3h][e3w-1].getIcon()).equals(enemy2)) {
										enemyleft3=map[e3h][e3w-1].getIcon();
										map[e3h][e3w-1].setIcon(enemy3);
										map[e3h][e3w].setIcon(enemylocate3);
										enemylocate3=enemyleft3;
										e3w--;
									}}}
							break;
						case 4:
							if(!(map[e3h][e3w+1].getIcon()).equals(wall)) {
								if(!(map[e3h][e3w+1].getIcon()).equals(enemy1)) {
									if(!(map[e3h][e3w+1].getIcon()).equals(enemy2)) {
										enemyright3=map[e3h][e3w+1].getIcon();
										map[e3h][e3w+1].setIcon(enemy3);
										map[e3h][e3w].setIcon(enemylocate3);
										enemylocate3=enemyright3;
										e3w++;
									}}}
							break;
					}
					if(e3h==ch && e3w==cw) {
						ch2 = ch; cw2 = cw;
						ch = 17; cw = 9;
						map[ch][cw].setIcon(characterup1);    
						life2 = life2 - 1;
						
						if(!(map[e3h][e3w].getIcon()).equals(dotpoint)) {
							enemylocate3=black;}
						else {enemylocate3=dotpoint;}
						map[ch2][cw2].setIcon(black);
						
						switch(life2){ 
							    case 0: {for(int i=0; i<20; i++) {
										for(int j=0; j<20; j++) {
											map[i][j].setIcon(wall);
										}
									score.setText("포인트:"+point);
									dialog.setVisible(true);}}  

							    case 1: { map[20][0].setIcon(black);}
							    break;

							    case 2:{ map[20][1].setIcon(black);}
							    break;
							    
							    case 3:{ map[20][2].setIcon(black);}
							    break;

			}
						}
			}
		}
		final enemymove3 enemymove3 = new enemymove3();
		Timer enemymo3 = new Timer(100, enemymove3);
		enemymo3.start();
		
			class KListener extends KeyAdapter{ 
			public void keyPressed(KeyEvent e) {
				if(dot<=0) {
					dot = 180;
					em1=3; em2=1; em3=1;
					e1h=10; e1w=9;
					e2h=8; e2w=9;
					e3h=6; e3w=9;
					ch = 17; cw = 9;
					switch(gamecount) {
					
					case 0: {
						for(int i=1; i<=18; i++){
							map[1][i].setIcon(dotpoint);
						}
					map[0][12].setIcon(S); map[0][13].setIcon(T); map[0][14].setIcon(A); map[0][15].setIcon(G); map[0][16].setIcon(E); map[0][17].setIcon(stage2);
		map[2][1].setIcon(dotpoint); map[2][2].setIcon(dotpoint); map[2][3].setIcon(dotpoint); map[2][6].setIcon(dotpoint); map[2][7].setIcon(dotpoint); map[2][9].setIcon(dotpoint);
		map[3][1].setIcon(dotpoint); map[3][4].setIcon(dotpoint); map[3][5].setIcon(dotpoint); map[3][9].setIcon(dotpoint); map[3][10].setIcon(dotpoint); map[3][11].setIcon(dotpoint); 
		map[3][12].setIcon(dotpoint); map[3][14].setIcon(dotpoint); map[3][15].setIcon(dotpoint); map[3][16].setIcon(dotpoint); map[3][18].setIcon(dotpoint); 
		map[4][1].setIcon(dotpoint); map[4][3].setIcon(dotpoint); map[4][4].setIcon(dotpoint); map[4][5].setIcon(dotpoint); map[4][6].setIcon(dotpoint); map[4][9].setIcon(dotpoint); 
		map[4][10].setIcon(dotpoint); map[4][11].setIcon(dotpoint); map[4][13].setIcon(dotpoint); map[4][16].setIcon(dotpoint); map[4][18].setIcon(dotpoint); 
		map[5][1].setIcon(dotpoint); map[5][5].setIcon(dotpoint); map[5][8].setIcon(dotpoint); map[5][9].setIcon(dotpoint); map[5][10].setIcon(dotpoint); map[5][12].setIcon(dotpoint); 
		map[5][13].setIcon(dotpoint); map[5][15].setIcon(dotpoint); map[5][16].setIcon(dotpoint); map[5][17].setIcon(dotpoint); map[5][18].setIcon(dotpoint);
		map[6][1].setIcon(dotpoint); map[6][3].setIcon(dotpoint); map[6][5].setIcon(dotpoint); map[6][7].setIcon(dotpoint); map[e3h][e3w].setIcon(enemy3); map[6][12].setIcon(dotpoint); 
		map[6][13].setIcon(dotpoint); map[6][15].setIcon(dotpoint); 
		map[7][1].setIcon(dotpoint); map[7][2].setIcon(dotpoint); map[7][3].setIcon(dotpoint); map[7][5].setIcon(dotpoint); map[7][6].setIcon(dotpoint); map[7][7].setIcon(dotpoint); 
		map[7][8].setIcon(dotpoint); map[7][10].setIcon(dotpoint); map[7][11].setIcon(dotpoint); map[7][12].setIcon(dotpoint); map[7][15].setIcon(dotpoint);                           map[7][9].setIcon(black); 
		map[7][16].setIcon(dotpoint); map[7][17].setIcon(dotpoint); 
		map[8][1].setIcon(dotpoint); map[8][3].setIcon(dotpoint); map[8][5].setIcon(dotpoint); map[8][6].setIcon(dotpoint); map[8][12].setIcon(dotpoint); map[8][13].setIcon(dotpoint); 
		map[8][14].setIcon(dotpoint); map[8][15].setIcon(dotpoint); map[8][16].setIcon(dotpoint); map[8][17].setIcon(dotpoint);                                                        map[e2h][e2w].setIcon(enemy2); 
		map[9][1].setIcon(dotpoint); map[9][6].setIcon(dotpoint); map[9][12].setIcon(dotpoint); map[9][13].setIcon(dotpoint); map[9][14].setIcon(dotpoint); map[9][17].setIcon(dotpoint); 
		map[9][18].setIcon(dotpoint);                                                                                                                                            map[9][8].setIcon(black); map[9][9].setIcon(black); map[9][10].setIcon(black);
		map[10][1].setIcon(dotpoint); map[10][3].setIcon(dotpoint); map[10][4].setIcon(dotpoint); map[10][5].setIcon(dotpoint); map[10][6].setIcon(dotpoint); map[10][12].setIcon(dotpoint); 
		map[10][14].setIcon(dotpoint); map[10][16].setIcon(dotpoint); map[10][17].setIcon(dotpoint);                                                                                 map[10][8].setIcon(black); map[e1h][e1w].setIcon(enemy1); map[10][10].setIcon(black);
		map[11][1].setIcon(dotpoint); map[11][3].setIcon(dotpoint); map[11][5].setIcon(dotpoint); map[11][12].setIcon(dotpoint); map[11][14].setIcon(dotpoint); map[11][16].setIcon(dotpoint); 
		map[11][17].setIcon(dotpoint); 
		map[12][1].setIcon(dotpoint); map[12][16].setIcon(dotpoint); 
		map[13][1].setIcon(dotpoint); map[13][2].setIcon(dotpoint); map[13][3].setIcon(dotpoint); map[13][5].setIcon(dotpoint); map[13][6].setIcon(dotpoint); map[13][7].setIcon(dotpoint); 
		map[13][8].setIcon(dotpoint); map[13][10].setIcon(dotpoint); map[13][11].setIcon(dotpoint); map[13][13].setIcon(dotpoint); map[13][14].setIcon(dotpoint); map[13][15].setIcon(dotpoint); 
		map[13][16].setIcon(dotpoint); map[13][17].setIcon(dotpoint);
		map[14][1].setIcon(dotpoint); map[14][3].setIcon(dotpoint); map[14][4].setIcon(dotpoint); map[14][5].setIcon(dotpoint); map[14][8].setIcon(dotpoint); map[14][10].setIcon(dotpoint); 
		map[14][11].setIcon(dotpoint); map[14][13].setIcon(dotpoint); map[14][15].setIcon(dotpoint); map[14][16].setIcon(dotpoint); map[14][17].setIcon(dotpoint); 
		map[15][7].setIcon(dotpoint); map[15][8].setIcon(dotpoint); map[15][10].setIcon(dotpoint); map[15][11].setIcon(dotpoint); map[15][13].setIcon(dotpoint); map[15][14].setIcon(dotpoint); 
		map[15][15].setIcon(dotpoint); map[15][18].setIcon(dotpoint); 
		map[16][2].setIcon(dotpoint); map[16][4].setIcon(dotpoint); map[16][5].setIcon(dotpoint); map[16][7].setIcon(dotpoint); map[16][8].setIcon(dotpoint); map[16][9].setIcon(dotpoint); 
		map[16][10].setIcon(dotpoint); map[16][11].setIcon(dotpoint); map[16][15].setIcon(dotpoint); map[16][16].setIcon(dotpoint); map[16][17].setIcon(dotpoint); map[16][18].setIcon(dotpoint); 
		map[17][1].setIcon(dotpoint); map[17][2].setIcon(dotpoint); map[17][3].setIcon(dotpoint); map[17][4].setIcon(dotpoint); map[17][5].setIcon(dotpoint); map[17][7].setIcon(dotpoint); 
		map[17][11].setIcon(dotpoint); map[17][13].setIcon(dotpoint); map[17][14].setIcon(dotpoint); map[17][15].setIcon(dotpoint); map[17][17].setIcon(dotpoint);                       map[17][9].setIcon(characterup1); 
		map[18][1].setIcon(dotpoint); map[18][3].setIcon(dotpoint); map[18][5].setIcon(dotpoint); map[18][6].setIcon(dotpoint); map[18][7].setIcon(dotpoint); map[18][9].setIcon(dotpoint); 
		map[18][11].setIcon(dotpoint); map[18][12].setIcon(dotpoint); map[18][13].setIcon(dotpoint); map[18][15].setIcon(dotpoint); map[18][17].setIcon(dotpoint); 
		
		
					gamecount = gamecount+1;
					Timer enemymo1 = new Timer(75, enemymove1);
					Timer enemymo2 = new Timer(75, enemymove2);
					Timer enemymo3 = new Timer(75, enemymove3);
					enemymo1.start();
					enemymo2.start();
					enemymo3.start();
					}
					break;
					
					case 1: {
						for(int i=1; i<=18; i++){
							map[1][i].setIcon(dotpoint);
						}
					map[0][12].setIcon(S); map[0][13].setIcon(T); map[0][14].setIcon(A); map[0][15].setIcon(G); map[0][16].setIcon(E); map[0][17].setIcon(stage3);
		map[2][1].setIcon(dotpoint); map[2][2].setIcon(dotpoint); map[2][3].setIcon(dotpoint); map[2][6].setIcon(dotpoint); map[2][7].setIcon(dotpoint); map[2][9].setIcon(dotpoint);
		map[3][1].setIcon(dotpoint); map[3][4].setIcon(dotpoint); map[3][5].setIcon(dotpoint); map[3][9].setIcon(dotpoint); map[3][10].setIcon(dotpoint); map[3][11].setIcon(dotpoint); 
		map[3][12].setIcon(dotpoint); map[3][14].setIcon(dotpoint); map[3][15].setIcon(dotpoint); map[3][16].setIcon(dotpoint); map[3][18].setIcon(dotpoint); 
		map[4][1].setIcon(dotpoint); map[4][3].setIcon(dotpoint); map[4][4].setIcon(dotpoint); map[4][5].setIcon(dotpoint); map[4][6].setIcon(dotpoint); map[4][9].setIcon(dotpoint); 
		map[4][10].setIcon(dotpoint); map[4][11].setIcon(dotpoint); map[4][13].setIcon(dotpoint); map[4][16].setIcon(dotpoint); map[4][18].setIcon(dotpoint); 
		map[5][1].setIcon(dotpoint); map[5][5].setIcon(dotpoint); map[5][8].setIcon(dotpoint); map[5][9].setIcon(dotpoint); map[5][10].setIcon(dotpoint); map[5][12].setIcon(dotpoint); 
		map[5][13].setIcon(dotpoint); map[5][15].setIcon(dotpoint); map[5][16].setIcon(dotpoint); map[5][17].setIcon(dotpoint); map[5][18].setIcon(dotpoint);
		map[6][1].setIcon(dotpoint); map[6][3].setIcon(dotpoint); map[6][5].setIcon(dotpoint); map[6][7].setIcon(dotpoint); map[e3h][e3w].setIcon(enemy3); map[6][12].setIcon(dotpoint); 
		map[6][13].setIcon(dotpoint); map[6][15].setIcon(dotpoint); 
		map[7][1].setIcon(dotpoint); map[7][2].setIcon(dotpoint); map[7][3].setIcon(dotpoint); map[7][5].setIcon(dotpoint); map[7][6].setIcon(dotpoint); map[7][7].setIcon(dotpoint); 
		map[7][8].setIcon(dotpoint); map[7][10].setIcon(dotpoint); map[7][11].setIcon(dotpoint); map[7][12].setIcon(dotpoint); map[7][15].setIcon(dotpoint);                           map[7][9].setIcon(black); 
		map[7][16].setIcon(dotpoint); map[7][17].setIcon(dotpoint); 
		map[8][1].setIcon(dotpoint); map[8][3].setIcon(dotpoint); map[8][5].setIcon(dotpoint); map[8][6].setIcon(dotpoint); map[8][12].setIcon(dotpoint); map[8][13].setIcon(dotpoint); 
		map[8][14].setIcon(dotpoint); map[8][15].setIcon(dotpoint); map[8][16].setIcon(dotpoint); map[8][17].setIcon(dotpoint);                                                        map[e2h][e2w].setIcon(enemy2); 
		map[9][1].setIcon(dotpoint); map[9][6].setIcon(dotpoint); map[9][12].setIcon(dotpoint); map[9][13].setIcon(dotpoint); map[9][14].setIcon(dotpoint); map[9][17].setIcon(dotpoint); 
		map[9][18].setIcon(dotpoint);                                                                                                                                            map[9][8].setIcon(black); map[9][9].setIcon(black); map[9][10].setIcon(black);
		map[10][1].setIcon(dotpoint); map[10][3].setIcon(dotpoint); map[10][4].setIcon(dotpoint); map[10][5].setIcon(dotpoint); map[10][6].setIcon(dotpoint); map[10][12].setIcon(dotpoint); 
		map[10][14].setIcon(dotpoint); map[10][16].setIcon(dotpoint); map[10][17].setIcon(dotpoint);                                                                                 map[10][8].setIcon(black); map[e1h][e1w].setIcon(enemy1); map[10][10].setIcon(black);
		map[11][1].setIcon(dotpoint); map[11][3].setIcon(dotpoint); map[11][5].setIcon(dotpoint); map[11][12].setIcon(dotpoint); map[11][14].setIcon(dotpoint); map[11][16].setIcon(dotpoint); 
		map[11][17].setIcon(dotpoint); 
		map[12][1].setIcon(dotpoint); map[12][16].setIcon(dotpoint); 
		map[13][1].setIcon(dotpoint); map[13][2].setIcon(dotpoint); map[13][3].setIcon(dotpoint); map[13][5].setIcon(dotpoint); map[13][6].setIcon(dotpoint); map[13][7].setIcon(dotpoint); 
		map[13][8].setIcon(dotpoint); map[13][10].setIcon(dotpoint); map[13][11].setIcon(dotpoint); map[13][13].setIcon(dotpoint); map[13][14].setIcon(dotpoint); map[13][15].setIcon(dotpoint); 
		map[13][16].setIcon(dotpoint); map[13][17].setIcon(dotpoint);
		map[14][1].setIcon(dotpoint); map[14][3].setIcon(dotpoint); map[14][4].setIcon(dotpoint); map[14][5].setIcon(dotpoint); map[14][8].setIcon(dotpoint); map[14][10].setIcon(dotpoint); 
		map[14][11].setIcon(dotpoint); map[14][13].setIcon(dotpoint); map[14][15].setIcon(dotpoint); map[14][16].setIcon(dotpoint); map[14][17].setIcon(dotpoint); 
		map[15][7].setIcon(dotpoint); map[15][8].setIcon(dotpoint); map[15][10].setIcon(dotpoint); map[15][11].setIcon(dotpoint); map[15][13].setIcon(dotpoint); map[15][14].setIcon(dotpoint); 
		map[15][15].setIcon(dotpoint); map[15][18].setIcon(dotpoint); 
		map[16][2].setIcon(dotpoint); map[16][4].setIcon(dotpoint); map[16][5].setIcon(dotpoint); map[16][7].setIcon(dotpoint); map[16][8].setIcon(dotpoint); map[16][9].setIcon(dotpoint); 
		map[16][10].setIcon(dotpoint); map[16][11].setIcon(dotpoint); map[16][15].setIcon(dotpoint); map[16][16].setIcon(dotpoint); map[16][17].setIcon(dotpoint); map[16][18].setIcon(dotpoint); 
		map[17][1].setIcon(dotpoint); map[17][2].setIcon(dotpoint); map[17][3].setIcon(dotpoint); map[17][4].setIcon(dotpoint); map[17][5].setIcon(dotpoint); map[17][7].setIcon(dotpoint); 
		map[17][11].setIcon(dotpoint); map[17][13].setIcon(dotpoint); map[17][14].setIcon(dotpoint); map[17][15].setIcon(dotpoint); map[17][17].setIcon(dotpoint);                       map[17][9].setIcon(characterup1); 
		map[18][1].setIcon(dotpoint); map[18][3].setIcon(dotpoint); map[18][5].setIcon(dotpoint); map[18][6].setIcon(dotpoint); map[18][7].setIcon(dotpoint); map[18][9].setIcon(dotpoint); 
		map[18][11].setIcon(dotpoint); map[18][12].setIcon(dotpoint); map[18][13].setIcon(dotpoint); map[18][15].setIcon(dotpoint); map[18][17].setIcon(dotpoint); 
		
					gamecount = gamecount+1;
					Timer enemymo1 = new Timer(50, enemymove1);
					Timer enemymo2 = new Timer(50, enemymove2);
					Timer enemymo3 = new Timer(50, enemymove3);
					enemymo1.start();
					enemymo2.start();
					enemymo3.start();
					}
					break;
					
					case 2:{for(int i=0; i<20; i++) {
						for(int j=0; j<20; j++) {
							map[i][j].setIcon(wall);
						}
					}
					score.setText("포인트:"+point);
					dialog.setVisible(true);
					}
					
					}
				}
				int key = e.getKeyCode();
				switch(key) {
					case KeyEvent.VK_UP:
						if((map[ch-1][cw].getIcon()).equals(dotpoint) || (map[ch-1][cw].getIcon()).equals(black)) {
							if(((map[ch-1][cw].getIcon()).equals(black) || (map[ch-1][cw].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterup2)){
								if((map[ch-1][cw].getIcon()).equals(dotpoint)){
							map[ch-1][cw].setIcon(characterup2);
							dot--;
							
							point=point+10;
							seat1 = point/1;  //1의자리
							seat2 = (point%100)/10; //10의자리
							seat3 = (point%1000)/100;  //100의자리
							seat4 = (point%10000)/1000;  //1000의자리
							seat5 = point/10000;  //10000의자리
							
							switch(seat1){
							case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
							break;

							case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
							break;

							case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
							break;

							case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
							break;

							case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
							break;

							case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
							break;

							case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
							break;

							case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
							break;

							case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
							break;

							case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
							break;
							
						}
							switch(seat2){
							case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
							break;

							case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
							break;

							case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
							break;

							case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
							break;

							case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
							break;

							case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
							break;

							case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
							break;

							case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
							break;

							case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
							break;

							case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
							break;
							
						}
							switch(seat3){
							case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
							break;

							case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
							break;

							case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
							break;

							case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
							break;

							case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
							break;

							case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
							break;

							case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
							break;

							case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
							break;

							case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
							break;

							case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
							break;
							
						}
							switch(seat4){
							case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
							break;

							case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
							break;

							case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
							break;

							case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
							break;

							case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
							break;

							case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
							break;

							case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
							break;

							case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
							break;

							case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
							break;

							case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
							break;
							
						}
							switch(seat5){
							case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
							break;

							case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
							break;

							case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
							break;

							case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
							break;

							case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
							break;

							case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
							break;

							case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
							break;

							case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
							break;

							case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
							break;

							case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
							break;
							
						}
							}
							else{map[ch-1][cw].setIcon(characterup2);}
							}
							else if(((map[ch-1][cw].getIcon()).equals(black) || (map[ch-1][cw].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterup1)){
								if((map[ch-1][cw].getIcon()).equals(dotpoint)){
									map[ch-1][cw].setIcon(characterup1);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch-1][cw].setIcon(characterup1);}
									}
							
							map[ch][cw].setIcon(black);
							
							ch--;
						}
						if((map[ch-1][cw].getIcon()).equals(enemy1)) {
							for(int i=0; i<20; i++) {
								for(int j=0; j<20; j++) {
									map[i][j].setIcon(wall);
								}
							}
							score.setText("포인트:"+point);
							dialog.setVisible(true);
						}
						break;
					case KeyEvent.VK_DOWN:
						if((map[ch+1][cw].getIcon()).equals(dotpoint) || (map[ch+1][cw].getIcon()).equals(black)) {
							if(((map[ch+1][cw].getIcon()).equals(black) || (map[ch+1][cw].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterdown2)){
								if((map[ch+1][cw].getIcon()).equals(dotpoint)){
									map[ch+1][cw].setIcon(characterdown2);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch+1][cw].setIcon(characterdown2);}
									}
								
							else if(((map[ch+1][cw].getIcon()).equals(black) || (map[ch+1][cw].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterdown1)){
								if((map[ch+1][cw].getIcon()).equals(dotpoint)){
									map[ch+1][cw].setIcon(characterdown1);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch+1][cw].setIcon(characterdown1);}
									}
								
								map[ch][cw].setIcon(black);
							ch++;
						}
						if((map[ch+1][cw].getIcon()).equals(enemy1)){
							for(int i=0; i<20; i++) {
								for(int j=0; j<20; j++) {
									map[i][j].setIcon(wall);
								}
							}
							score.setText("포인트:"+point);
							dialog.setVisible(true);
						}
						break;
					case KeyEvent.VK_LEFT:
						if((map[ch][cw-1].getIcon()).equals(dotpoint) || (map[ch][cw-1].getIcon()).equals(black)) {
							if(((map[ch][cw-1].getIcon()).equals(black) || (map[ch][cw-1].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterleft2)){
								if((map[ch][cw-1].getIcon()).equals(dotpoint)){
									map[ch][cw-1].setIcon(characterleft2);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch][cw-1].setIcon(characterleft2);}
									}
								
							else if(((map[ch][cw-1].getIcon()).equals(black) || (map[ch][cw-1].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterleft1)){
								if((map[ch][cw-1].getIcon()).equals(dotpoint)){
									map[ch][cw-1].setIcon(characterleft1);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch][cw-1].setIcon(characterleft1);}
									}
								
								map[ch][cw].setIcon(black);
							cw--;
						}
						if((map[ch][cw-1].getIcon()).equals(enemy1)){
							for(int i=0; i<20; i++) {
								for(int j=0; j<20; j++) {
									map[i][j].setIcon(wall);
								}
							}
							score.setText("포인트:"+point);
							dialog.setVisible(true);
						}
						break;
					case KeyEvent.VK_RIGHT:
						if((map[ch][cw+1].getIcon()).equals(dotpoint) || (map[ch][cw+1].getIcon()).equals(black)) {
							if(((map[ch][cw+1].getIcon()).equals(black) || (map[ch][cw+1].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterright2)){
								if((map[ch][cw+1].getIcon()).equals(dotpoint)){
									map[ch][cw+1].setIcon(characterright2);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch][cw+1].setIcon(characterright2);}
									}
								
							else if(((map[ch][cw+1].getIcon()).equals(black) || (map[ch][cw+1].getIcon()).equals(dotpoint)) && !(map[ch][cw].getIcon()).equals(characterright1)){
								if((map[ch][cw+1].getIcon()).equals(dotpoint)){
									map[ch][cw+1].setIcon(characterright1);
									dot--;
									point=point+10;
									
									seat1 = point/1;  //1의자리
									seat2 = (point%100)/10; //10의자리
									seat3 = (point%1000)/100;  //100의자리
									seat4 = (point%10000)/1000;  //1000의자리
									seat5 = point/10000;  //10000의자리
									
									switch(seat1){
									case 0:  if(seat1 == 0){ map[20][13].setIcon(zero);}
									break;

									case 1:  if(seat1 == 1){ map[20][13].setIcon(one);}
									break;

									case 2:  if(seat1 == 2){ map[20][13].setIcon(two);}
									break;

									case 3:  if(seat1 == 3){ map[20][13].setIcon(three);}
									break;

									case 4:  if(seat1 == 4){ map[20][13].setIcon(four);}
									break;

									case 5:  if(seat1 == 5){ map[20][13].setIcon(five);}
									break;

									case 6:  if(seat1 == 6){ map[20][13].setIcon(six);}
									break;

									case 7:  if(seat1 == 7){ map[20][13].setIcon(seven);}
									break;

									case 8:  if(seat1 == 8){ map[20][13].setIcon(eight);}
									break;

									case 9:  if(seat1 == 9){ map[20][13].setIcon(nine);}
									break;
									
								}
									switch(seat2){
									case 0:  if(seat2 == 0){ map[20][12].setIcon(zero);}
									break;

									case 1:  if(seat2 == 1){ map[20][12].setIcon(one);}
									break;

									case 2:  if(seat2 == 2){ map[20][12].setIcon(two);}
									break;

									case 3:  if(seat2 == 3){ map[20][12].setIcon(three);}
									break;

									case 4:  if(seat2 == 4){ map[20][12].setIcon(four);}
									break;

									case 5:  if(seat2 == 5){ map[20][12].setIcon(five);}
									break;

									case 6:  if(seat2 == 6){ map[20][12].setIcon(six);}
									break;

									case 7:  if(seat2 == 7){ map[20][12].setIcon(seven);}
									break;

									case 8:  if(seat2 == 8){ map[20][12].setIcon(eight);}
									break;

									case 9:  if(seat2 == 9){ map[20][12].setIcon(nine);}
									break;
									
								}
									switch(seat3){
									case 0:  if(seat3 == 0){ map[20][11].setIcon(zero);}
									break;

									case 1:  if(seat3 == 1){ map[20][11].setIcon(one);}
									break;

									case 2:  if(seat3 == 2){ map[20][11].setIcon(two);}
									break;

									case 3:  if(seat3 == 3){ map[20][11].setIcon(three);}
									break;

									case 4:  if(seat3 == 4){ map[20][11].setIcon(four);}
									break;

									case 5:  if(seat3 == 5){ map[20][11].setIcon(five);}
									break;

									case 6:  if(seat3 == 6){ map[20][11].setIcon(six);}
									break;

									case 7:  if(seat3 == 7){ map[20][11].setIcon(seven);}
									break;

									case 8:  if(seat3 == 8){ map[20][11].setIcon(eight);}
									break;

									case 9:  if(seat3 == 9){ map[20][11].setIcon(nine);}
									break;
									
								}
									switch(seat4){
									case 0:  if(seat4 == 0){ map[20][10].setIcon(zero);}
									break;

									case 1:  if(seat4 == 1){ map[20][10].setIcon(one);}
									break;

									case 2:  if(seat4 == 2){ map[20][10].setIcon(two);}
									break;

									case 3:  if(seat4 == 3){ map[20][10].setIcon(three);}
									break;

									case 4:  if(seat4 == 4){ map[20][10].setIcon(four);}
									break;

									case 5:  if(seat4 == 5){ map[20][10].setIcon(five);}
									break;

									case 6:  if(seat4 == 6){ map[20][10].setIcon(six);}
									break;

									case 7:  if(seat4 == 7){ map[20][10].setIcon(seven);}
									break;

									case 8:  if(seat4 == 8){ map[20][10].setIcon(eight);}
									break;

									case 9:  if(seat4 == 9){ map[20][10].setIcon(nine);}
									break;
									
								}
									switch(seat5){
									case 0:  if(seat5 == 0){ map[20][9].setIcon(zero);}
									break;

									case 1:  if(seat5 == 1){ map[20][9].setIcon(one);}
									break;

									case 2:  if(seat5 == 2){ map[20][9].setIcon(two);}
									break;

									case 3:  if(seat5 == 3){ map[20][9].setIcon(three);}
									break;

									case 4:  if(seat5 == 4){ map[20][9].setIcon(four);}
									break;

									case 5:  if(seat5 == 5){ map[20][9].setIcon(five);}
									break;

									case 6:  if(seat5 == 6){ map[20][9].setIcon(six);}
									break;

									case 7:  if(seat5 == 7){ map[20][9].setIcon(seven);}
									break;

									case 8:  if(seat5 == 8){ map[20][9].setIcon(eight);}
									break;

									case 9:  if(seat5 == 9){ map[20][9].setIcon(nine);}
									break;
									
								}
									}
									else{map[ch][cw+1].setIcon(characterright1);}
									}
								
								map[ch][cw].setIcon(black);
							cw++;
						}
						if((map[ch][cw].getIcon()).equals(enemy1)) {
							for(int i=0; i<20; i++) {
								for(int j=0; j<20; j++) {
									map[i][j].setIcon(wall);
								}
							}
							score.setText("포인트:"+point);
							dialog.setVisible(true);
						}
						break;
				}
				System.out.println(dot);
				System.out.println(point);
			}
		}
		
		class clistener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				 Connection conn = null; 
			        PreparedStatement pstm = null;  
			        ResultSet rs = null; 
			        
			        try {
			        	String k, kk;

			        	k = name.getText();
			        	kk = pwd.getText();
			        	
			            String quary = "select password from guser where name = '"+k+"' ";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
			            rs = pstm.executeQuery();
			            
			            while(rs.next()){
			            	
			                String passwd = rs.getString(1);
			              
			                System.out.println(kk);
			                System.out.println(passwd);
			                
			                if(passwd.equals(kk))
			                {
			                	name1.setText("로그인 완료 점수를 업데이트 하세요");
			                }
			                else
			                {   
			                	name1.setText("로그인 정보를 다시 확인하시오"); 
			                }
			            
			            }} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
			                if ( rs != null ){rs.close();}   
			                if ( pstm != null ){pstm.close();}   
			                if ( conn != null ){conn.close(); }
			            }catch(Exception e){
			                throw new RuntimeException(e.getMessage());
			            }
			        }
			}
		}
		class slistener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				String kk = name1.getText();
				
				 Connection conn = null; 
			        PreparedStatement pstm = null;  
			        ResultSet rs = null; 
			        PreparedStatement pstm2 = null;  
			        ResultSet rs2 = null; 
			        if(kk.equals("로그인 완료 점수를 업데이트 하세요")){
			        try {
			        	String k;

			        	k = name.getText();
			        	
			            String quary = "update guser set point1 = "+point+" where name = '"+k+"' ";
			            String quary2 = "select point1 from guser where name = '"+k+"' ";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
			            rs = pstm.executeQuery();
			            pstm2 = conn.prepareStatement(quary2);
			            rs2 = pstm2.executeQuery();
			            
			            while(rs.next()){
			            	 while(rs2.next()){
			            		 int scor = rs2.getInt(1);
					                if(scor == point)
					                {
					                	name1.setText("업데이트 완료");
					                }
					                else
					                {   
					                	name1.setText("업데이트 실패"); 
					                }
					            
					            }
			            
			            }} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
			                if ( rs != null ){rs.close();}   
			                if ( pstm != null ){pstm.close();}   
			                if ( conn != null ){conn.close(); }
			            }catch(Exception e){
			                throw new RuntimeException(e.getMessage());
			            }
			        }
			}
		}
		}
		submit.addActionListener(new slistener());
		clogin.addActionListener(new clistener());
		KListener listener = new KListener();	

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(21,20));
		frame.requestFocus();
		frame.addKeyListener(new KListener());


		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				map[i][j].setIcon(wall);
				map[i][j].addKeyListener(listener);
				panel.add(map[i][j]);
			}
		}
		

		for(int i=20; i<21; i++) {
			for(int j=0; j<20; j++) {
				map[i][j].setIcon(black);
				panel.add(map[i][j]);}
			}
		
		for(int i=1; i<=18; i++){
			map[1][i].setIcon(dotpoint);
		}
		map[0][12].setIcon(S); map[0][13].setIcon(T); map[0][14].setIcon(A); map[0][15].setIcon(G); map[0][16].setIcon(E); map[0][17].setIcon(stage1);
		map[2][1].setIcon(dotpoint); map[2][2].setIcon(dotpoint); map[2][3].setIcon(dotpoint); map[2][6].setIcon(dotpoint); map[2][7].setIcon(dotpoint); map[2][9].setIcon(dotpoint);
		map[3][1].setIcon(dotpoint); map[3][4].setIcon(dotpoint); map[3][5].setIcon(dotpoint); map[3][9].setIcon(dotpoint); map[3][10].setIcon(dotpoint); map[3][11].setIcon(dotpoint); 
		map[3][12].setIcon(dotpoint); map[3][14].setIcon(dotpoint); map[3][15].setIcon(dotpoint); map[3][16].setIcon(dotpoint); map[3][18].setIcon(dotpoint); 
		map[4][1].setIcon(dotpoint); map[4][3].setIcon(dotpoint); map[4][4].setIcon(dotpoint); map[4][5].setIcon(dotpoint); map[4][6].setIcon(dotpoint); map[4][9].setIcon(dotpoint); 
		map[4][10].setIcon(dotpoint); map[4][11].setIcon(dotpoint); map[4][13].setIcon(dotpoint); map[4][16].setIcon(dotpoint); map[4][18].setIcon(dotpoint); 
		map[5][1].setIcon(dotpoint); map[5][5].setIcon(dotpoint); map[5][8].setIcon(dotpoint); map[5][9].setIcon(dotpoint); map[5][10].setIcon(dotpoint); map[5][12].setIcon(dotpoint); 
		map[5][13].setIcon(dotpoint); map[5][15].setIcon(dotpoint); map[5][16].setIcon(dotpoint); map[5][17].setIcon(dotpoint); map[5][18].setIcon(dotpoint);
		map[6][1].setIcon(dotpoint); map[6][3].setIcon(dotpoint); map[6][5].setIcon(dotpoint); map[6][7].setIcon(dotpoint); map[6][9].setIcon(enemy3); map[6][12].setIcon(dotpoint); 
		map[6][13].setIcon(dotpoint); map[6][15].setIcon(dotpoint); 
		map[7][1].setIcon(dotpoint); map[7][2].setIcon(dotpoint); map[7][3].setIcon(dotpoint); map[7][5].setIcon(dotpoint); map[7][6].setIcon(dotpoint); map[7][7].setIcon(dotpoint); 
		map[7][8].setIcon(dotpoint); map[7][10].setIcon(dotpoint); map[7][11].setIcon(dotpoint); map[7][12].setIcon(dotpoint); map[7][15].setIcon(dotpoint);                           map[7][9].setIcon(black); 
		map[7][16].setIcon(dotpoint); map[7][17].setIcon(dotpoint); 
		map[8][1].setIcon(dotpoint); map[8][3].setIcon(dotpoint); map[8][5].setIcon(dotpoint); map[8][6].setIcon(dotpoint); map[8][12].setIcon(dotpoint); map[8][13].setIcon(dotpoint); 
		map[8][14].setIcon(dotpoint); map[8][15].setIcon(dotpoint); map[8][16].setIcon(dotpoint); map[8][17].setIcon(dotpoint);                                                        map[8][9].setIcon(enemy2); 
		map[9][1].setIcon(dotpoint); map[9][6].setIcon(dotpoint); map[9][12].setIcon(dotpoint); map[9][13].setIcon(dotpoint); map[9][14].setIcon(dotpoint); map[9][17].setIcon(dotpoint); 
		map[9][18].setIcon(dotpoint);                                                                                                                                            map[9][8].setIcon(black); map[9][9].setIcon(black); map[9][10].setIcon(black);
		map[10][1].setIcon(dotpoint); map[10][3].setIcon(dotpoint); map[10][4].setIcon(dotpoint); map[10][5].setIcon(dotpoint); map[10][6].setIcon(dotpoint); map[10][12].setIcon(dotpoint); 
		map[10][14].setIcon(dotpoint); map[10][16].setIcon(dotpoint); map[10][17].setIcon(dotpoint);                                                                                 map[10][8].setIcon(black); map[10][9].setIcon(enemy1); map[10][10].setIcon(black);
		map[11][1].setIcon(dotpoint); map[11][3].setIcon(dotpoint); map[11][5].setIcon(dotpoint); map[11][12].setIcon(dotpoint); map[11][14].setIcon(dotpoint); map[11][16].setIcon(dotpoint); 
		map[11][17].setIcon(dotpoint); 
		map[12][1].setIcon(dotpoint); map[12][16].setIcon(dotpoint); 
		map[13][1].setIcon(dotpoint); map[13][2].setIcon(dotpoint); map[13][3].setIcon(dotpoint); map[13][5].setIcon(dotpoint); map[13][6].setIcon(dotpoint); map[13][7].setIcon(dotpoint); 
		map[13][8].setIcon(dotpoint); map[13][10].setIcon(dotpoint); map[13][11].setIcon(dotpoint); map[13][13].setIcon(dotpoint); map[13][14].setIcon(dotpoint); map[13][15].setIcon(dotpoint); 
		map[13][16].setIcon(dotpoint); map[13][17].setIcon(dotpoint);
		map[14][1].setIcon(dotpoint); map[14][3].setIcon(dotpoint); map[14][4].setIcon(dotpoint); map[14][5].setIcon(dotpoint); map[14][8].setIcon(dotpoint); map[14][10].setIcon(dotpoint); 
		map[14][11].setIcon(dotpoint); map[14][13].setIcon(dotpoint); map[14][15].setIcon(dotpoint); map[14][16].setIcon(dotpoint); map[14][17].setIcon(dotpoint); 
		map[15][7].setIcon(dotpoint); map[15][8].setIcon(dotpoint); map[15][10].setIcon(dotpoint); map[15][11].setIcon(dotpoint); map[15][13].setIcon(dotpoint); map[15][14].setIcon(dotpoint); 
		map[15][15].setIcon(dotpoint); map[15][18].setIcon(dotpoint); 
		map[16][2].setIcon(dotpoint); map[16][4].setIcon(dotpoint); map[16][5].setIcon(dotpoint); map[16][7].setIcon(dotpoint); map[16][8].setIcon(dotpoint); map[16][9].setIcon(dotpoint); 
		map[16][10].setIcon(dotpoint); map[16][11].setIcon(dotpoint); map[16][15].setIcon(dotpoint); map[16][16].setIcon(dotpoint); map[16][17].setIcon(dotpoint); map[16][18].setIcon(dotpoint); 
		map[17][1].setIcon(dotpoint); map[17][2].setIcon(dotpoint); map[17][3].setIcon(dotpoint); map[17][4].setIcon(dotpoint); map[17][5].setIcon(dotpoint); map[17][7].setIcon(dotpoint); 
		map[17][11].setIcon(dotpoint); map[17][13].setIcon(dotpoint); map[17][14].setIcon(dotpoint); map[17][15].setIcon(dotpoint); map[17][17].setIcon(dotpoint);                       map[17][9].setIcon(characterup1); 
		map[18][1].setIcon(dotpoint); map[18][3].setIcon(dotpoint); map[18][5].setIcon(dotpoint); map[18][6].setIcon(dotpoint); map[18][7].setIcon(dotpoint); map[18][9].setIcon(dotpoint); 
		map[18][11].setIcon(dotpoint); map[18][12].setIcon(dotpoint); map[18][13].setIcon(dotpoint); map[18][15].setIcon(dotpoint); map[18][17].setIcon(dotpoint); 
		
		
		map[20][0].setIcon(life); map[20][1].setIcon(life); map[20][2].setIcon(life);
		map[20][7].setIcon(score1); map[20][8].setIcon(score2);
		map[20][9].setIcon(zero); map[20][10].setIcon(zero); map[20][11].setIcon(zero); map[20][12].setIcon(zero); map[20][13].setIcon(zero);
		
		frame.add(panel);
		frame.setTitle("PACMANGAME");
		frame.setVisible(true);
		frame.setSize(630, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		new java_assignment_game2();
	}

	

}
