package java_1204;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.OptionPaneUI;
public class MyFrame extends JFrame implements ActionListener,ItemListener{
	//무조건 있어야 할 변수들	
	Dimension screensize;//스크린 크기 담을 변수
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	//마우스 액션 예제
	MyPanel mypanel=new MyPanel();
	Point pos=new Point();
	//JComboBox
	MyFrame(String title){
		super(title);//생성자 멤버 변수 설정
		kit=Toolkit.getDefaultToolkit();//툴
		screensize=kit.getScreenSize(); //화면 크기 저장
		container=getContentPane(); //컨테이너 가져오기
	
		init();
		
		//창 띄우기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}	
	public void init() {
		//마우스 액션 예제
		container.add(mypanel,BorderLayout.CENTER);
		mypanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				pos.x=e.getX();
				pos.y=e.getY();
				mypanel.repaint();
			}
		});
		//키보드 액션 예제
		mypanel.requestFocus(); 
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					pos.x-=10; break;
				case KeyEvent.VK_RIGHT:
					pos.x+=10; break;
				case KeyEvent.VK_UP:
					pos.y-=10; break;
				case KeyEvent.VK_DOWN:
					pos.y+=10; break;
				case 'R':
					mypanel.color=new Color(255,0,0); 
					break;
				case 'G':
					mypanel.color=new Color(0,255,0); 
					break;
				case 'B':
					mypanel.color=new Color(0,0,255);
					break;
				}
				mypanel.repaint();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub				
				JOptionPane.showInternalMessageDialog(null, "안녕하세요", "알림", JOptionPane.YES_NO_CANCEL_OPTION);
			}
			
		});
	}
	
	@Override // 아이템 리스너
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
		Color color=new Color(0,0,255);
		MyPanel(String filename){
			//img 연결
			img=kit.getImage(filename);
			
		}
		MyPanel(){
			img=null;
		}
		@Override //자기 자신을 그리는 함수-컴포넌트가 자기를 그리는 함수
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(img !=null) {
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
			else {
				//imgnull이면 도형 그리게
				g.setColor(Color.white);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setColor(color);
				g.fillOval(pos.x, pos.y, 50,50);
			}
			
		}
	}
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
			mypanel.setLocation(x,y);
		}
	};
	public static void main(String[] args) {
		MyFrame myframe=new MyFrame("1204실습");
	}
}
