package java_1202;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class MyFrame extends JFrame implements ActionListener, ItemListener{
	int screenWidth,screenHeight;
	
	String[] setEat= {"�����","����","��"};
	JList<String> strlist=new JList<String>(setEat);
	JList list;
	DefaultListModel model;
	JCheckBox[] check;
	Toolkit kit;
	int sizeset=1;
	Container container;
	JPanel[] panel= {new JPanel(),new JPanel(new GridLayout(1,3))};
	MyPanel[] imgpa=new MyPanel[3];
	JLabel[] label =new JLabel[3];
	JRadioButton[] Rcheck=new JRadioButton[3];
	ButtonGroup group=new ButtonGroup();
	//Jpanel
	JPanel panel3;
	JLabel result=new JLabel("<html></html>");
	
	JTextField[] item=new JTextField[2];
	JTextArea textarea =new JTextArea(10,20);
	public MyFrame() {
		// TODO Auto-generated constructor stub
		this("Test Swing");
	}
	public void init() {
		check=new JCheckBox[3];
		
		panel3=new JPanel(new GridLayout(3,2));
		model=new DefaultListModel();
		list=new JList(model);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting())
					System.out.println(list.getSelectedValue().toString());
			}
		});
		item[0]=new JTextField(10);
		item[1]=new JTextField(10);
		item[1].addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//String str=result.getText(); 
				//str=str.replace("</html>", "");
				//str+=item[0].getText()+"/"+item[1].getText()+"<br></br>"+"</html>";
				String str= item[0].getText()+"/"+item[1].getText()+"\n";
				//textarea.append(str);
				model.addElement(str);
			}
		});
		panel3.add(new JLabel("�̸�"));
		panel3.add(item[0]);
		panel3.add(new JLabel("�а�"));
		panel3.add(item[1]);
		panel[1].add(new JScrollPane(list));
		panel[1].add(new JScrollPane(strlist));
		panel3.add(result);
		
		//�����̳� ��������
		container=getContentPane(); //�⺻���̾ƿ� ����
//		for(int i=0;i<check.length;i++) {
//			check[i]=new JCheckBox(setEat[i]);
//			Rcheck[i]=new JRadioButton();
//			panel[0].add(check[i]);
//			check[i].addItemListener(this);
//			group.add(Rcheck[i]);
//			panel[0].add(Rcheck[i]);
//		}
		
		container.add(panel3,BorderLayout.NORTH);
		
		//container.add(panel[0],BorderLayout.NORTH);
		container.add(panel[1],BorderLayout.CENTER);
		
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
		imgpa[0]=new MyPanel("png/�׸�1.png");
		imgpa[1]=new MyPanel("png/�Ŀ���.jpg");
		imgpa[2]=new MyPanel("png/����.png");
		//contentPane.setBackground(Color.ORANGE);
		//contentPane.setLayout(new FlowLayout()); //��ġ ������ ���ϸ� ũ�� ��û ũ��-������ �⺻
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		for(int i=0;i<3;i++) {
//			label[i]=new JLabel();
//			panel[1].add(imgpa[i]);
//		}
		
		setSize(screenWidth/2,screenHeight/2);
		//setLocation(screenWidth/4,screenHeight/4);
		setVisible(true);
		Image img= kit.getImage("png/�׸�1.png");
		setIconImage(img);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//btn ��ư �׼�����
		//if(e.getSource()==Btn1) {}
		
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
				g.drawImage(img,0, 0, screenWidth/4,screenHeight/4,this);
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED) {
			for(int i=0;i<3;i++)
				if(e.getItem()==check[i]) {
					panel[1].add(imgpa[i]);
					panel[1].revalidate();
					panel[1].repaint();
				}
		}
		else if(e.getStateChange()==ItemEvent.DESELECTED) {
			for(int i=0;i<3;i++)
				if(e.getItem()==check[i]) {
					panel[1].remove(imgpa[i]);
					panel[1].revalidate();
					panel[1].repaint();
				}
		}
	}
}
