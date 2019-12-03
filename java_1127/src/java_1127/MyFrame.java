package java_1127;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener{
	int screenWidth,screenHeight;
	JButton redBtn;
	JButton blueBtn;
	//btn 버튼
	JButton Btn1;
	JButton Btn2;
	JButton Btn3;
	JButton Btn4;
	JButton Btn5;
	
	Toolkit kit;
	int sizeset=1;
	JPanel panel,panel2,cardPanel;
	boolean toggle=false;
	//패널 3개, +1
	MyPanel card1,card2,card3,card4;
	CardLayout card;
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		this("Test Swing");
	}
	public void init() {
		redBtn =new JButton("Toggle");
		//액션리스너를 연결해줌
		redBtn.addActionListener(this);
		//액션 리스너 연결
		blueBtn =new JButton("BLUE");
		blueBtn.addActionListener(this);
		Btn1=new JButton("Btn1");
		Btn2=new JButton("Btn2");
		Btn3=new JButton("Btn3");
		Btn4=new JButton("<<");
		Btn5=new JButton(">>");
		Btn1.addActionListener(this);
		Btn2.addActionListener(this);
		Btn3.addActionListener(this);
		Btn4.addActionListener(this);
		Btn5.addActionListener(this);
		//패널
		panel=new JPanel();//기본레이아웃 플로우
		//panel.add(redBtn);
		//panel.add(blueBtn);
		panel.add(Btn1);
		panel.add(Btn2);
		panel.add(Btn3);
		panel.add(Btn4);
		panel.add(Btn5);
		// 패널 2
		panel2=new JPanel();
		 
		//컨테이너 가져오기
		Container container=getContentPane(); //기본레이아웃 보더
		//container.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		container.add(panel,BorderLayout.NORTH);
		container.add(panel2);
		//container.setLayout(new FlowLayout()); //디폴트 flowlayout
		//카드 패널
		card1=new MyPanel("png/그림1.png");
		card2=new MyPanel("png/냐옹이.jpg");
		card3=new MyPanel("png/마알.png");
		card=new CardLayout();
		cardPanel=new JPanel(card);
		//카드 패널은 카드레이아웃이 아닌  패널 에넣음
		//컴포는 컴포에
		cardPanel.add(card1,"1");
		cardPanel.add(card2,"2");
		cardPanel.add(card3,"3");
		container.add(cardPanel,BorderLayout.CENTER);
		//borderlayout
//		container.add(redBtn,BorderLayout.NORTH);
//		container.add(blueBtn,BorderLayout.CENTER);
		}
	public MyFrame(String title) {
		super(title);
		kit=Toolkit.getDefaultToolkit();
		init();
		//툴킷 가져오기
		
		//현재 스크린 해상도 가져오기
		Dimension screensize=kit.getScreenSize();
		//멤버 변수 스크린 크기 값으로
		this.screenWidth=screensize.width;
		this.screenHeight=screensize.height;
		//컨테이너 가져오기
		Container contentPane = getContentPane(); 
		//배경 색 설정
		//contentPane.setBackground(Color.ORANGE);
		//contentPane.setLayout(new FlowLayout()); //배치 관리자 안하면 크기 엄청 크게-보더가 기본
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		setSize(screenWidth/2,screenHeight/2);
		//setLocation(screenWidth/4,screenHeight/4);
		setVisible(true);
		Image img= kit.getImage("png/그림1.png");
		setIconImage(img);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==redBtn) {
			//panel2.setBackground(Color.RED);
			//setSize(screenWidth/(++sizeset%4+1),screenHeight/(sizeset%4+1));
			toggle = !toggle;
			setSize(screenWidth/(toggle?4:2),screenHeight/(toggle?4:2));
			
			
		}
		else if(e.getSource()==blueBtn) {
			panel2.setBackground(Color.BLUE);
			
		}
		//btn 버튼 액션정의
		if(e.getSource()==Btn1) {
			card.show(cardPanel, "1");
		}
		if(e.getSource()==Btn2) {
			card.show(cardPanel, "2");
		}
		if(e.getSource()==Btn3) {
			card.show(cardPanel, "3");
		}
		if(e.getSource()==Btn4) {
			card.previous(cardPanel);
		}
		if(e.getSource()==Btn5) {
			card.next(cardPanel);
		}
	}
	
	class MyPanel extends JPanel{
	
		Image img;
		MyPanel(String filename){
			//img 연결
			img=kit.getImage(filename);
			
		}
		@Override //자기 자신을 그리는 함수-컴포넌트가 자기를 그리는 함수
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(img !=null) {
				g.drawImage(img,0, 0, screenWidth/2,screenHeight/2,this);
			}
		}
	}
}
