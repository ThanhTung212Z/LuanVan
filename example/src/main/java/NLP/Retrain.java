package NLP;

import java.io.File;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.paragraphvectors.ParagraphVectors;
import org.deeplearning4j.text.documentiterator.LabelsSource;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

public class Retrain {
	
	@SuppressWarnings("deprecation")
	public static ParagraphVectors retrainData(File newFile) throws Exception {
	    File file = new File("newFile");
	    SentenceIterator iter = new BasicLineIterator(file);
	    
	    TokenizerFactory tFact = new DefaultTokenizerFactory();
	    tFact.setTokenPreProcessor(new CommonPreprocessor());

	    LabelsSource labelFormat = new LabelsSource("LINE_");
	    
	    ParagraphVectors existsVec = WordVectorSerializer.readParagraphVectors("D://docsVector.txt");
	    ParagraphVectors vec = new ParagraphVectors.Builder()
	            .useExistingWordVectors(existsVec).build();
	    vec.fit();
	  
	  
	    WordVectorSerializer.writeWordVectors(vec, new File("D://docsVector.txt"));
	    return vec;
	}

}
