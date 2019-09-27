package java_HW_2_201810754;
import java.io.IOException;

import java_HW_2_201810754.cards;
public class TestMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		cards cardpack = new cards();
		cardpack.creatcard();
		cardpack.gamestart();
		try {
			new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
