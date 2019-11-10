package java_1106;

import java.util.*;

public class Objective extends Wordtest {
   static Random r = new Random();
   static Scanner sc = new Scanner(System.in);
   public Objective() {
      // TODO Auto-generated constructor stub
   }
   
   public static void ObjectiveCorrect() {
      
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

         System.out.println("*������ ����*");
         System.out.println();
         System.out.println("["+correctWord.getWord_e()+"]");
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

         boolean check=true;
         for(int i=0;i<testWord[userNum].getMean().length&&i<correctWord.getMean().length;i++) {
            if(testWord[userNum].checkMean(i).equals(correctWord.checkMean(i))) {
               System.out.println("�����Դϴ�.");
               check=false;
            }
         }
         if(check) {
            System.out.println("�����Դϴ�.");
         }

      }
      
      
   }
   
}