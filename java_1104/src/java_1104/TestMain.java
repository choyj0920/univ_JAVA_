package java_1104;

public class TestMain {
	
	public static byte[] XOR(byte[] data, byte[] key) {
		int dlength =data.length;
		int klength =key.length;
		byte[] converted = new byte[dlength];
		for(int i=0,j=0;i<dlength;i++,j++) {
			converted[i]= (byte)(data[i]^key[j]);
			if(j>=(klength-1)) {
				j=0;
			}
		}
		return converted;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("201810754 조윤직");
		String passwd="우리나라만세";
		String key="abcdefghijkl";
		
		byte[] converted =XOR(passwd.getBytes(),key.getBytes());
		System.out.println(converted);
		
		converted =XOR(converted,key.getBytes());
		System.out.println(new String(converted));
	}

}
