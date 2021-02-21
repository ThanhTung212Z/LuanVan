package preprocess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class DocFilePreProcessor {

	public void extractText(File docFile, File textFile) {
		
	}
	public void removePicture(File f) throws FileNotFoundException, IOException {
		XWPFDocument document = new XWPFDocument(new FileInputStream(f));
		for (XWPFParagraph par : (document).getParagraphs()) {
		    int pos = 0;
		    while (pos < par.getRuns().size()) {
		        XWPFRun run = par.getRuns().get(pos);
		        if (run.getEmbeddedPictures().size() > 0) {
		            par.removeRun(pos);
		        } else {
		            pos++;
		        }
		    }
		}
	}
	public void removeFooterAndHeader(File f) {
		
	}

}
