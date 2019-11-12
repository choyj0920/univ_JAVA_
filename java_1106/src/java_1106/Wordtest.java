package java_1106;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Wordtest {
   static Random r=new Random();
   static Scanner sc = new Scanner(System.in);
   protected static ArrayList<Word> words;
   
   public static void fileopen() throws FileNotFoundException {
      File file= new File("words.txt");
      Scanner scans= new Scanner(file);
      words=new ArrayList<Word>();
      while(scans.hasNextLine()) {
         String eng = scans.nextLine().trim();
         String[] mean=(scans.nextLine().trim()).split("/");
         for(int i=0;i<mean.length;i++) {
            mean[i]=mean[i].trim();
         }
         words.add(new Word(eng, mean));

      }
      scans.close();
      
   }

   public static void main(String[] args) throws FileNotFoundException {
      // TODO Auto-generated method stub
      fileopen();
      int num;
       System.out.println("5�� ����� ������ �迵�� ������ �Դϴ�.");
       System.out.println(words.size());

       while (true) {
          System.out.println("1) �ְ���  2) ������  3) ����");
            num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
               Subjective();
            }else if( num == 2) {
               ObjectiveCorrect();
            }else if (num == 3) {
               System.out.println("�����մϴ�.");
               break;
            }else {
               System.out.println("�ٽ� �Է��� �ּ���");
            }
            continue;
         }
      
   }
   public static void ObjectiveCorrect() {
         
      int w=0;
         for(int j=0;j<5;j++) {
            int num = r.nextInt(words.size());
            Word[] testWord = new Word[5];
            testWord[0] = words.get(num);
            Word correctWord = words.get(num);
            boolean[] useWord = new boolean[words.size()];
            useWord[num]=true;
            for (int i=1;i<testWord.length;i++) {
               int rand = r.nextInt(words.size());
               if(useWord[rand]) {
                  i--;
                  continue;
               }else {
                  testWord[i]=words.get(rand);
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

            System.out.println();
            System.out.println("*������ ����*");
            System.out.println((j+1)+"�� :["+correctWord.getWord_e()+"]");
            for(int i=0;i<testWord.length;i++) {
               System.out.print("- "+(i+1)+"�� : ");
               for(int k=0;k<testWord[i].getMean().length;k++) {
                  System.out.print(testWord[i].checkMean(k)+" ");
               }
               System.out.println();
            }
            System.out.print("-�ܾ�� : ");
            int userNum;
            while(true) {
               userNum = sc.nextInt();
               if(userNum<1||userNum>5) {
                  System.out.println("1~5�������� �����߿��� �������ּ���.");
                  continue;
               }else {
                  break;
               }
            }
            userNum-=1;
            boolean check=true;
            for(int i=0;i<testWord[userNum].getMean().length&&i<correctWord.getMean().length;i++) {
               if(testWord[userNum].checkMean(i).equals(correctWord.checkMean(i))) {
                  System.out.println("�����Դϴ�.");
                  w+=1;
                  check=false;
                  break;
               }
            }
            if(check) {
               System.out.println("�����Դϴ�.");
            }

         }
         System.out.println("�������� : "+w+"/5");
         
      }
   public static void Subjective() {
	      int w = 0;
	      int num[] = { 0, 0, 0, 0, 0 }; 
	      int checknum;
	      for (int i = 0; i < 5; i++) {
	         num[i] = r.nextInt(words.size());
	         for (int j = 0; j < i; j++) {
	            if (num[i] == num[j]) {
	               i--;
	               break;
	            }
	         }
	      }
	      for (int j = 0; j < 5; j++) {
	         checknum = num[j];
	         System.out.println(words.get(checknum).getWord_e());
	         System.out.println("���� �Է��Ͻÿ� : ");

	         String str = sc.nextLine();
	         str = str.trim();
	         if (words.get(checknum).correct(str)) {
	            System.out.println("�����Դϴ�.");
	            w += 1;
	         } else
	            System.out.println("������ �ƴմϴ�.");

	      }
	      System.out.println("�������� : " + w + "/5");
	   }
}