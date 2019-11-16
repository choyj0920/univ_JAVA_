package java_1113;

import java.util.Arrays;
import java.util.Random;

public class Word{
		static Random rand =new Random();
		private String word_e;
		private String[] mean;
		public Word(String eng,String[] mean) {
			word_e=eng;
			this.mean=mean;
		}
		public Word(String string, String string2, String string3) {
			// TODO Auto-generated constructor stub
		}
		public String getWord_e() {
			return word_e;
		}
		public String[] getMean() {
			return mean;
		}
		public boolean correct(String dd) {
			for(int i=0;i<mean.length;i++) {
				if(mean[i].equals(dd))
					return true;
			}
			return false;
		}
		public String checkMean(int i) {
			return mean[i];
		}
		public String randMean() {
			return mean[rand.nextInt(mean.length)];
		}
		@Override
		public String toString() {
			return "Word [word_e=" + word_e + ", mean=" + Arrays.toString(mean) + "]";
		}
		@Override
		public int hashCode() {//Set으로 담을 경우- hashcode 영어로만
		// TODO Auto-generated method stub
		return word_e.hashCode();
		}
		@Override
		public boolean equals(Object obj) { //set으로 담을경우 - Word.equals는 영어만 비교
		// TODO Auto-generated method stub
			if(obj instanceof Word)
				return word_e.equals(((Word)obj).word_e);
		return false;
		}
	}