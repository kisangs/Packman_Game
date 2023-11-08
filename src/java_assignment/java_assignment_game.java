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

public class java_assignment_game {

	private static Random random; //적의 움직임을 지정하는 랜덤함수
	private static int ch, cw, e1h, e1w, dot, locate, em1, point, ch2, cw2, gamecount; 
	private static Icon enemyup, enemydown, enemyleft, enemyright, enemylocate; //적이 가지고 있는 이미지를 저장하는 변수
	private static int seat1, seat2, seat3, seat4, seat5, life2; //점수 변수

	public java_assignment_game() {
		final JFrame frame = new JFrame();
		final ImageIcon life = new ImageIcon("image/life.png"); //생명 이미지
		final ImageIcon dotpoint = new ImageIcon("image/point.png"); //포인트 이미지
		final ImageIcon wall = new ImageIcon("image/wall.png"); //벽 이미지
		final ImageIcon enemy1 = new ImageIcon("image/enemy1.jpg"); //적 1 이미지
		final ImageIcon characterup1 = new ImageIcon("image/characterup1.png"); //캐릭터 위에 입벌리고 있는 이미지
		final ImageIcon characterup2 = new ImageIcon("image/characterup2.png"); //캐릭터 위에 입닫고 있는 이미지
		final ImageIcon characterright1 = new ImageIcon("image/characterright1.png"); //캐릭터 오른쪽 입벌리고 있는 이미지
		final ImageIcon characterright2 = new ImageIcon("image/characterright2.png"); //캐릭터 오른쪽 입닫고 있는 이미지
		final ImageIcon characterleft1 = new ImageIcon("image/characterleft1.png"); //캐릭터 왼쪽 입열고 있는 이미지
		final ImageIcon characterleft2 = new ImageIcon("image/characterleft2.png"); //캐릭터 왼쪽 입닫고 있는 이미지
		final ImageIcon characterdown1 = new ImageIcon("image/characterdown1.png"); //캐릭터 아래 입열고 있는 이미지
		final ImageIcon characterdown2 = new ImageIcon("image/characterdown2.png"); //캐릭터 아래 입닫고 있는 이미지
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
		final ImageIcon S = new ImageIcon("image/s.png"); //게임판 위에 S글씨
		final ImageIcon T = new ImageIcon("image/t.png"); //게임판 위에 T글씨
		final ImageIcon A = new ImageIcon("image/a.png"); //게임판 위에 A글씨
		final ImageIcon G = new ImageIcon("image/g.png"); //게임판 위에 G글씨
		final ImageIcon E = new ImageIcon("image/e.png"); //게임판 위에 E글씨
		final ImageIcon stage1 = new ImageIcon("image/stage1.png"); //게임판 위에 1번숫자
		final ImageIcon stage2 = new ImageIcon("image/stage2.png"); //게임판 위에 2번숫자
		final ImageIcon stage3 = new ImageIcon("image/stage3.png"); //게임판 위에 3번숫자
		
		final JDialog dialog = new JDialog(); //게임이 끝나면 뜨는 창
		final JTextField pwd = new JTextField(10); //비번 입력창
		final JTextField name = new JTextField(10); //아이디 입력창
		final JLabel score = new JLabel(); //점수 나타나는 창
		final JLabel name1 = new JLabel("로그인 후 당신의 점수를 업데이트하시기 바랍니다");
		final JLabel id = new JLabel("아이디:");
		final JLabel pass = new JLabel("비밀번호:");
		final JButton submit = new JButton("*점수업데이트*");
		final JButton clogin = new JButton("*로그인 확인*");
		
		random = new Random(); //적이 움직이는 방식인 랜덤

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
		
		ch=17;  cw=9; // ch=캐릭터의 세로위치 cw=캐릭터의 가로위치 
		e1h=9;  e1w=9; // e1h =적의 세로위치 e1w=적의 가로위치 
		dot=180; point=0; // dot=점수 갯수  point=게임점수
		em1=2;  enemylocate=black; // em1=적이 처음 공간에서 빠져나오기 위한 변수  enemylocate=적이 위치한 자리의 이미지
		life2=4; gamecount=0; //life=생명갯수 gamecount=게임횟수
		
		
		


		final JLabel[][] map = new JLabel[21][20]; //게임판의 크기를 지정

		for (int i=0; i<21; i++) {
			for(int j=0; j<20; j++) {
				map[i][j] = new JLabel();     //게임판을 JLabel로 설정해줌
			}
		}


		class TListener implements ActionListener {   //게임내의 적의 움직임을 설정
			public void actionPerformed(ActionEvent event)
			{
				if(em1<=0) locate = 1+random.nextInt(4);  //em1이 0보다 작거나 같으면 1~4사이의 숫자를 랜덤으로 뽑아낸다
				else { locate = 1; em1--; } //em1이 0이 되게끔 설정
					switch(locate) { //locate 라는 변수가 기준
						case 1: //1이 나오면 적이 한칸 위로 움직이게끔 한다
							if(!(map[e1h-1][e1w].getIcon()).equals(wall)) { //적이 위로 움직일때 벽이 아닌경우에 움직인다
								if(!(map[e1h-1][e1w].getIcon()).equals(S)) { //적이 위로 움직일때 S글자가 아닌경우에 움직인다
									if(!(map[e1h-1][e1w].getIcon()).equals(T)) { //적이 위로 움직일때 T글자가 아닌경우에 움직인다
										if(!(map[e1h-1][e1w].getIcon()).equals(A)) { //적이 위로 움직일때 A글자가 아닌경우에 움직인다
											if(!(map[e1h-1][e1w].getIcon()).equals(G)) { //적이 위로 움직일때 G글자가 아닌경우에 움직인다
												if(!(map[e1h-1][e1w].getIcon()).equals(E)) { //적이 위로 움직일때 E글자가 아닌경우에 움직인다
													if(!(map[e1h-1][e1w].getIcon()).equals(stage1)) { //적이 위로 움직일때 숫자1이 아닌경우에 움직인다
														if(!(map[e1h-1][e1w].getIcon()).equals(stage2)) { //적이 위로 움직일때 숫자2가 아닌경우에 움직인다
															if(!(map[e1h-1][e1w].getIcon()).equals(stage3)) { //적이 위로 움직일때 숫자3이 아닌경우에 움직인다
																enemyup=map[e1h-1][e1w].getIcon(); //적의 위치를 기준으로 윗칸의 그림을 받아와서 enemyup 이라는 변수에 저장
																map[e1h-1][e1w].setIcon(enemy1); //적을 한칸 위로 움직인다
																map[e1h][e1w].setIcon(enemylocate); //적의 움직이기 바로 직전의 위치에 원래의 이미지를 배치
																enemylocate=enemyup; //enemylocate 변수에 현재 위치의 이미지를 저장
																e1h--; //적의 세로위치 변수에서 1을 뺀다
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
							break;
						case 2: //적이 아래로 움직이는 경우
							if(!(map[e1h+1][e1w].getIcon()).equals(wall)) { //아래로 움직이는 경우 벽이 아닐때 움직이게 한다
								enemydown=map[e1h+1][e1w].getIcon(); //적 기준으로 한칸밑의 이미지를 가져와서 enemydown변수에 저장
								map[e1h+1][e1w].setIcon(enemy1); //적을 한칸 밑으로 이동
								map[e1h][e1w].setIcon(enemylocate); //적이 원래 있던 위치에 원래 있던 이미지를 배치
								enemylocate=enemydown; //enemylocate 변수에 현재 위치의 이미지를 저장
								e1h++; //적의 세로 위치 변수에서 1을 더한다
							}
							break;
						case 3:
							if(!(map[e1h][e1w-1].getIcon()).equals(wall)) { 
								enemyleft=map[e1h][e1w-1].getIcon();
								map[e1h][e1w-1].setIcon(enemy1);
								map[e1h][e1w].setIcon(enemylocate);
								enemylocate=enemyleft;
								e1w--;
							}
							break;
						case 4:
							if(!(map[e1h][e1w+1].getIcon()).equals(wall)) {
								enemyright=map[e1h][e1w+1].getIcon();
								map[e1h][e1w+1].setIcon(enemy1);
								map[e1h][e1w].setIcon(enemylocate);
								enemylocate=enemyright;
								e1w++;
							}
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
		
		final TListener tListener = new TListener();

		Timer t = new Timer(100, tListener);
		t.start();
		
		
		class KListener extends KeyAdapter{ 
			public void keyPressed(KeyEvent e) {
				if(dot<=0) {
					dot = 180;
					e1h=6; e1w=9;
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
					map[6][1].setIcon(dotpoint); map[6][3].setIcon(dotpoint); map[6][5].setIcon(dotpoint); map[6][7].setIcon(dotpoint); map[e1h][e1w].setIcon(enemy1); map[6][12].setIcon(dotpoint); 
					map[6][13].setIcon(dotpoint); map[6][15].setIcon(dotpoint); 
					map[7][1].setIcon(dotpoint); map[7][2].setIcon(dotpoint); map[7][3].setIcon(dotpoint); map[7][5].setIcon(dotpoint); map[7][6].setIcon(dotpoint); map[7][7].setIcon(dotpoint); 
					map[7][8].setIcon(dotpoint); map[7][9].setIcon(dotpoint); map[7][10].setIcon(dotpoint); map[7][11].setIcon(dotpoint); map[7][12].setIcon(dotpoint); map[7][15].setIcon(dotpoint); 
					map[7][16].setIcon(dotpoint); map[7][17].setIcon(dotpoint); 
					map[8][1].setIcon(dotpoint); map[8][3].setIcon(dotpoint); map[8][5].setIcon(dotpoint); map[8][6].setIcon(dotpoint); map[8][12].setIcon(dotpoint); map[8][13].setIcon(dotpoint); 
					map[8][14].setIcon(dotpoint); map[8][15].setIcon(dotpoint); map[8][16].setIcon(dotpoint); map[8][17].setIcon(dotpoint);                                                        map[8][9].setIcon(wall); 
					map[9][1].setIcon(dotpoint); map[9][6].setIcon(dotpoint); map[9][12].setIcon(dotpoint); map[9][13].setIcon(dotpoint); map[9][14].setIcon(dotpoint); map[9][17].setIcon(dotpoint); 
					map[9][18].setIcon(dotpoint);                                                                                                                                            map[9][8].setIcon(black); map[9][9].setIcon(black); map[9][10].setIcon(black);
					map[10][1].setIcon(dotpoint); map[10][3].setIcon(dotpoint); map[10][4].setIcon(dotpoint); map[10][5].setIcon(dotpoint); map[10][6].setIcon(dotpoint); map[10][12].setIcon(dotpoint); 
					map[10][14].setIcon(dotpoint); map[10][16].setIcon(dotpoint); map[10][17].setIcon(dotpoint);                                                                                 map[10][8].setIcon(black); map[10][9].setIcon(black); map[10][10].setIcon(black);
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
					map[17][11].setIcon(dotpoint); map[17][13].setIcon(dotpoint); map[17][14].setIcon(dotpoint); map[17][15].setIcon(dotpoint); map[17][17].setIcon(dotpoint);                       map[ch][cw].setIcon(characterup1); 
					map[18][1].setIcon(dotpoint); map[18][3].setIcon(dotpoint); map[18][5].setIcon(dotpoint); map[18][6].setIcon(dotpoint); map[18][7].setIcon(dotpoint); map[18][9].setIcon(dotpoint); 
					map[18][11].setIcon(dotpoint); map[18][12].setIcon(dotpoint); map[18][13].setIcon(dotpoint); map[18][15].setIcon(dotpoint); map[18][17].setIcon(dotpoint); 
					gamecount = gamecount+1;
					Timer t = new Timer(75, tListener);
					t.start();
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
						map[6][1].setIcon(dotpoint); map[6][3].setIcon(dotpoint); map[6][5].setIcon(dotpoint); map[6][7].setIcon(dotpoint); map[e1h][e1w].setIcon(enemy1); map[6][12].setIcon(dotpoint); 
						map[6][13].setIcon(dotpoint); map[6][15].setIcon(dotpoint); 
						map[7][1].setIcon(dotpoint); map[7][2].setIcon(dotpoint); map[7][3].setIcon(dotpoint); map[7][5].setIcon(dotpoint); map[7][6].setIcon(dotpoint); map[7][7].setIcon(dotpoint); 
						map[7][8].setIcon(dotpoint); map[7][9].setIcon(dotpoint); map[7][10].setIcon(dotpoint); map[7][11].setIcon(dotpoint); map[7][12].setIcon(dotpoint); map[7][15].setIcon(dotpoint); 
						map[7][16].setIcon(dotpoint); map[7][17].setIcon(dotpoint); 
						map[8][1].setIcon(dotpoint); map[8][3].setIcon(dotpoint); map[8][5].setIcon(dotpoint); map[8][6].setIcon(dotpoint); map[8][12].setIcon(dotpoint); map[8][13].setIcon(dotpoint); 
						map[8][14].setIcon(dotpoint); map[8][15].setIcon(dotpoint); map[8][16].setIcon(dotpoint); map[8][17].setIcon(dotpoint);                                                        map[8][9].setIcon(wall); 
						map[9][1].setIcon(dotpoint); map[9][6].setIcon(dotpoint); map[9][12].setIcon(dotpoint); map[9][13].setIcon(dotpoint); map[9][14].setIcon(dotpoint); map[9][17].setIcon(dotpoint); 
						map[9][18].setIcon(dotpoint);                                                                                                                                            map[9][8].setIcon(black); map[9][9].setIcon(black); map[9][10].setIcon(black);
						map[10][1].setIcon(dotpoint); map[10][3].setIcon(dotpoint); map[10][4].setIcon(dotpoint); map[10][5].setIcon(dotpoint); map[10][6].setIcon(dotpoint); map[10][12].setIcon(dotpoint); 
						map[10][14].setIcon(dotpoint); map[10][16].setIcon(dotpoint); map[10][17].setIcon(dotpoint);                                                                                 map[10][8].setIcon(black); map[10][9].setIcon(black); map[10][10].setIcon(black);
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
						map[17][11].setIcon(dotpoint); map[17][13].setIcon(dotpoint); map[17][14].setIcon(dotpoint); map[17][15].setIcon(dotpoint); map[17][17].setIcon(dotpoint);                       map[ch][cw].setIcon(characterup1); 
						map[18][1].setIcon(dotpoint); map[18][3].setIcon(dotpoint); map[18][5].setIcon(dotpoint); map[18][6].setIcon(dotpoint); map[18][7].setIcon(dotpoint); map[18][9].setIcon(dotpoint); 
						map[18][11].setIcon(dotpoint); map[18][12].setIcon(dotpoint); map[18][13].setIcon(dotpoint); map[18][15].setIcon(dotpoint); map[18][17].setIcon(dotpoint); 
						gamecount = gamecount+1;
						Timer t = new Timer(50, tListener);
						t.start();
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
							enemylocate=black;
							ch2 = ch; cw2 = cw;
							ch = 17; cw = 9;
							map[ch][cw].setIcon(characterup1); 
							map[ch2][cw2].setIcon(black);
							life2 = life2 - 1;
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

				}}
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
							enemylocate=black;
							ch2 = ch; cw2 = cw;
							ch = 17; cw = 9;
							map[ch][cw].setIcon(characterup1); 
							map[ch2][cw2].setIcon(black);
							life2 = life2 - 1;
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

				}}
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
							enemylocate=black;
							ch2 = ch; cw2 = cw;
							ch = 17; cw = 9;
							map[ch][cw].setIcon(characterup1); 
							map[ch2][cw2].setIcon(black);
							life2 = life2 - 1;
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

				}}
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
							enemylocate=black;
							ch2 = ch; cw2 = cw;
							ch = 17; cw = 9;
							map[ch][cw].setIcon(characterup1); 
							map[ch2][cw2].setIcon(black);
							life2 = life2 - 1;
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

				}}
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
//			        ResultSet rs = null; 
			        PreparedStatement pstm2 = null;  
//			        ResultSet rs2 = null; 
			        if(kk.equals("로그인 완료 점수를 업데이트 하세요")){
			        try {
			        	String k;

			        	k = name.getText();
			        	
			            String quary = "update guser set point3 = "+point+" where name = '"+k+"' ";
			            System.out.println(quary);
			            String quary2 = "select point3 from guser where name = '"+k+"' ";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
//			            rs = pstm.executeUpdate();
			            pstm.executeUpdate();
			            pstm2 = conn.prepareStatement(quary2);
//			            rs2 = pstm2.executeQuery();
			            pstm2.executeQuery();
			            
						/*
						 * while(rs.next()){ while(rs2.next()){ int scor = rs2.getInt(1); if(scor ==
						 * point) { name1.setText("업데이트 완료"); } else { name1.setText("업데이트 실패"); }
						 * 
						 * }
						 * 
						 * }
						 */} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
//			                if ( rs != null ){rs.close();}   
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
		map[6][1].setIcon(dotpoint); map[6][3].setIcon(dotpoint); map[6][5].setIcon(dotpoint); map[6][7].setIcon(dotpoint); map[6][9].setIcon(black); map[6][12].setIcon(dotpoint); 
		map[6][13].setIcon(dotpoint); map[6][15].setIcon(dotpoint); 
		map[7][1].setIcon(dotpoint); map[7][2].setIcon(dotpoint); map[7][3].setIcon(dotpoint); map[7][5].setIcon(dotpoint); map[7][6].setIcon(dotpoint); map[7][7].setIcon(dotpoint); 
		map[7][8].setIcon(dotpoint); map[7][9].setIcon(dotpoint); map[7][10].setIcon(dotpoint); map[7][11].setIcon(dotpoint); map[7][12].setIcon(dotpoint); map[7][15].setIcon(dotpoint); 
		map[7][16].setIcon(dotpoint); map[7][17].setIcon(dotpoint); 
		map[8][1].setIcon(dotpoint); map[8][3].setIcon(dotpoint); map[8][5].setIcon(dotpoint); map[8][6].setIcon(dotpoint); map[8][12].setIcon(dotpoint); map[8][13].setIcon(dotpoint); 
		map[8][14].setIcon(dotpoint); map[8][15].setIcon(dotpoint); map[8][16].setIcon(dotpoint); map[8][17].setIcon(dotpoint);                                                        map[8][9].setIcon(black); 
		map[9][1].setIcon(dotpoint); map[9][6].setIcon(dotpoint); map[9][12].setIcon(dotpoint); map[9][13].setIcon(dotpoint); map[9][14].setIcon(dotpoint); map[9][17].setIcon(dotpoint); 
		map[9][18].setIcon(dotpoint);                                                                                                                                            map[9][8].setIcon(black); map[9][9].setIcon(enemy1); map[9][10].setIcon(black);
		map[10][1].setIcon(dotpoint); map[10][3].setIcon(dotpoint); map[10][4].setIcon(dotpoint); map[10][5].setIcon(dotpoint); map[10][6].setIcon(dotpoint); map[10][12].setIcon(dotpoint); 
		map[10][14].setIcon(dotpoint); map[10][16].setIcon(dotpoint); map[10][17].setIcon(dotpoint);                                                                                 map[10][8].setIcon(black); map[10][9].setIcon(black); map[10][10].setIcon(black);
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
		new java_assignment_game();
	}

}
