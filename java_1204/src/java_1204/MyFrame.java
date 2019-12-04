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
	//������ �־�� �� ������	
	Dimension screensize;//��ũ�� ũ�� ���� ����
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	//���콺 �׼� ����
	MyPanel mypanel=new MyPanel();
	Point pos=new Point();
	//JComboBox
	MyFrame(String title){
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
		//���콺 �׼� ����
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
		//Ű���� �׼� ����
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
				JOptionPane.showInternalMessageDialog(null, "�ȳ��ϼ���", "�˸�", JOptionPane.YES_NO_CANCEL_OPTION);
			}
			
		});
	}
	
	@Override // ������ ������
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
			//img ����
			img=kit.getImage(filename);
			
		}
		MyPanel(){
			img=null;
		}
		@Override //�ڱ� �ڽ��� �׸��� �Լ�-������Ʈ�� �ڱ⸦ �׸��� �Լ�
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(img !=null) {
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
			else {
				//imgnull�̸� ���� �׸���
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
		MyFrame myframe=new MyFrame("1204�ǽ�");
	}
}
