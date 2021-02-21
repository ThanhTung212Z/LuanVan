package preprocess;

import java.io.File;
import java.io.IOException;

import resource.ResourcesUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File raw_file = new File(ResourcesUtils.resourcePath + "/raw_text");
		System.out.println(raw_file.getAbsolutePath());
		
		TextPreprocessor txtpr = new TextPreprocessor();
		
		try {
			txtpr.splitSentences(txtpr.removeNoise(raw_file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
