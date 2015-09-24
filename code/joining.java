import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class joining {

	public static void main(String[] args) {

		int M =Integer.parseInt(args[0]);
		BufferedReader fileBr = null;
		HashMap<String , ArrayList<String>> hm= new HashMap<>();
		String str,strp,strs;
		int p,g;
		for(p =0;p<M;p++){
			BufferedReader br5 = null;
			try {
				br5 = new BufferedReader(new FileReader("P/"+p+".txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				while((str=br5.readLine())!=null){
				//for x and y
					strs = str.substring(str.indexOf(" ")+1,str.length());
					strp = str.substring(0,str.indexOf(" "));
					if(hm.containsKey(strs)){
						hm.get(strs).add(strp);
					}
					else{
						ArrayList<String> temp = new ArrayList<>();
						temp.add(strp);
						hm.put(strs,temp);
					}
				}
				if(hm.size()!=0){
				BufferedReader br6 = new BufferedReader(new FileReader("S/" + p +".txt"));
					while((str=br6.readLine())!=null){
						String temp = str.substring(0, str.indexOf(" "));
						if(hm.containsKey(temp)){
							for(g=0; g<hm.get(temp).size();g++){
								System.out.println(hm.get(temp).get(g) +" " +str);
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			hm.clear();

		}


	}

}

