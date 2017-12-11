import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputFile {
	
	public BufferedReader r = null;
	public String s;
	public String[] sArray;
	public HashMap<String, String> map = new HashMap<String, String>();
	
	public InputFile(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt","txt");
		chooser.setFileFilter(filter);
		chooser.getSelectedFile();
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION){
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다");
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		
		try{
			r = new BufferedReader(new FileReader(filePath));
			
			while((s = r.readLine()) != null){
				sArray = s.split(" ");
				map.put(sArray[0], sArray[1]);
			}
			
			//Set<String> keylist = map.keySet();
			//Iterator<String> itr = keylist.iterator();
			
			/*while(itr.hasNext()){
				String word = itr.next();
				System.out.println(word + "\t" + map.get(word));
			}*/
			r.close();
		}
		catch(IOException ie){
			System.err.println("파일 오류!");
		}
		
	}
}
