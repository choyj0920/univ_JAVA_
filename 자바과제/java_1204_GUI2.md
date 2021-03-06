# Java_1204 GUI swing

## JComboBox

-  JComboBox 
  -  텍스트필드와 버튼, 그리고 드롭다운 리스트로 구성되는 콤보박스 
  -  드롭다운 리스트에서 선택한 것이 텍스트필드에 나타남

![image-20191204103656559](img\Jcombobox_생성자.png)

## 목차

1.  자바의 이벤트 기반 GUI 프로그램 구조 이해 
2. 이벤트와 이벤트 객체
3. 이벤트 리스너 작성 
4. 어댑터 클래스로 리스너 작성 
5. Key 이벤트로 키 입력 받기 
6. Mouse 이벤트로 마우스 동작 인식 



## 이벤트 기반 프로그래밍

- 이벤트 기반 프로그래밍
  - 이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
    - 이벤트가 발생하면 이벤트를 처리하는 루틴 실행
    - 실행될 코드는 이벤트의 발생에 의해 전적으로 결정
  - 반대되는 개념 : 배치 실행
    - 프로그램의 개발자가 프로그램의 흐름을 결정하는 방식
- 이벤트 기반 응용프로그램의 구조
  - 각이벤트마다 처리하는 리스너 코드 보유
- GUI응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
  - GUI라이브러리 종류
    -  C++의 MFC, C# GUI, Visual Basic, X Window, Android ,등
    - 자바의 AWT와 Swing

### 자바 스윙 프로그램에서 이벤트 처리과정

- 이벤트 처리과정
  1. 이벤트 발생 -마우스, 키보드
  2. 이벤트 객체 생성 -현재 발생한 이벤트에 대한 정보를 가진 객체
  3. 응용프로그램에 작성된 이벤트 리스너 찾기
  4. Event-listener 실행-리스너에 이벤트 객체 전달, 리스너 코드 실행

### 이벤트 객체

#### 이벤트 객체

- 발생한 이벤트에 관한 정보를 가진 객체, 이벤트 리스너에 전달됨

#### 이벤트 객체가 포함하는 정보

- 이번트 종류와 이벤트 소스
- 이벤트가 발생한 화면 좌표및 컴포넌트 내 좌표
- 이벤트가 발생한 버튼이나 메뉴아이템의 문자열
- 클릭된 마우스 버튼 번호 및 마우스의 클릭횟수
- 키의 코드 값과 문자 값
- 체크박스,라디오 버튼 등과  같은 컴포넌트의 이벤트 발생에대한 상태

![image-20191204104615527](img\이벤트 객체_이벤트 소스_경우.png)

### 이벤트 리스너 

- 이벤트를 처리하는 자바 프로그램 코드 ,클래스로 작성

#### 자바는 다양한 리스너 인터페이스 제공

#### 사용자의 이벤트 리스너작성

- 자바의 리스너 인터페이스(interface)를 상속받아 구현
- 리스너 인터페이스의 모든 추상 메소드 구현

![image-20191204104943472](img\이벤트리스너 인터페이스)



- #### 3 가지 방법 

  - 독립 클래스로 작성 
    - 이벤트 리스너를 완전한 클래스로 작성 
    -  이벤트 리스너를 여러 곳에서 사용할 때 적합
  - 내부 클래스(inner class)로 작성 
    -  클래스 안에 멤버처럼 클래스 작성 
    - 이벤트 리스너를 특정 클래스에서만 사용할 때 적합 
  - 익명 클래스(anonymous class)로 작성 
    - 클래스의 이름 없이 간단히 리스너 작성 
    - 클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합

![image-20191204105558048](img\독립클래스 action)



![image-20191204105644150](img\내부 클래스 리스너)



![image-20191204105754132](img\익명클래스 이벤트리스너)

### 어댑터 클래스 

- 이벤트 리스너구현에 따른 부담
  - 여러개의 추상 메소드를 모두 구현해야 하는 부담
- 어댑터 클래스
  - 리스너의 모든 메소드를 단순 리턴하도록 만든클래스
- 추상 메소드가 하나뿐인 액션,아이템등의 어댑터는 존재하지 않음

##### 상속받아 사용

![image-20191204110657877](img\마우스 어댑터)

### 키보드입력

#### 키입력시, 다음 세경우 각각 key이벤트

- keypressed,
- keyreleased,
- keytyped

- 유니코드 키의 특징 
  -  국제 산업 표준 
  - 전 세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계 
  - 문자들에 대해서만 키 코드 값 정의 
    - A~Z, a~z, 0~9, !, @, & 등 
  - 문자가 아닌 키 경우에는 표준화된 키 코드 값 없음
    -  <Function> 키, <Home> 키, <Up> 키,<Delete> 키, <Control> 키, <Shift> 키, <Alt> 등은 플랫폼에 따라 키 코드 값이 다를 수 있음
- 유니코드 키가 입력되는 경우 
  - keyPressed(), keyTyped(), keyReleased() 가 순서대로 호출 
- 유니코드 키가 아닌 경우 
  - keyPressed(), keyReleased() 만 호출됨

![image-20191204113504140](img\가상키와 입력된키 판별)

![image-20191204113516635](img\가상키)



## 다이얼 로그

### 대화상자

대화상자 윈도우는 임시정보를 나타내는데 사용되는 독립적인 서브 윈도우이다.

몇개의 미리 정해진 표준 대화상자는 아주 간단히 만들수 있다.

### 팝업 다이얼로그, JOptionPane

팝업 다이얼로그

사용자에게 메시지를 전달하거나 문자열을 간단히 입력받는 용도

JOptionPane클래스를 이용 생성

입력 다이얼로그

한줄의 입력 받는 다이얼 로그