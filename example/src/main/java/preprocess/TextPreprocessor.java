package preprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import resource.ResourcesUtils;

public class TextPreprocessor{

	public File splitSentences(File file) throws IOException {
		// TODO Auto-generated method stub
		
			BufferedReader br = new BufferedReader(new FileReader(file));
			File res = new File(ResourcesUtils.resourcePath +"/"  + file.getName()+ "_Splited");
			FileWriter fw = new FileWriter(res);
			// String delimeters = PreprocessHelper.delimeters();
			String[] splited;

			String remain = "";
			int length = 0;
			String read = "";
			while ((read = br.readLine()) != null) {
				//System.out.println("iter" + read);
				splited = read.split("[.]", 0);
				splited[0] = remain + splited[0];
				// Chia = dáº¥u .(Cáº£i tiáº¿n vá»� sau...)
				if (!splited[splited.length - 1].endsWith(".")) {
					remain = splited[splited.length - 1];
					length = splited.length - 1;
				} else {
					remain = "";
					length = splited.length;
				}
				for (int j = 0; j < length; j++) {
					// System.out.println("Phan tu " + j +":" + splited[j]);
					fw.write(splited[j] + "\n");
					fw.flush();
				}
			}
			br.close();
			fw.close();
			return res;
		}
		
	public File removeNoise(File file) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(file));
		File res = new File(ResourcesUtils.resourcePath +"/"  + file.getName()+ "_removed");
		PrintWriter pw = new PrintWriter(res);			
		String read = "";
		while ((read = br.readLine()) != null) {
				read = PreprocessHelper.removeSymbol(read);
				read = PreprocessHelper.removeHTML(read);
				read.toLowerCase();
				pw.println(read);
				pw.flush();
		}
		pw.close();
		br.close();
		return res;
	}

	public void removeStopWord(File file) {
		// TODO Auto-generated method stub
		
	}
	

}
