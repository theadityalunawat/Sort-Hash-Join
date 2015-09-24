import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class sortAndJoinVersion2 {

	public static void main(String[] args) {

		File f1= new File("outputTemp11.txt");
		File f2 = new File("outputTemp22.txt");
		String prevVal;
		int i,j;
		int startIndex,endIndex;
		ArrayList<String> contain1 = new ArrayList<>();
		ArrayList<String> contain2 = new ArrayList<>();
		String compare1,compare2;
		String currentRow1,currentRow2;
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(f1));
			BufferedReader br2 = new BufferedReader(new FileReader(f2));
			currentRow1 = br1.readLine();
			currentRow2 = br2.readLine();
			startIndex = currentRow1.indexOf(' ')+1;
			int end= currentRow2.indexOf(' ');
			endIndex =  currentRow1.length();
			compare1 = currentRow1.substring(startIndex,endIndex);
			compare2 = currentRow2.substring(0,end);
			while(true){
				if(currentRow1 == null || currentRow2 == null)
					break;
				if(compare1.compareTo(compare2) == 0){
					contain1.add(currentRow1);
					prevVal = compare1;
					while(compare1.compareTo(compare2) == 0){
						contain2.add(currentRow2);
						currentRow2 = br2.readLine();
						if(currentRow2 != null)
							compare2 = currentRow2.substring(0,end);
						else
							break;
					}
					currentRow1 = br1.readLine();
					if(currentRow1 != null)
						compare1 = currentRow1.substring(startIndex,endIndex);
					else
						break;
					if(compare1.compareTo(prevVal) == 0){
						while(compare1.compareTo(prevVal) == 0){
							contain1.add(currentRow1);
							currentRow1 = br1.readLine();
							if(currentRow1 != null)
								compare1 = currentRow1.substring(startIndex,endIndex);
							else
								break;
						}
					}
					if(contain1.size() > 0 && contain2.size() > 0){
						for(i=0;i<contain1.size();i++){
							for(j=0;j<contain2.size();j++){
								System.out.println(contain1.get(i)+" "+contain2.get(j).substring(end+1,contain2.get(j).length()));
							}
						}
					}
					contain1.clear();contain2.clear();
				}
				else if(compare1.compareTo(compare2) < 0){
					currentRow1 = br1.readLine();
					if(currentRow1 != null)
						compare1 = currentRow1.substring(startIndex,endIndex);
				}
				else if(compare1.compareTo(compare2) > 0){
					currentRow2 = br2.readLine();
					if(currentRow1 != null)
						compare2 = currentRow2.substring(0,end);
				}
			}
			if(contain1.size() > 0 && contain2.size() > 0){
				for(i=0;i<contain1.size();i++){
					for(j=0;j<contain2.size();j++){
						System.out.println(contain1.get(i)+" "+contain2.get(j).substring(startIndex,endIndex));
					}
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

