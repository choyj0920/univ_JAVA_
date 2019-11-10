package java_1106;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class Wordtest {
	static Random r=new Random();
	static Scanner sc = new Scanner(System.in);
	protected static Word[] words;
	
	public static void fileopen() throws FileNotFoundException {
		File file= new File("test.txt");
		Scanner scans= new Scanner(file);
		int i=0;
		words=new Word[10];
		while(scans.hasNextLine()) {
			String str=scans.nextLine();
			String[] strs= str.split(":");
			String eng=strs[0].trim();
			String[] mean=(strs[1].trim()).split("/");
			words[i]= new Word(eng, mean);
			i++;
		}
		scans.close();
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		fileopen();
		int num;
	    System.out.println("5조 송재원 조윤직 김영준 안정근 입니다.");
	    for(int i=0; i<10;i++) {
	    	System.out.print(words[i].getWord_e());
	    	for(int j =0 ;j<words[i].getMean().length ;j++) {
	    		System.out.print(words[i].getMean()[j]);
	    	}
	    	System.out.println();
	    }
	    while (true) {
	    	System.out.println("1) 주관식  2) 객관식  3) 종료");
	         num = sc.nextInt();
	         sc.nextLine();
	         if (num == 1) {
	        	 Subjective();
	         }else if( num == 2) {
	        	 ObjectiveCorrect();
	         }else if (num == 3) {
	            System.out.println("종료합니다.");
	            break;
	         }else {
	            System.out.println("다시 입력해 주세요");
	         }
	         continue;
	      }
		
	}
	public static void ObjectiveCorrect() {
	      
		int w=0;
	      for(int j=0;j<5;j++) {
	         int num = r.nextInt(10);
	         Word[] testWord = new Word[5];
	         testWord[0] = words[num];
	         Word correctWord = words[num];
	         boolean[] useWord = new boolean[10];
	         useWord[num]=true;
	         for (int i=1;i<testWord.length;i++) {
	            int rand = r.nextInt(10);
	            if(useWord[rand]) {
	               i--;
	               continue;
	            }else {
	               testWord[i]=words[rand];
	               useWord[rand]=true;
	            }
	         }
	         for(int i=0;i<100;i++) {
	            Word tempWord;
	            int[] mixNum = {r.nextInt(4),r.nextInt(4)};

	            if(mixNum[0]==mixNum[1]) {
	               i--;
	               continue;
	            }else {
	               tempWord=testWord[mixNum[0]];
	               testWord[mixNum[0]]=testWord[mixNum[1]];
	               testWord[mixNum[1]]=tempWord;
	            }
	         }

	         System.out.println("*객관식 문제*");
	         System.out.println();
	         System.out.println("["+correctWord.getWord_e()+"]");
	         for(int i=0;i<testWord.length;i++) {
	            System.out.print("- "+(i+1)+"번 : ");
	            for(int k=0;k<testWord[i].getMean().length;k++) {
	            	System.out.print(testWord[i].checkMean(k)+" ");
	            }
	            System.out.println();
	         }
	         System.out.print("-단어뜻 : ");
	         int userNum;
	         while(true) {
	            userNum = sc.nextInt();
	            if(userNum<1||userNum>5) {
	               System.out.println("1~5번까지의 보기중에서 선택해주세요.");
	               continue;
	            }else {
	               break;
	            }
	         }
	         userNum-=1;
	         boolean check=true;
	         for(int i=0;i<testWord[userNum].getMean().length&&i<correctWord.getMean().length;i++) {
	            if(testWord[userNum].checkMean(i).equals(correctWord.checkMean(i))) {
	               System.out.println("정답입니다.");
	               w+=1;
	               check=false;
	            }
	         }
	         if(check) {
	            System.out.println("오답입니다.");
	         }

	      }
	      System.out.println("맞은갯수 : "+w+"/5");
	      
	   }
	public static void Subjective(){
			int w=0;
		   for(int j=0;j<5;j++) {
			   int num = r.nextInt(10);
			      System.out.println(words[num].getWord_e());
			      System.out.println("뜻을 입력하시요 : ");
			      
			      String str = sc.nextLine();
			      str=str.trim();
			      if(words[num].correct(str)) {
			    	  System.out.println("정답입니다.");
			    	  w+=1;
			      }
			      else
			    	  System.out.println("정답이 아닙니다.");
			      
		   }
		   System.out.println("맞은갯수 : "+w+"/5");
		}
}
