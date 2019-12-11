package java_1211_�⸻���;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class MyFrame extends JFrame implements ActionListener,ItemListener{
	//������ �־�� �� ������	
	Dimension screensize;//��ũ�� ũ�� ���� ����
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	JTextField[] text=new JTextField[2];
	ConcertManager concertManager;
	JTextArea area=new JTextArea();	
	//JComboBox
	MyFrame(String title,ConcertManager concertManager){
		super(title);//������ ��� ���� ����
		kit=Toolkit.getDefaultToolkit();//��
		screensize=kit.getScreenSize(); //ȭ�� ũ�� ����
		container=getContentPane(); //�����̳� ��������
		this.concertManager=concertManager;
		init();
		
		//â ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}
	public void init() {
		//
		
		panel[0]=new JPanel(new GridLayout(1,4));
		panel[0].add(new JLabel("�ܼ�Ʈ �ĺ� ��ȣ : "));
		text[0]=new JTextField(10);
		text[1]=new JTextField(10);
		text[1].addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					area.setText(concertManager.concert.get(text[0].getText()).findFCArea(text[1].getText()));
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "�ܼ�Ʈ�� ���� �����ʽ��ϴ�.");
				}
				
			}
		});
		panel[0].add(text[0]);
		panel[0].add(new JLabel("��Ŭ�� ���� : "));
		panel[0].add(text[1]);
		
		container.add(panel[0],BorderLayout.NORTH);
		
		container.add(new JScrollPane(area));
		
	}
	
	@Override //������ ������
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
			//img ����
			img=kit.getImage(filename);
			
		}
		@Override //�ڱ� �ڽ��� �׸��� �Լ�-������Ʈ�� �ڱ⸦ �׸��� �Լ�
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(img !=null) {
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
		}
	}
	
}
