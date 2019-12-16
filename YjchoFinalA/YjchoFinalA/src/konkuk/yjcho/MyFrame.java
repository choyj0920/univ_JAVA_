package konkuk.yjcho;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyFrame extends JFrame implements ActionListener,ItemListener{
	//������ �־�� �� ������	
	Dimension screensize;//��ũ�� ũ�� ���� ����
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	JList<String> list;
	AuctionManager manager;
	
	JTextArea area;
	
	//JComboBox
	MyFrame(String title,AuctionManager manager){
		super(title);//������ ��� ���� ����
		this.manager=manager;
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
		//���̾� �α� �������� â
		
		panel[0]=new JPanel(new BorderLayout());
		Vector<String> ss=new Vector<String>();
		area=new JTextArea();
		for(Product p: manager.products) {
			ss.add(p.pNum);
		}
		ss.sort(null);
		list=new JList<String>(ss);
		list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					String code=list.getSelectedValue().toString();
					String ss="";
					ss+=manager.showItem(code);
					ss+="\n" +manager.showLowestPrice(code);
					area.setText(ss);
				}

				// TODO Auto-generated method stub
				
			}
		});
		
		container.add(new JScrollPane(list),BorderLayout.WEST);
		container.add(new JScrollPane(area));
		
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
		
	}
}
