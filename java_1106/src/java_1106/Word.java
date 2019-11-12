package java_1106;

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
		
	}