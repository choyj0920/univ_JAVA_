package java_1211_기말대비;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class MyFrame extends JFrame implements ActionListener,ItemListener{
	//무조건 있어야 할 변수들	
	Dimension screensize;//스크린 크기 담을 변수
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	JTextField[] text=new JTextField[2];
	ConcertManager concertManager;
	JTextArea area=new JTextArea();	
	//JComboBox
	MyFrame(String title,ConcertManager concertManager){
		super(title);//생성자 멤버 변수 설정
		kit=Toolkit.getDefaultToolkit();//툴
		screensize=kit.getScreenSize(); //화면 크기 저장
		container=getContentPane(); //컨테이너 가져오기
		this.concertManager=concertManager;
		init();
		
		//창 띄우기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}
	public void init() {
		//
		
		panel[0]=new JPanel(new GridLayout(1,4));
		panel[0].add(new JLabel("콘서트 식별 번호 : "));
		text[0]=new JTextField(10);
		text[1]=new JTextField(10);
		text[1].addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					area.setText(concertManager.concert.get(text[0].getText()).findFCArea(text[1].getText()));
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "콘서트가 존재 하지않습니다.");
				}
				
			}
		});
		panel[0].add(text[0]);
		panel[0].add(new JLabel("팬클럽 지부 : "));
		panel[0].add(text[1]);
		
		container.add(panel[0],BorderLayout.NORTH);
		
		container.add(new JScrollPane(area));
		
	}
	
	@Override //아이템 리스너
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub 
		if(e.getStateChange()==ItemEvent.SELECTED) {
			
		}
		else {}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
		}
	}
	
}
