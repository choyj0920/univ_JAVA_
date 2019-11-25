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
		//�׼Ǹ����ʸ� ��������
		redBtn.addActionListener(this);
		//�׼� ������ ����
		blueBtn =new JButton("BLUE");
		blueBtn.addActionListener(this);
		
		//�г�
		panel=new JPanel();//�⺻���̾ƿ� �÷ο�
		panel.add(redBtn);
		panel.add(blueBtn);
		// �г� 2
		panel2=new JPanel();
		//�����̳� ��������
		Container container=getContentPane(); //�⺻���̾ƿ� ����
		//container.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		container.add(panel,BorderLayout.NORTH);
		container.add(panel2);
		//container.setLayout(new FlowLayout()); //����Ʈ flowlayout
		
		//borderlayout
//		container.add(redBtn,BorderLayout.NORTH);
//		container.add(blueBtn,BorderLayout.CENTER);
		}
	public MyFrame(String title) {
		super(title);
		init();
		//��Ŷ ��������
		Toolkit kit=Toolkit.getDefaultToolkit();
		//���� ��ũ�� �ػ� ��������
		Dimension screensize=kit.getScreenSize();
		//��� ���� ��ũ�� ũ�� ������
		this.screenWidth=screensize.width;
		this.screenHeight=screensize.height;
		//�����̳� ��������
		Container contentPane = getContentPane(); 
		//��� �� ����
		contentPane.setBackground(Color.ORANGE);
		//contentPane.setLayout(new FlowLayout()); //��ġ ������ ���ϸ� ũ�� ��û ũ��-������ �⺻
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		setSize(screenWidth/2,screenHeight/2);
		setLocation(screenWidth/4,screenWidth/4);
		setVisible(true);
		Image img= kit.getImage("png/�׸�1.png");
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
