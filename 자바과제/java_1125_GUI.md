# java_1125

## JAVA GUI 스윙 기초

## GUI 응용 프로그램

- GUI
  - 사용자가 편리하게 입출력 할수 있도록 그래픽으로 화면을 구성하고, 마우스나 키보드로 입력받을수 있도록 지원하는 사용자 인터페이스
- 자바 언어에서 GUI응용프로그램 작성
  - AWT와 Swing패키지에 강력한 GUI 컴포넌트 제공
  - 쉬운 GUI 프로그래밍
- AWT와 Swing패키지
  - AWT패키지
    - 자바가 처음 나았을 때부터 배포된 GUI패키지 최근에는 거의 사용하지 않음
    - AWT컴포넌트는 중량 컴포넌트

-  Swing 패키지 
  -  AWT 기술을 기반으로 작성된 자바 라이브러리 
  - 모든 AWT 기능 + 추가된 풍부하고 화려한 고급 컴포넌트 
  - AWT 컴포넌트를 모두 스윙으로 재작성. AWT 컴포넌트 이름 앞에 J자 를 덧붙임 
  - 순수 자바 언어로 구현 
  - 스윙 컴포넌트는 경량 컴포넌트(light weight component) 
  - 스윙 컴포넌트는 운영체제의 도움을 받지 않고 직접 그리기 때문에 운영체제에 부담주지 않음
  -  현재 자바의 GUI로 사용됨 

![](http://postfiles6.naver.net/20141001_181/1stwook_1412155705926HWEi7_JPEG/20141001_182741.jpg?type=w2)

### 컨테이너와 컴포넌트

- 컨테이너 
  - 다른 컴포넌트를 포함할 수있는 GUI 컴포넌트
    - java.awt.Container를 상속받음
  - 다른 컨테이너에 포함될수 잇음
    - awt컨테이너 : 패널 프레임 애플릿 다이얼로그 윈도우
    - swing컨테이너, japnel,JFrame,JApplet,JDialog,Jwindow
- 컴포넌트
  - 컨테이너에 포함되어야 화면에 출력될 수있는 GUI객체
  - 다른 컴포넌트를 포함할 수없는 순수 컴포넌트
  - 모든GUI컴포넌트가 상속받는 클래스 :java.awt,component
  - 스윈컴포넌트 상속받는 클래스 :javax.swing.JComponene
- 최상위컨테이너 다른 컨테이너에 포함되지 않고도 화면에 출력,독립적으로 존재가능한 컨테이너

### 컨테이너와 컴포넌트의 포함 관계

#### 최상위 컨테이너를 바닥에 깔고, 그위에 컨테이너를 놓고 다시 컴포넌트를 쌓아가는 방식 , 즉 레고 블록을 쌓는 듯이 GUI프로그램을 작성한다.



## 스윙 GUI프로그램 만들기

- 스윙 GUI프로그램을 만드는 과정

  1. 스윙 프레임 만들기
  2. 스윙 프레임에 스윙 컴포넌트 붙이기

- 스윙 프로그램 작성에 필요한 import문

  ```java
  import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
  import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명
  import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명
  import javax.swing.event.*; // 스윙 이벤트를 위한 경로명
  ```

## 스윙프레임 

### 스윙프레임:모든 스윙 컴포넌트를 담는 최상위 컨테이너

JFrame을 상속받아 구현

컴포넌트들은 화면에 보이려면 스윙 프레임에 부탁되어야함

### 스윙 프레임 기본구성

프레임, 스윙프로그램의 기본틀

메뉴바 -메뉴들이 부착되는 공간

컨텐트 패인- GUI컴포넌트들이 부착되는 공간

### 프레임 만들기, JFrame클래스 상속

- 스윙프레임
  - JFrame클래스를 상속받은 클래스 작성
  - 프레임의 크기 반드시 지정 :setSIze()
  - 프레임을 하면에 출력하는 코드 반드시 필요 : setVIsible(true)

```java
import javax.swing.*;
public class MyFrame extends JFrame {
    MyFrame() {
        setTitle("첫번째 프레임");
        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String [] args) {
        MyFrame mf = new MyFrame();
    }
}
```

```java
//예제 300x300크기의 스윙 프레임 만들기
import javax.swing.*;
public class MyFrame extends JFrame {
    MyFrame() {
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300,300); // 프레임 크기 300x300
        setVisible(true); // 프레임 출력
    }
    public static void main(String[] args) {
    	MyFrame frame = new MyFrame();
    }
}

```



```java
import javax.swing.*;
import java.awt.*;
public class ContentPaneEx extends JFrame {
    ContentPaneEx() {
        setTitle("ContentPane과 JFrame 예제"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼이 클릭 될떄 프레임과 함께 프레임을 종료시키는 방법
        Container contentPane = getContentPane(); // 컨텐트패인 알아내
        기
        contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        contentPane.setLayout(new FlowLayout()); // 컨텐트패인에
        FlowLayout
        // 배치관리자 달기
        contentPane.add(new JButton("OK")); // OK 버튼 달기
        contentPane.add(new JButton("Cancel")); // Cancel 버튼 달기
        contentPane.add(new JButton("Ignore")); // Ignore 버튼 달기
        setSize(300, 150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }
    public static void main(String[] args) {
    new ContentPaneEx();
    }
}

```

### 스윙 응용 프로그램의 종료

응용프로그램 내에서 스스로종료하는 방법

​	System.exit();

-  프레임의 오른쪽 상단의 종료버튼(X)이 클릭되면 어떤 일이 일어나는가? 
  -  프레임 종료, 프레임 윈도우를 닫음 
    - ◼ 프레임이 화면에서 보이지 않게 됨 
  -  프레임이 보이지 않게 되지만 응용프로그램이 종료한 것 아님 
    - ◼ 키보드나 마우스 입력을 받지 못함 
    - ◼ 다시 setVisible(true)를 호출하면, 보이게 되고 이전 처럼 작동함 

### 배치 관리자 대표 유형 4가지

-   FlowLayout 배치관리자 
  -  컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치 ◼
  -  배치할 공간이 없으면 아래로 내려와서 반복한다. 
-  BorderLayout 배치관리자 
  - ◼ 컨테이너의 공간을 동(EAST), 서(WEST), 남(SOUTH), 북(NORTH), 중앙 (CENTER)의 5개 영역으로 나눔
  -  ◼ 5개 영역 중 응용프로그램에서 지정한 영역에 컴포넌트 배치 
- GridLayout 배치관리자 
  - 컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔 
  -  컴포넌트는 삽입 순서대로 좌에서 우로, 다시 위에서 아래로 배치 
-  CardLayout ◼
  -  컨테이너의 공간에 카드를 쌓아 놓은 듯이 컴포넌트를 포개어 배치  

![](https://mblogthumb-phinf.pstatic.net/20160614_1/rain483_1465874010487b3dTf_PNG/213.PNG?type=w800)

### 컨테이너에 새로운 배치 관리자 설정

- 컨테이너에 새로운 배치 관리자 설정
  - setLayout(layoutManager Lm) 메소드 호출
    - lm을 새로운 배치관리자로 설정
  - 사례
    - jpannel



#### FlowLayout 의 생성자

배치 방법 add(컴포넌트)

 생성자 

​	 FlowLayout() 

-  FlowLayout(int align, int hGap, int vGap) 
  - ◼ align : 컴포넌트를 정렬하는 방법 지정. 왼쪽 정렬(FlowLayout.LEFT), 오른쪽 정렬(FlowLayout.RIGHT), 중앙 정렬(FlowLayout.CENTER(디폴트)) 
  - ◼ hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위. 디폴트는 5
  -  ◼ vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위. 디폴트는 5 



#### BorderLayout 배치 관리자

배치 방법 add(컴포넌트,index(동서남북중앙))

생성자

-  BorderLayout() 
-  BorderLayout(int hGap, int vGap) 
  - hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트 : 0) 
  - vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위(디폴트 : 0) 



### 버튼 입력 받을 때

- ##### 버튼 생성

  ```java
  redBtn =new JButton("RED");
  ```

-  버튼 액션 리스너 추가

  ```java
  //액션리스너를 연결해줌
  redBtn.addActionListener(this); //매개로 액션리스터를 구현한 클래스객체가들어감
  ```

- 그 클래스 객체에 액션 리스너 구현

  ```java
  public void actionPerformed(ActionEvent e) {
  		// TODO Auto-generated method stub
  		if(e.getSource()==redBtn) {
  			panel2.setBackground(Color.RED);
  		}
  		else if(e.getSource()==blueBtn) {
  			panel2.setBackground(Color.BLUE);
  			
  		}
  	}
  ```

  