package java_1106;


public class Word{
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
		
	}