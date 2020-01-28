# java_0909

## 정적 비정적 멤버 함수

```java
package konkuk.sw;

public class TestMain {

	public static void lab01() {
		System.out.println("첫번째 실습");
	}
	public void lab02() {
		System.out.println("두번째 실습");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		//lab01는 정적 멤버이므로 객체생성 전에도 클래스 정보만 있다면 사용할수 있다.
		lab01();
		// lab02(); 오류 lab02는 정적 멤버가 아니므로 객체가 생성되야 호출할 수있다.
		TestMain TM= new TestMain();
		TM.lab02();
		//정적 멤버 함수도 객체에서도 액세스 할수 있다.
		TM.lab01();
		//모든 객체마다 다 같은 함수 정적멤버함수로 객체마다 다 다르면 비정적멤버함수론
	}

}

```

## 타입 변환과 자동 타입 변환

### 타입변환

한타입의 값을 다른 타입의 값으로 변환

### 자동 타입 변환

- 컴파일러에 의해 원래의 타입보다 큰 타입으로 자동 변환

- 치환문이나 수식 내에서 타입이 일치하지 않을 때

  ㅇㅇ

### 강제 타입 변환

- 개발자의 의도적 타입 변환
- ()안에 개발자가 명시적으로 타입 변환 지정

```java
int n= 300;
byte b =(byte)n //타입 변환
int a =65;
System.out.println((char)a);
System.out.printf("%c\n",a);
```

## 자바의 키 입력과 System.in

### System.in

입력한키를 바이트로 반환함.. 

## Scanner와 Scanner 객체 생성

### Scanner 클래스

읽은 바이트를 문자 정수 실수 불린 문자열 등 다양한타입으로 변환하여 리턴

```java
import.java.util.Scanner

Scanner a =new Scanner(System.in); //스캐너 객체 생성
```

### Scanner에서 키 입력 받기 

Scanner는 입력 되는 키 값을 공백으로 구분되는 토큰 단위로 읽음

공백문자 \t, \f , \r,  \n

### 개발자가 원하는 타입 값으로 쉽게 읽을 수 있음

사용자의 키입력 Kim seoul 20 65.1 true;

```java
Scanner scanner = new Scanner(System.in);
Scanner scanner = new Scanner(System.in);
String name = scanner.next(); // "Kim" 
String city = scanner.next(); // "Seoul" 
int age = scanner.nextInt(); // 20 
double weight = scanner.nextDouble(); // 65.1
boolean single = scanner.nextBoolean(); // true


```

### 메소드

close는 종료하면 System.in을 이제 못해서 입력이 정말 다끝났을때 사용

```java
import java.util.Scanner;
public class ScannerEx { public static void main(String args[]) { System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요");
Scanner scanner = new Scanner(System.in); String name = scanner.next(); System.out.println("당신의 이름은 " + name + "입니다."); 
String city = scanner.next(); System.out.println("당신이 사는 도시는 " + city + "입니다."); 
                                                                 int age = scanner.nextInt(); 
                                                                 System.out.println("당신의 나이는 " + age + "살입니다."); double weight = scanner.nextDouble(); // 실수 토큰 읽기 System.out.println("당신의 체중은 " + weight + "kg입니다."); boolean single = scanner.nextBoolean(); System.out.println("당신은 독신 여부는 " + single + "입니다.");
scanner.close();
}
}

```

## 비트 연산자 

```

```



## 조건 연산자 ?:

#### op1? op2:op3

```java
int x= 5, y=3;
int big;
if(x>y)
	big=x;	
else
    big =y;
```

```java
int x= 5, y=3;
int big = (x>y)?x:y; 
```

# java_0911

## switch문 

스위치문의 비교 값과 일치하면 해당 case의 실행 문장 수행

break를 만나면 스위치 문을 벗어남

case의 비교 값과 일치하는 것이 없으면 default 문 실행

default 문은 생략 가능

### case문의 값

문자, 정수 문자열 리터럴(1.7부터) 만 허용

실수 리터럴은 허용되지 않음

### 의도적 break; 생략

```java
switch(naa){
    case 1:
    case 2:
    case 3:
        system.out.println("겨울 입니다");
}
```

### 가위 바위 보

```java
package software.java0911;
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class testmain {
	
	public static void lab01() {
		//import java.util.Random;
		//-2123123312~ 214743647 숫자 하나반환
		Random r =new Random();
		//int com =Math.abs(r.nextInt()%3)+1;
		int com = r.nextInt(3)+1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("가위 바위 보 중에 선택 하세요(가위 :1, 바위 :2 ,보 : 3) : ");
		int user = scanner.nextInt();
		System.out.println("컴퓨터("+com+"),사용자("+user+")");
		if(user ==com )
			System.out.println("비겼습니다.\n");
		else
			switch(user -com) {
			case -2:
			case 1:
				System.out.println("이겼습니다 \n");
				break;
			case 2:
			case -1:
				System.out.println("졌습니다 \n");
				break;
				
			}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		lab01();
	}

}


```

## do -while~

```java
package software.java0911;
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class testmain {
	
	public static void lab01() {
		//import java.util.Random;
		//-2123123312~ 214743647 숫자 하나반환
		Random r =new Random();
		//int com =Math.abs(r.nextInt()%3)+1;
		int com,user;
		char a;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("가위 바위 보 중에 선택 하세요(가위 :1, 바위 :2 ,보 : 3) : ");
			user = scanner.nextInt();
			com = r.nextInt(3)+1;
			System.out.println("컴퓨터("+com+"),사용자("+user+")");
			if(user ==com )
				System.out.println("비겼습니다.\n");
			else
				switch(user -com) {
				case -2:
				case 1:
					System.out.println("이겼습니다 \n");
					break;
				case 2:
				case -1:
					System.out.println("졌습니다 \n");
					break;
					
				}
			System.out.println("종료 하시겠습니까?(종료 :n) :");
			String str1 =scanner.next();
			a = str1.charAt(0);
		}while(a != 'n');  //string을 사용했을 경우 answer.equals("no") 문자열 비교 
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		lab01();
	}

}
```

### cotinue문

 이번 반복을 마치고 바로 다음 반복으로 넘어감

### break 문

반복문 하나를 즉시 벗어갈 때 사용

- 하나의 반복문만 벗어남
- 중첩 반복의 경우 안쪽 반복문의 break문이 실핼 되면 안쪽 반복문만 벗어남

# java_0916

## 배열

### 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료 구조

한번에 많은 메모리 공간 선언 가능

### 연속적인 공간에 할당되는 자료구조

연속적인 공간안에 잡힘 연속적으로 할당될수 없으면 배열 x, 

### 배열은 같은 타입의 데이터들이 순차적으로 저장되는 공간

- 원소 데이터들이 순차적으로 저장됨
- 인덱스를 이용하여 원소 데이터 접근
- 반복문을 이용하여 처리하기에 적합한 자료 구조



### 배열을 잘 이해하고 다룰 것.

```java
//배열 선언
int intarray [];  // 또는
int[] intarray;
int intarray[5]; //절대 안됨 크지기정 안됨
//배열 생성
intarray =new int[5];
int intarray[] = new int[5];
//배열 초기화
int intarray[] = {4,3,2,1,0};

```

##### 배열 자체는 스택영역, 배열 안의 값들 힙영역에 저장,

##### 자바는 자동으로 메모리  해제가 됨 

##### 자바 자동으로 배열 안의 값들 디폴트값으로 다 초기화 숫자 계열 0으로 문자계열 NULL로 초기화 booleand은 false로 

##### 배열의 인덱스번호는 0부터 

nullpointer오류 

```java
int[] intarr = {10,20,30,40};
int[] intarr = new int [5];
int[] intarr = new int[] {10,20,30,40};

// 배열.length이용..
for(int i =0 ;i<intarr.length; i++) {
			System.out.println(intarr[i]);
		}
```

c언어와 달리 배열이름은  c언어 처럼 주소 상수가 아니라 자바는 주소 변수 이다 주소 값 변경 가능 -> 다른 배열의 주소값을 받아와서 새로 초기화 가능..

자바에서 배열의 이름 변수ㅜㅜ!

크기는 고정이긴 해 

### 배열 복사 

##### 배열 방대방 복사

```java
//배열 복사
for(int i =0 ;i<3; i++) {
			arrcopy[3 + i] = intarr[i];
		}
//정의 되어 있는 배열 복사 함수
System.arraycopy(가져올 배열, 몇 번부터 복사?, 복사 받을 배열, 복사받을 시작점, 몇개 복사);
```

### 배열과 for-each 문

```java
int n[]={1,2,3,4,5};
int sum = 0;
for(int k : n){
    sum += k;
}

//예2
for(int i : intarr) {
	System.out.println(i);
}
```

### 참조타입 특: 이전에 같은 값으로 초기화 되있던 변수 가있었으면, 초기화할때 같은 주소 값을 참조하게 됨

```java
String name1 = "Greenjoa";
String name2 = "Greenjoa";
name1 == name2;  =>true;  //문자열을 할당 할 때 이전에 선언 된 값이 있으면 그 주소를 참조하게됨, 
//but,
String name3 =new String("Greenjoa");  //앞에 new 가 붙으면 무조건 새로 생성 이전에 Greenjoa가 있었어도 새롭게생성.
```

정렬 알고리즘, 중복체크 알고리즘 적어도 하나는암기 하고 있어야함 !

# java_0918

```java
	public static void main(String[] args) { //배열이 매게로 들어오는 main
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		lab01();
	}
```

 프로젝트 우클릭 run as -> run confi~~-> 프로젝트 ->argument에서 들어올 string 저장 가능

### 문자열 int 변환

```java
Integer.parseInt(String);
```

## 이차원 배열 

```java
num = new int[2][3];

num[2]= new int [5]; //가능!

num.length =2;
num[0].length =3;
num[2].length =5;
```

### 선언과 동시 초기화

```java
int intArray[][] ={{14,5,5},{2,12,5},{1,2,3}};
//intArray[][] ={{14,5,5},{2,12,5},{1,2,3}}; 이렇게 는 X
```

```java
int [][] num;
num = new int[5][];
num[0] =new int[2];
num[1] = new int [10];
num[2] =new int [5];
.
.
num[4]= new int [5];
```

4 2 3 1

1 2 3 4

2 134

3124

4123

4321

# java_0923

## 메소드의 배열 리턴

### 배열리턴

	배열의 래퍼런스만 리턴(배열 전체가 리턴 되는 것이 아님)

### 메소드의 리턴 타입

	리턴하는 배열 타입과 리턴받는 배열 타입 일치
	
	리턴 타입에 배열의 크기를 지정하지 않음

```java
int[] makeArray(){
    int temp[] =new int[4];
    return temp;
}
```

## 파일 입출력

 파일의 끝은 항상 엔터로 끝나야함 !

자바의 경로 (실행하는곳) 과  소스코드의 위치는 다르다

프로젝트 폴더가 기본 경로..

## 예외 처리

자바는 에러가 발생하면 프로그램에서 예외처리를 안할 경우 무조건 프로그램 종료

```java
try{
    //예외가 발생할 가능성이 있는 문
}
catch(처리할 예외 타입 선언){
    예외 처리문
}
finally{
    //예외 처리에 상관 없이 실행할 문장
}
```

### 자바의 예외  클래스.

### catch

캐치문도 순서가 중요 catch(Exception e)는 맨 나중에

```java
public static void main(String[] args) {
		System.out.println("201810754 조윤직");
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 =Integer.parseInt(args[2]);
			Class classes = Class.forName("java.lang.String");
			System.out.println("합 = "+(num1+num2));
		}catch(NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("인수의 타입 체크하세요!!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열인자 범위 체크");
		}catch(Exception e) {  //이거는 맨 나중에~
			System.out.println("예외 처리 요망");
		}
		
	}
```

# java_0925

## 자바 콘솔에서 컴파일, 실행

```java
	while(true) {
			try {	
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
				System.out.println("201810754 조윤직");
				Thread.sleep(1000);
				new ProcessBuilder("cmd", "/c","pause").inheritIO().start().waitFor();
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

```

cmd에서 cd 경로 명령어로  위치 이동

javac로 클래스 생성 java로 실행



## 자바 클래스

### 캡슐화 : 객체를 캡슐로 싸서 내부를 볼 수 없게 하는 것

객체의 가장 본질 적인 특징

객체 생성된 실체

### 

### 상속 

상위 개체의 속성이 하위 개체에 물려짐





### 

# java_0930

## 클래스

### 생성자

- 객체가 생성될때 초기화 목적으로 실행되는 메소드
- 객체가 생성되는 순간에 자동 호출
- 생성자 이름은 클래스 이름과 동일
- 생성자는 여러개 작성 가능(생성자 중복)생성자 오버로딩

#### 생성자는 객체 생성시 한번만 호출.

자바 객체 생성 반드시 new 키워드로 

생성자의 목적은 객체 생성시 초기화

생성자는 리턴타입을 지정할수 없음



### This 객체 자신을 가리킴

- static 사용 x

### this() 로 다른 생성자 호출

- 같은 클래스의 다른 생성자 호출
- 생성자 내에서만 사용 가능
- 생성자 코드의 제일 처음에 있어야 함

```java
	TV() {
		this(10,10);
	}
	TV(int channel,int Volume) {
		this.chanel =channel;
		this.volumae =Volume;
	}
	TV(int channel) {
		this(channel,10);
	}
	
```



### 객체 배열 생성

```java
Vehicle [] vehicles =new Vehicle[5];
		vehicles[0] =new Vehicle("빨강색");
		vehicles[1] =new Vehicle("파랑색");
		vehicles[2] =new Vehicle("노랑색");
		vehicles[3] =new Vehicle("보라색");
		
		CarUser user1 =new CarUser("HY");
		for(int i=0;i<4;i++) {
			user1.accelerate(vehicles[i], i+10);
			user1.move(vehicles[i]);
		}
```

### 메소드 인자 전달 

기본 타입 을 제외하고 모든타입은 주소값으로 전달.

기본타입은 복사해서 전달 .

그래서 기본 타입 변수는 은 메소드내에서 바꿔도 원본은 안변함

그래서 기본타입이 아닌 변수는 은 메소드내에서 바꿔면 원본도 변함

# JAVA_1002

### 오버로딩

한클래스내에서 두 개 이상의 이름이 같은 메소드 작성

- 메소드 이름이 동일하여야함
- 매개변수의 개수가 서로 다르거나, 타입이 달라야함
- 리턴 타입은 오버로딩과 관련 없음

## 자바는 객체 소멸 임의로 못함...

좋을수도 . 나쁠수도 



## 자바 패키지 

관련있는 클래스를 저장하여 관리하는 디렉터리

자바응용프로그램은 하나이상의 패키지로 구성

## 접근 지정자 

#### 자바의 접근지정자 4가지

#### private 

맴버 외부로 부터 완벽차단 그 객체 자신만 사용 가능

#### default,

객체자신과 , 동일 패키지 내에 다른 객체들, 자식 객체도 다른 패키지 일경우 디폴트는 접근 x

#### protected 

동일 패키지 와 자식 클래스에 허용

#### public 

모든 클래스 모두 접근가능

### 접근 지정 -클래스, 클래스 맴버 변수, 클래스 맴버 함수 다 가능 

## toString

원래 객체 자체에 내장된 함수 

##### 오버 로딩

해서 객체를 출력하면 원하는 객체의 정보를 출력하게 할수 있음

# java_1009

## 복사 생성자 ! ~~



## 초기화 블럭

### 클래스 초기화 블럭

클래스변수의 복잡한 초기화에 사용

### 인스턴스 초기화 블록

인스턴스변수의 복잡한 초기화에 사용

```java
class Initblock{
    static int[] arr = new int[10];
    static{
        for(int i = 0;i<arr.length;i++){
            arr[i]= int(Math.random()*10) + 1;
        }
    }
}
```

# java_1014

## 상속

객체지향 상속
클래스를 재활용 방법중 하나, -다른 방법은 멤버로 클래스 객체를 가지고 있는것

상속

```java
class Child extends Parent{
    
}
```

### 자바는 다중 상속이 안된다

부모는 꼭 한명 뿐이여야 한다

- 조상 클래스 : 부모 클래스, 상위 클래스, 기반 클래스 
- 자손 클래스 : 자식 클래스, 하위 클래스, 파생된 클래스 

### 상속과 포함은 다르다!

#### 포함관계: 클래스의 멤버변수로 다른 클래스를 선언 하는 것

가지고 있다 라는 관계가 성립 할 때

#### 상속 관계 :~은 ~이다 (is-a)관계가 성립 할 때

### 상속 선언

extends 키워드로 선언 : 부모 클래스를 물려 받아 확장한다는 의미

인터페이스로 다중 상속 가능

### 슈퍼 클래스의 멤버에 대한 서브 클래스의 접근

private, default protected public

###  서브 클래스의 객체가 생성될 때 

#### 슈퍼클래스 생성자와 서브 클래스 생성자 모두 실행 

#### 호출 순서 

- #### 서브 클래스의 생성자 먼저 호출, 

- #### 서브 클래스의 생성자는 실행 전 슈퍼 클래스 생성자 호출 

#### 실행 순서

- #### 슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자 실행 

### 서브클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식

1. #### 개발자의 명시적 선택

   - 서브 클래스 개발자가 슈퍼클래스의 생성자 명시적 선택
   - super()키워드를 이용하여 선택

2. #### 컴파일러가 기본생성자 선택

   - 서브 클래스 개발자가 슈퍼클래스의 생성자를 선택하지 않은 경우
   - 컴파일러가 자동으로 슈퍼클래스의 기본생성자 선택

항상 서브클래스 생성자 코드의 제일 첫 라인에 와야함

### 업캐스팅 -자식을 부모로 

> **다 참조 주소이니까 업캐스팅다운캐스팅이 가능한 거겠지?**

부모는 모든 자식을 가리킬수 있다. 

업캐스팅은 자식을 꼭 명시해주어야함



```java
class Person{}
class Student extends Person{}

Person p;
Student s =new Student;
p=s;//업캐스팅
//이때 p.grade  처럼 자식클래스 접근 불가 슈퍼크랠스의 멤버만 접근가능 p자체가 슈퍼클래스의 레퍼런스 이므로
```



### 다운캐스팅- 부모를 자식으로 이전에 업캐스팅 된것만 가능

*실제로 부모가 가리키고 있던 객체가 자식 객체 였던 경우*  다시 자식객체로 만들어줄수 있다 

```java
class Person { }
class Student extends Person { }
Person p = new Student("이재문"); // 업캐스팅
Student s = (Student)p; // 다운캐스팅, 강제타입변환
```

### instanceof 연산자

```java
객체 레퍼런스 instanceof 클래스타입 boolean
```

# JAVA_1016

## 저번 수업

- 상속

- super, this

- 업캐스팅 다운 캐스팅

- instance of 연산자: 실제 인스턴스가 어떤 인스턴스 인지 판단 

  업캐스팅은 부모이름으로 자식 담기, 다운캐스팅은 그 객체를 다시 자식으로~

## 메소드 오버라이딩의 개념

### 메소드 오버라이딩

- 서브 클래스에서 슈퍼클래스의 메소드 중복 작성
- 슈퍼클래스의 메소드 무력화, 항상 서브클래스에 오버라이딩 한 메소드가 실행되도록 보장됨
- 메소드 무시하기로 번역 되기도함 

#### 오버라이딩 조건

- 슈퍼 클래스의 메소드의 원형- 메소드의 이름 인자타입의 개수 리턴 타입 등이 동일하게 작성되어야 한다

## 다형성

- 여러가지 형태를 가질 수 있는 능력을 의미
- 자바에서는 한 타입의 참조변수로 여러타입의 객체를 참조
  - 조상클래스 타입의 참조변수로 자손 클래스의 인스턴스 참조
  - 자손 타입의 참조 변수는 조상 클래스의 인스턴스를 참조할 수 없음

### 매개변수의 다형성

```java
class Product {
int price;
int bonusPoint;
}
class TV extends Product{}
class Computer extends Product{}
class Audio extends Product{}
class Buyer{
int money = 100;
int bonusPoint = 0;
}

//오버로딩
void buy(TV t){
money = money – t.price;
bonusPoint = bonusPoint + t.bonusPoint;
}
void buy(Computer t){//오버로딩1
money = money – t.price;
bonusPoint = bonusPoint + t.bonusPoint;
}

void buy(Audio t){ //오버로딩2
money = money – t.price;
bonusPoint = bonusPoint + t.bonusPoint;
}

//위의 3개의 함수를 하나의 함수로 
void buy(Product t){
money = money – t.price;
bonusPoint = bonusPoint + t.bonusPoint;
}
```

### 오버라이딩의 목적 다형성 실현 

-  오버라이딩으로 다형성 실현
  - 하나의 인터페이스(같은 이름)에 서로 다른 구현 
  - 슈퍼 클래스의 메소드를 서브 클래스에서 각각 목적에 맞게 다르게 구현 
  - 사례 
    - Shape의 draw() 메소드를 Line, Rect, Circle에서 오버라이딩하여 다르게 구현  