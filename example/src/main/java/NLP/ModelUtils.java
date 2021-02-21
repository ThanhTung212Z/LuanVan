package NLP;

import java.io.File;
import java.io.IOException;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.paragraphvectors.ParagraphVectors;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public class ModelUtils {
	public static ParagraphVectors vec;
	public static String modelFile = "D://wordsVector.txt";

	public static ParagraphVectors getVec() {
		return vec;
	}

	public static void setVec(ParagraphVectors vec) {
		ModelUtils.vec = vec;
	}
	public static void retrain(File newFile) throws Exception {
		setVec(Retrain.retrainData(newFile));
	}
	public static void init() throws IOException {
		vec = WordVectorSerializer.readParagraphVectors("D://docsVector.txt");
	}
	public static double compare2text(String text1, String text2) {
		String[] text1Sep = text1.split(" ");
		String[] text2Sep = text2.split(" ");
		
		INDArray arr1Res = vec.getLookupTable().vector(text1Sep[0]);
		INDArray arr2Res = vec.getLookupTable().vector(text2Sep[0]);
		for (int i = 1; i < text1Sep.length; i++) {
			INDArray ind1 = vec.getLookupTable().vector(text1Sep[i]);
			arr1Res.add(ind1);
		}
		for (int i = 1; i < text2Sep.length; i++) {
			INDArray ind2 = vec.getLookupTable().vector(text2Sep[i]);
			arr2Res.add(ind2);
		}
		double cosineSim = Transforms.cosineSim(arr1Res, arr2Res);
		return cosineSim;
		
	}
	
	

}
