package java_1202;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class MyFrame1202 extends JFrame implements ActionListener,ItemListener{
	//������ �־�� �� ������	
	Dimension screensize;//��ũ�� ũ�� ���� ����
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	
		
	//üũ�ڽ� ���� �� ����
	JCheckBox[] check=new JCheckBox[3];
	String[]checktitle= {"�Ŀ���.jpg","����.png","�׸�1.png"};
	MyPanel[] checkimg=new MyPanel[3];
	//���� ��ư
	JRadioButton[] Radios=new JRadioButton[3];
	ButtonGroup radiobuttonG=new ButtonGroup();
	
	//�ؽ�Ʈ ����
	JLabel textlabel=new JLabel();
	JTextField[] textfield=new JTextField[3];
	//�����ִ� textarea
	JTextArea textarea=new JTextArea(10,20);
	
	//list-�г�
	JList list;
	DefaultListModel model;
	
	MyFrame1202(String title){
		super(title);//������ ��� ���� ����
		kit=Toolkit.getDefaultToolkit();//��
		screensize=kit.getScreenSize(); //ȭ�� ũ�� ����
		container=getContentPane(); //�����̳� ��������
	
		init();
		
		//â ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}
	public void init() {
		//üũ �ڽ� ���� ,���� �ڽ� ����
		panel[0]=new JPanel(); //üũ�ڽ��� ���� �г�
		panel[1]=new JPanel(new GridLayout(2,3)); //�׸���� panel1����
		panel[2]=new JPanel(); //���� ��ư ������ �г�
		panel[3]=new JPanel(
				new GridLayout(4, 2)); //�ؽ�Ʈ �Է�,��� ������ �г�
		for(int i=0;i<check.length;i++) {
			check[i]=new JCheckBox(checktitle[i]);
			panel[0].add(check[i]); //panel
			check[i].addItemListener(this);	
			checkimg[i]=new MyPanel("png/"+checktitle[i]);//�� üũ�ڽ��� ���� img����
			//���� ��ư �׷�
			Radios[i]=new JRadioButton(checktitle[i]);
			Radios[i].addItemListener(this);
			radiobuttonG.add(Radios[i]);
			panel[2].add(Radios[i]);
		}		
		//üũ �ڽ� ����
		container.add(panel[0],BorderLayout.NORTH);
		container.add(panel[1],BorderLayout.CENTER);
				
		//���� ��ư
		container.add(panel[2],BorderLayout.NORTH);
		//jTextfield
		textfield[0]=new JTextField(10);//�ؽ�Ʈ �ʵ� ����
		textfield[1]=new JTextField(10);
		textfield[2]=new JTextField(10);
		textfield[2].addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="�̸� : "+textfield[0].getText()
						+" �а� : "+textfield[1].getText()
						+" �й� :"+textfield[2].getText()+"\n";
				
				textlabel.setText(textlabel.getText()+str);
				textarea.append(str);
				model.addElement(str);
			}
		});
		
		panel[3].add(new JLabel("�̸�"));
		panel[3].add(textfield[0]);
		panel[3].add(new JLabel("�а�"));
		panel[3].add(textfield[1]);
		panel[3].add(new JLabel("�й�"));
		panel[3].add(textfield[2]);
		container.add(textlabel,BorderLayout.SOUTH);
		container.add(new JScrollPane(textarea),BorderLayout.EAST);
		container.add(panel[3],BorderLayout.WEST);
		//list �г�
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
		panel[1].add(new JScrollPane(list));
	}
	
	@Override //üũ �ڽ� �� ������ ������
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub 
		if(e.getStateChange()==ItemEvent.SELECTED) {
			for(int i=0; i<check.length;i++) {
				if(e.getItem()==check[i]) {
					panel[1].add(checkimg[i]);
					panel[1].revalidate();
					panel[1].repaint();
				}			
				if(e.getItem()==Radios[i]) {
					panel[1].add(checkimg[i]);
					panel[1].revalidate();
					panel[1].repaint();
				}	
			}
		}
		else {
			for(int i=0; i<check.length;i++) {
				if(e.getItem()==check[i]) {
					panel[1].remove(checkimg[i]);
					panel[1].revalidate();
					panel[1].repaint();
				}
				if(e.getItem()==Radios[i]) {
					panel[1].remove(checkimg[i]);
					panel[1].revalidate();
					panel[1].repaint();
				}
			}
		}
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
