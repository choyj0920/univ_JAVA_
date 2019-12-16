package konkuk.yjcho;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyFrame extends JFrame implements ActionListener,ItemListener{
	//무조건 있어야 할 변수들	
	Dimension screensize;//스크린 크기 담을 변수
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	JList<String> list;
	AuctionManager manager;
	
	JTextArea area;
	
	//JComboBox
	MyFrame(String title,AuctionManager manager){
		super(title);//생성자 멤버 변수 설정
		this.manager=manager;
		kit=Toolkit.getDefaultToolkit();//툴
		screensize=kit.getScreenSize(); //화면 크기 저장
		container=getContentPane(); //컨테이너 가져오기
		
		init();
		
		//창 띄우기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(screensize.width/2,screensize.height/2);
		setVisible(true);
	}
	public void init() {
		//다이얼 로그 생성위한 창
		
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
		
	}
}
