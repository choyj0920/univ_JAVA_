package java_1209;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.table.DefaultTableModel;
public class MyFrame extends JFrame implements ActionListener,ItemListener{
	//무조건 있어야 할 변수들	
	Dimension screensize;//스크린 크기 담을 변수
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	JButton btn;
	MyDialog dlg=null;
	JTable table;
	DefaultTableModel model;
	String[] colums= {"아이디", "비밀번호","주소","전화번호"};
	
	//색상 ㅡ파일 클릭
	JPanel imgpanel;
	MyPanel mypanel=null;
	JButton colorBtn,fileBtn;
	JLabel img;
	public void init2() {
		panel[1]=new JPanel();
		imgpanel=new JPanel();
		colorBtn= new JButton("색상 선택");
		colorBtn.addActionListener(this);
		fileBtn=new JButton("파일 선택");
		fileBtn.addActionListener(this);
		panel[1].add(colorBtn);
		panel[1].add(fileBtn);
		container.add(panel[1],BorderLayout.NORTH);
		imgpanel=new JPanel();
		img=new JLabel();
		imgpanel.add(img);
		container.add(imgpanel,BorderLayout.CENTER);
	}
	
	//JComboBox
	MyFrame(String title){
		super(title);//생성자 멤버 변수 설정
		kit=Toolkit.getDefaultToolkit();//툴
		screensize=kit.getScreenSize(); //화면 크기 저장
		container=getContentPane(); //컨테이너 가져오기
		
		init2();
		
		//창 띄우기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}
	public void init() {
		//다이얼 로그 생성위한 창
		btn=new JButton("다이얼 로그");
		btn.addActionListener(this);
		panel[0]=new JPanel();
		panel[0].add(btn);
		
		panel[1]=new JPanel();
		container.add(panel[0],BorderLayout.NORTH);
		model =new DefaultTableModel(colums,0);
		table =new JTable(model);
		container.add(new JScrollPane(table),BorderLayout.CENTER);
		
		
	}
	
	@Override //체크 박스 용 아이템 리스너
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub 
		if(e.getStateChange()==ItemEvent.SELECTED) {
			
		}
		else {}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn) {
			if(dlg == null) 
				dlg= new MyDialog(this,"대화상자",false);
			else
				//dlg.setVisible(true);
				dlg.requestFocus();
		}
		else if(e.getSource()==colorBtn) {
			Color color= JColorChooser.showDialog(this, "색상창", Color.GREEN);
			if(color != null) {
				imgpanel.setBackground(color);
			}
		}
		else if(e.getSource()==fileBtn) {
			JFileChooser filedlg=new JFileChooser();
			int result = filedlg.showOpenDialog(this);
			if(result==JFileChooser.APPROVE_OPTION) {
				//선택한 파일 저장
				File file=filedlg.getSelectedFile();
				try { //파일을 읽어 와서 아이콘을 생성해서 -아이콘 설정
					img.setIcon(new ImageIcon(ImageIO.read(file)));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//savedialog, opendialog 각각 파일 저장 , 오픈
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
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
		}
	}
	public static void main(String[] args) {
		MyFrame myframe=new MyFrame("1209실습 || 201810754 조윤직");
	}
}
