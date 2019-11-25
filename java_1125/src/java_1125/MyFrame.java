package java_1125;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener{
	int screenWidth,screenHeight;
	JButton redBtn;
	JButton blueBtn;
	JPanel panel,panel2;
	public MyFrame() {
		// TODO Auto-generated constructor stub
		this("Test Swing");
	}
	public void init() {
		redBtn =new JButton("RED");
		//액션리스너를 연결해줌
		redBtn.addActionListener(this);
		//액션 리스너 연결
		blueBtn =new JButton("BLUE");
		blueBtn.addActionListener(this);
		
		//패널
		panel=new JPanel();//기본레이아웃 플로우
		panel.add(redBtn);
		panel.add(blueBtn);
		// 패널 2
		panel2=new JPanel();
		//컨테이너 가져오기
		Container container=getContentPane(); //기본레이아웃 보더
		//container.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		container.add(panel,BorderLayout.NORTH);
		container.add(panel2);
		//container.setLayout(new FlowLayout()); //디폴트 flowlayout
		
		//borderlayout
//		container.add(redBtn,BorderLayout.NORTH);
//		container.add(blueBtn,BorderLayout.CENTER);
		}
	public MyFrame(String title) {
		super(title);
		init();
		//툴킷 가져오기
		Toolkit kit=Toolkit.getDefaultToolkit();
		//현재 스크린 해상도 가져오기
		Dimension screensize=kit.getScreenSize();
		//멤버 변수 스크린 크기 값으로
		this.screenWidth=screensize.width;
		this.screenHeight=screensize.height;
		//컨테이너 가져오기
		Container contentPane = getContentPane(); 
		//배경 색 설정
		contentPane.setBackground(Color.ORANGE);
		//contentPane.setLayout(new FlowLayout()); //배치 관리자 안하면 크기 엄청 크게-보더가 기본
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		setSize(screenWidth/2,screenHeight/2);
		setLocation(screenWidth/4,screenWidth/4);
		setVisible(true);
		Image img= kit.getImage("png/그림1.png");
		setIconImage(img);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==redBtn) {
			panel2.setBackground(Color.RED);
		}
		else if(e.getSource()==blueBtn) {
			panel2.setBackground(Color.BLUE);
			
		}
	}
}
