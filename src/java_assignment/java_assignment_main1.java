package java_assignment;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java_assignment.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class java_assignment_main1 extends JFrame {
	

	JPanel pan1, pan2;
	Font f1, f2;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	JLabel Lb, Lb2, Lb3, k1, k2, k3, k4, k5, k6, k7, k8;
	JTextField t1;
	public java_assignment_main1(){
		setTitle("PACMAN 게임");
		setLayout(null);
		
		ImageIcon p = new ImageIcon("C:\\ppp.jpg");
		f1 = new Font("맑은 고딕", Font.BOLD, 20);
		f2 = new Font("맑은 고딕", Font.BOLD, 10);
		btn2 = new JButton("초급게임 시작");
		btn3 = new JButton("중급게임 시작");
		btn4 = new JButton("상급게임 시작");
		btn5 = new JButton("상급게임 점수확인");
		btn6 = new JButton("중급게임 점수확인");
		btn7 = new JButton("초급게임 점수확인");
		btn8 = new JButton("내 게임 점수확인");
		btn9 = new JButton("");
		Lb = new JLabel("게임하기");
		Lb3 = new JLabel();
		k1 = new JLabel("기록 순위보기");
		k2 = new JLabel("*적 숫자: 1 , 적 속도: 100");
		k3 = new JLabel("*적 숫자: 2 , 적 속도: 100");
		k4 = new JLabel("*적 숫자: 3 , 적 속도: 100");
		k5 = new JLabel("<html>상급게임 순위<br>1등:<br>2등:<br>3등:</html>");
		k6 = new JLabel("<html>중급게임 순위<br>1등:<br>2등:<br>3등:</html>");
		k7 = new JLabel("<html>초급게임 순위<br>1등:<br>2등:<br>3등:</html>");
		k8 = new JLabel("<html>내 게임 점수<br>초급게임:<br>중급게임:<br>상급게임:</html>");
		t1 = new JTextField(25);
		
		Lb.setFont(f1);
		k1.setFont(f1);
		k2.setFont(f2);
		k3.setFont(f2);
		k4.setFont(f2);
		k5.setFont(f1);
		k6.setFont(f1);
		k7.setFont(f1);
		k8.setFont(f1);
		t1.setFont(f1);
		
		Lb3.setIcon(p);
		
		pan1 = new JPanel();
		pan2 = new JPanel();
		
		btn2.setLocation(75, 200);
		btn3.setLocation(75, 400);
		btn4.setLocation(75, 600);
		btn5.setLocation(900, 150);
		btn6.setLocation(900, 300);
		btn7.setLocation(900, 450);
		btn8.setLocation(900, 600);
		btn9.setLocation(900, 800);
		k2.setLocation(75, 300);
		k3.setLocation(75, 500);
		k4.setLocation(75, 700);
		k5.setLocation(375, 100);
		k6.setLocation(375, 250);
		k7.setLocation(375, 400);
		k8.setLocation(375, 550);
		t1.setLocation(900, 700);
		
		Lb3.setLocation(75, 30);
		pan1.setLocation(0, 0);
		pan2.setLocation(300, 0);
		
		btn2.setSize(150, 50);
		btn3.setSize(150, 50);
		btn4.setSize(150, 50);
		btn5.setSize(150, 50);
		btn6.setSize(150, 50);
		btn7.setSize(150, 50);
		btn8.setSize(150, 50);
		btn9.setSize(280, 95);
		k2.setSize(150, 50);
		k3.setSize(150, 50);
		k4.setSize(150, 50);
		k5.setSize(600, 150);
		k6.setSize(600, 150);
		k7.setSize(600, 150);
		k8.setSize(600, 150);
		
		
		Lb3.setSize(150, 100);
		
		pan1.setSize(300, 900);
		pan2.setSize(885, 900);
		
		
		add(k1);
		add(k2);
		add(k3);
		add(k4);
		add(k5);
		add(k6);
		add(k7);
		add(k8);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btn9);
		add(t1);
		add(Lb);
		add(Lb3);
		add(pan1);
		add(pan2);
		pan1.add(Lb);
		pan2.add(k1);
		pan2.add(t1);
		
		pan1.setBorder(new TitledBorder(new LineBorder(Color.red, 5)));
		pan2.setBorder(new TitledBorder(new LineBorder(Color.blue, 5)));
		
		
		btn9.setBorderPainted(false);
		btn9.setContentAreaFilled(false);
		btn9.setFocusPainted(false);
		btn9.setOpaque(false);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new java_assignment_game();
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new java_assignment_game1();
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new java_assignment_game2();
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection conn = null; 
			        PreparedStatement pstm = null;  
			        ResultSet rs = null;  
			        String result2 = "<html>";
			        int i=0;
			        try {
			        	String k;

			        	
			            String quary = "select name, point1 from guser order by point1 desc limit 3";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
			            rs = pstm.executeQuery();
			            
			            while(rs.next()){
			            	String name = rs.getString(1);
			            	int point1 = rs.getInt(2);
			            	
			            	i++;
			            	String result = i+"등 "+ "닉네임: "+ name +"   "+ "점수: " + point1;
			            	result2 = result2 + result + "<br>";
			            	
			            	k5.setText(result2);
			            	  System.out.println(result);   
			            
			            }} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
			                if ( rs != null ){rs.close();}   
			                if ( pstm != null ){pstm.close();}   
			                if ( conn != null ){conn.close(); }
			            }catch(Exception e1){
			                throw new RuntimeException(e1.getMessage());
			            }
			        }
			}
			}
		);
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection conn = null; 
			        PreparedStatement pstm = null;  
			        ResultSet rs = null;
			        String result2 = "<html>";
			        int i=0;
			        try {
			            String quary = "select name, point2 from guser order by point2 desc limit 3";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
			            rs = pstm.executeQuery();
			            
			            while(rs.next()){
			            	String name = rs.getString(1);
			            	int point2 = rs.getInt(2);
			            	
			            	i++;
			            	String result = i+"등 "+"닉네임: "+ name +"   "+ "점수: " + point2;
			            	result2 = result2 + result + "<br>";
			            	
			            	k6.setText(result2);
			            	  System.out.println(result);   
			            
			            }} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
			                if ( rs != null ){rs.close();}   
			                if ( pstm != null ){pstm.close();}   
			                if ( conn != null ){conn.close(); }
			            }catch(Exception e1){
			                throw new RuntimeException(e1.getMessage());
			            }
			        }
			}
			}
		);
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection conn = null; 
			        PreparedStatement pstm = null;  
			        ResultSet rs = null;  
			        String result2 = "<html>";
			        int i = 0;
			        try {
			            String quary = "select name, point3 from guser order by point3 desc limit 3";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
			            rs = pstm.executeQuery();
			            
			            while(rs.next()){
			            	String name = rs.getString(1);
			            	int point3 = rs.getInt(2);
			            	
			            	i++;
			            	String result = i+"등 "+"닉네임: "+ name +"   "+ "점수: " + point3;
			            	result2 = result2 + result + "<br>";
			            	
			            	k7.setText(result2);
			            	  System.out.println(result);   
			            
			            }} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
			                if ( rs != null ){rs.close();}   
			                if ( pstm != null ){pstm.close();}   
			                if ( conn != null ){conn.close(); }
			            }catch(Exception e1){
			                throw new RuntimeException(e1.getMessage());
			            }
			        }
			}
			}
		);
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection conn = null; 
			        PreparedStatement pstm = null;  
			        ResultSet rs = null;  
			        try {
			        	String k = t1.getText();
			        	
			            String quary = "select name, point1, point2, point3 from guser where name = '"+k+"' ";
			            
			            conn = DBconnection.getConnection(); 
			            pstm = conn.prepareStatement(quary);
			            rs = pstm.executeQuery();
			            
			            while(rs.next()){
			            	String name = rs.getString(1);
			            	int point1 = rs.getInt(2);
			            	int point2 = rs.getInt(3);
			            	int point3 = rs.getInt(4);
			            	
			            	String result = "닉네임: "+ name + "  상급점수: " + point1+ "  중급점수: " + point2+ "  초급점수: " + point3;
			            	
			            	k8.setText(result);
			            	  System.out.println(result);   
			            
			            }} catch (SQLException sqle) {
			            System.out.println("SELECT문에서 예외 발생");
			            sqle.printStackTrace();
			            
			        }finally{
			          
			            try{
			                if ( rs != null ){rs.close();}   
			                if ( pstm != null ){pstm.close();}   
			                if ( conn != null ){conn.close(); }
			            }catch(Exception e1){
			                throw new RuntimeException(e1.getMessage());
			            }
			        }
			}
			}
		);
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new java_assignment_hiddenMap();
			}
		});
		
		setSize(1200, 940);
		setVisible(true);
		requestFocus();
		
		
	}
	public static void main(String[] args) {
		new java_assignment_main1();
	}


}