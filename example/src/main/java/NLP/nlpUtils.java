package NLP;

import java.io.File;
import java.io.IOException;

public class nlpUtils {
	public static double similarity(String text1, String text2) {
		return ModelUtils.compare2text(text1, text2);
	}
	public static void retrain(File newFile) throws Exception {
		ModelUtils.retrain(newFile);
	}
	public static void main(String[] args) throws IOException {
		ModelUtils.init();
		similarity("an year", "about twitter");
	}

}
