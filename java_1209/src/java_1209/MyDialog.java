package java_1209;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyDialog extends JDialog{
	MyFrame parent;
	JPanel panel;
	JTextField mid;
	JPasswordField mpasswd1;
	JPasswordField mpasswd2;
	JTextField maddr;
	JTextField mtel;
	JButton btn;
	
	public MyDialog(MyFrame frame,String title,boolean modal ) {
		super(frame,title,modal);//��� - ��Ŀ�� ���� ����
		parent=frame;
		init();
		this.setSize(300,300);
		// �� â�� ���� ��Ű�� ���ִ� ����̳� �׷��� ���� - ��â�� ����ǰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	void init(){
		panel=new JPanel(new GridLayout(8,2));
		mid=new JTextField(15);
		mpasswd1=new JPasswordField(15);
		mpasswd2=new JPasswordField(15);
		mpasswd1.setEchoChar('*');
		mpasswd2.setEchoChar('*');
		maddr=new JTextField(15);
		mtel=new JTextField(15);
		btn=new JButton("ȸ�� ����");
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn) {
					String[] data= {
							mid.getText(),
							new String(mpasswd1.getPassword()),
							maddr.getText(),mtel.getText() };
					parent.model.addRow(data);
					parent.dlg.dispose();
					parent.dlg=null;
				}
			}
		});
		mpasswd2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mpasswd2) {
					String pass1 =new String(mpasswd1.getPassword());
					String pass2 =new String(mpasswd2.getPassword());
					if(pass1.equals(pass2)){
						JOptionPane.showMessageDialog(parent.dlg, "��ġ�մϴ�.");
					}
					else
						JOptionPane.showMessageDialog(parent.dlg, "��ġ���� �ʽ��ϴ�.");						
				}
				
				
			}
		});
		panel.add(new JLabel("���̵� : "));
		panel.add(mid);
		panel.add(new JLabel("��� ��ȣ : "));
		panel.add(mpasswd1);
		panel.add(new JLabel("��� ��ȣ Ȯ�� : "));
		panel.add(mpasswd2);
		panel.add(new JLabel("�ּ� : "));
		panel.add(maddr);
		panel.add(new JLabel("��ȭ��ȣ : "));
		panel.add(mtel);		
		panel.add(btn);
		
		this.add(panel);	
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				parent.dlg=null; // null ������ 
				dispose();
			}
		});
	}
	
	
}
