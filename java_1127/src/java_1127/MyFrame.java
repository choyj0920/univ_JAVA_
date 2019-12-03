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
	//btn ��ư
	JButton Btn1;
	JButton Btn2;
	JButton Btn3;
	JButton Btn4;
	JButton Btn5;
	
	Toolkit kit;
	int sizeset=1;
	JPanel panel,panel2,cardPanel;
	boolean toggle=false;
	//�г� 3��, +1
	MyPanel card1,card2,card3,card4;
	CardLayout card;
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		this("Test Swing");
	}
	public void init() {
		redBtn =new JButton("Toggle");
		//�׼Ǹ����ʸ� ��������
		redBtn.addActionListener(this);
		//�׼� ������ ����
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
		//�г�
		panel=new JPanel();//�⺻���̾ƿ� �÷ο�
		//panel.add(redBtn);
		//panel.add(blueBtn);
		panel.add(Btn1);
		panel.add(Btn2);
		panel.add(Btn3);
		panel.add(Btn4);
		panel.add(Btn5);
		// �г� 2
		panel2=new JPanel();
		 
		//�����̳� ��������
		Container container=getContentPane(); //�⺻���̾ƿ� ����
		//container.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		container.add(panel,BorderLayout.NORTH);
		container.add(panel2);
		//container.setLayout(new FlowLayout()); //����Ʈ flowlayout
		//ī�� �г�
		card1=new MyPanel("png/�׸�1.png");
		card2=new MyPanel("png/�Ŀ���.jpg");
		card3=new MyPanel("png/����.png");
		card=new CardLayout();
		cardPanel=new JPanel(card);
		//ī�� �г��� ī�巹�̾ƿ��� �ƴ�  �г� ������
		//������ ������
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
		//��Ŷ ��������
		
		//���� ��ũ�� �ػ� ��������
		Dimension screensize=kit.getScreenSize();
		//��� ���� ��ũ�� ũ�� ������
		this.screenWidth=screensize.width;
		this.screenHeight=screensize.height;
		//�����̳� ��������
		Container contentPane = getContentPane(); 
		//��� �� ����
		//contentPane.setBackground(Color.ORANGE);
		//contentPane.setLayout(new FlowLayout()); //��ġ ������ ���ϸ� ũ�� ��û ũ��-������ �⺻
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		setSize(screenWidth/2,screenHeight/2);
		//setLocation(screenWidth/4,screenHeight/4);
		setVisible(true);
		Image img= kit.getImage("png/�׸�1.png");
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
		//btn ��ư �׼�����
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
			//img ����
			img=kit.getImage(filename);
			
		}
		@Override //�ڱ� �ڽ��� �׸��� �Լ�-������Ʈ�� �ڱ⸦ �׸��� �Լ�
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(img !=null) {
				g.drawImage(img,0, 0, screenWidth/2,screenHeight/2,this);
			}
		}
	}
}
