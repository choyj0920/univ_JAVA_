# java_1202_GUI2





## 체크박스

JCheckBox의 용도

- 선택과 비선택 두상태만 가지는 버트



- 체크박스 생성

  ![1575250686102](javaCheck박스 생성자)

### 체크박스 이벤트- ItemEvent;

![1575251678133](체크박스이벤트 처리)

리스너 구현

```java
// Item 리스너 구현
class MyItemListener implements ItemListener {
    int sum = 0; // 가격의 합
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getItem() == fruits[0])
                sum += 100;
            else if(e.getItem() == fruits[1])
                sum += 500;
            else
                sum += 20000;
        }
        else {
            if(e.getItem() == fruits[0])
                sum -= 100;
            else if(e.getItem() == fruits[1])
                sum -= 500;
            else
                sum -= 20000;
        }
        sumLabel.setText("현재 " + sum + "원 입니다.");
       }
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
}
```

### JRadio



### JTextField

![1575253693044](JTextField)

### JLabel 줄 바꿈 처럼 하기

```java
JLabel result=new JLabel("<html></html>");
//HTML을 이용해서 수정
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    String str=result.getText(); 
    str=str.replace("</html>", "");
    str+=item[0].getText()+"/"+item[1].getText()+"<br></br>"+"</html>";

    result.setText(str);
			}
```

## TextArea로 여러줄의 입력 창 만들기

-   JTextArea 
  - 여러 줄의 문자열을 입력받을 수 있는 창(텍스트영역) 
    -  스크롤바를 지원하지 않는다. 
    - JScrollPane 객체에 삽입하여 스크롤바 지원받음  

![1575255250694](textArea생성자)

![1575255284348](textArea 만들기예)

![1575255349298](textArea생성자2)

###  JList로 리스트 만들기

-   JList
  -   하나 이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트 
  -  JScrollPane에 JList 컴포넌트를 삽입하여야 스크롤 가능  
- 리스트 생성 
  -  예) 9개의 과일 이름 문자열이 든 리스트 만들기 23 
  - String [] fruits= {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"}; 
  - JList strList = new JList(fruits); 
  - *ListSelectionListener
  -  JList의 getSelectedValue()로 선택된 것 가져오기 



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
	//무조건 있어야 할 변수들	
	Dimension screensize;//스크린 크기 담을 변수
	Container container;
	Toolkit kit;
	JPanel[] panel= new JPanel[5];
	
	
		
	//체크박스 예제 용 변수
	JCheckBox[] check=new JCheckBox[3];
	String[]checktitle= {"냐옹이.jpg","마알.png","그림1.png"};
	MyPanel[] checkimg=new MyPanel[3];
	//라디오 버튼
	JRadioButton[] Radios=new JRadioButton[3];
	ButtonGroup radiobuttonG=new ButtonGroup();
	
	//텍스트 영역
	JLabel textlabel=new JLabel();
	JTextField[] textfield=new JTextField[3];
	//줄이있는 textarea
	JTextArea textarea=new JTextArea(10,20);
	
	//list-패널
	JList list;
	DefaultListModel model;
	
	MyFrame1202(String title){
		super(title);//생성자 멤버 변수 설정
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
		//체크 박스 예제 ,라디오 박스 예제
		panel[0]=new JPanel(); //체크박스에 쓰일 패널
		panel[1]=new JPanel(new GridLayout(2,3)); //그리드로 panel1설정
		panel[2]=new JPanel(); //라디오 버튼 에쓰일 패널
		panel[3]=new JPanel(
				new GridLayout(4, 2)); //텍스트 입력,출력 에쓰일 패널
		for(int i=0;i<check.length;i++) {
			check[i]=new JCheckBox(checktitle[i]);
			panel[0].add(check[i]); //panel
			check[i].addItemListener(this);	
			checkimg[i]=new MyPanel("png/"+checktitle[i]);//각 체크박스에 따른 img설정
			//라디오 버튼 그룹
			Radios[i]=new JRadioButton(checktitle[i]);
			Radios[i].addItemListener(this);
			radiobuttonG.add(Radios[i]);
			panel[2].add(Radios[i]);
		}		
		//체크 박스 예제
		container.add(panel[0],BorderLayout.NORTH);
		container.add(panel[1],BorderLayout.CENTER);
				
		//라디오 버튼
		container.add(panel[2],BorderLayout.NORTH);
		//jTextfield
		textfield[0]=new JTextField(10);//텍스트 필드 생성
		textfield[1]=new JTextField(10);
		textfield[2]=new JTextField(10);
		textfield[2].addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="이름 : "+textfield[0].getText()
						+" 학과 : "+textfield[1].getText()
						+" 학번 :"+textfield[2].getText()+"\n";
				
				textlabel.setText(textlabel.getText()+str);
				textarea.append(str);
				model.addElement(str);
			}
		});
		
		panel[3].add(new JLabel("이름"));
		panel[3].add(textfield[0]);
		panel[3].add(new JLabel("학과"));
		panel[3].add(textfield[1]);
		panel[3].add(new JLabel("학번"));
		panel[3].add(textfield[2]);
		container.add(textlabel,BorderLayout.SOUTH);
		container.add(new JScrollPane(textarea),BorderLayout.EAST);
		container.add(panel[3],BorderLayout.WEST);
		//list 패널
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
	
	@Override //체크 박스 용 아이템 리스너
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
			//img 연결
			img=kit.getImage(filename);
			
		}
		@Override //자기 자신을 그리는 함수-컴포넌트가 자기를 그리는 함수
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			if(img !=null) {
				g.drawImage(img,0, 0, screensize.width/4,screensize.height/4,this);
			}
		}
	}
}