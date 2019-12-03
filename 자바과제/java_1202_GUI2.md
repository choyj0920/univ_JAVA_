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