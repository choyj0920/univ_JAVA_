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
	//������ �־�� �� ������	
	Dimension screensize;//��ũ�� ũ�� ���� ����
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	JButton btn;
	MyDialog dlg=null;
	JTable table;
	DefaultTableModel model;
	String[] colums= {"���̵�", "��й�ȣ","�ּ�","��ȭ��ȣ"};
	
	//���� ������ Ŭ��
	JPanel imgpanel;
	MyPanel mypanel=null;
	JButton colorBtn,fileBtn;
	JLabel img;
	public void init2() {
		panel[1]=new JPanel();
		imgpanel=new JPanel();
		colorBtn= new JButton("���� ����");
		colorBtn.addActionListener(this);
		fileBtn=new JButton("���� ����");
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
		super(title);//������ ��� ���� ����
		kit=Toolkit.getDefaultToolkit();//��
		screensize=kit.getScreenSize(); //ȭ�� ũ�� ����
		container=getContentPane(); //�����̳� ��������
		
		init2();
		
		//â ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}
	public void init() {
		//���̾� �α� �������� â
		btn=new JButton("���̾� �α�");
		btn.addActionListener(this);
		panel[0]=new JPanel();
		panel[0].add(btn);
		
		panel[1]=new JPanel();
		container.add(panel[0],BorderLayout.NORTH);
		model =new DefaultTableModel(colums,0);
		table =new JTable(model);
		container.add(new JScrollPane(table),BorderLayout.CENTER);
		
		
	}
	
	@Override //üũ �ڽ� �� ������ ������
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
				dlg= new MyDialog(this,"��ȭ����",false);
			else
				//dlg.setVisible(true);
				dlg.requestFocus();
		}
		else if(e.getSource()==colorBtn) {
			Color color= JColorChooser.showDialog(this, "����â", Color.GREEN);
			if(color != null) {
				imgpanel.setBackground(color);
			}
		}
		else if(e.getSource()==fileBtn) {
			JFileChooser filedlg=new JFileChooser();
			int result = filedlg.showOpenDialog(this);
			if(result==JFileChooser.APPROVE_OPTION) {
				//������ ���� ����
				File file=filedlg.getSelectedFile();
				try { //������ �о� �ͼ� �������� �����ؼ� -������ ����
					img.setIcon(new ImageIcon(ImageIO.read(file)));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//savedialog, opendialog ���� ���� ���� , ����
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
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
		}
	}
	public static void main(String[] args) {
		MyFrame myframe=new MyFrame("1209�ǽ� || 201810754 ������");
	}
}
