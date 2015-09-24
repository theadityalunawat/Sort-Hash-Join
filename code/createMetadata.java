import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class createMetadata {

	public static void main(String[] args) {

		String filename = args[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String str = br.readLine();
			int x = str.indexOf(' ');
			int y = str.length()-x-1;
			System.out.println("col0,"+x);
			System.out.print("col1,"+y);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
