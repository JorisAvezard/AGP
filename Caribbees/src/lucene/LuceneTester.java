package lucene;

import java.io.IOException;
import org.apache.lucene.queryParser.ParseException;

/**
 * 
 * This class is used to test Lucene
 *
 */
public class LuceneTester {

	public static void main(String[] args) {
		LuceneUtility tester;
		try {
			tester = new LuceneUtility();
			tester.createIndex();
			tester.search("nuage blabla");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}