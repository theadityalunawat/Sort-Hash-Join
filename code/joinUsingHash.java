
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class joinUsingHash {

	public static void main(String[] args) {
		File f1;
		
		if(args[0].equalsIgnoreCase("P"))
			f1= new File("outputTemp11.txt");
		else
			f1= new File("outputTemp22.txt");
		
		int M = Integer.parseInt(args[1]);
		ArrayList<FileWriter> fp = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f1));
			for(int i =0;i<M ;i++){
				File fl = new File(args[0]+"/"+i+".txt");
				fl.getParentFile().mkdirs();
				fp.add(new FileWriter(fl));
			}
			int fno;
			String temp,str;
			while( (str =br.readLine())!=null ){
				if(args[0].equalsIgnoreCase("P"))
				temp = str.substring(str.indexOf(" ")+1,str.length());
				else
				temp = str.substring(0,str.indexOf(" "));
				fno = (temp.hashCode()+13)%M;
				if(fno < 0)
					fno = fno*(-1);
				fp.get(fno).write(str+"\n");
			}
			for(int i =0;i<M ;i++){
				fp.get(i).close();
			}
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}

