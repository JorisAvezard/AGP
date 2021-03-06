package lucene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

/**
 * Provides utility static methods for simulation.
 */
public class LuceneUtility {

	Indexer indexer;
	Searcher searcher;

	File f = null;
	List<List<String>> result = new ArrayList<List<String>>();

	public void createIndex() throws IOException {
		indexer = new Indexer(LuceneConstants.INDEX_DIRECTORY);
		int numIndexed;
		long startTime = System.currentTimeMillis();
		numIndexed = indexer.createIndex(LuceneConstants.FILES_DIRECTORY, new TextFileFilter());
		long endTime = System.currentTimeMillis();
		indexer.close();
		System.out.println(numIndexed + " File indexed, time taken: " + (endTime - startTime) + " ms");
	}

	public List<List<String>> search(String searchQuery) throws IOException, ParseException {
		searcher = new Searcher(LuceneConstants.INDEX_DIRECTORY);
		long startTime = System.currentTimeMillis();
		TopDocs hits = searcher.search(searchQuery);
		long endTime = System.currentTimeMillis();

		System.out.println(hits.totalHits + " documents found. Time :" + (endTime - startTime));
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			List<String> resultIdScore = new ArrayList<String>();
			Document doc = searcher.getDocument(scoreDoc);
			//System.out.println(scoreDoc.score);
			System.out.println("File: " + doc.get(LuceneConstants.FILE_PATH));

			f = new File(doc.get(LuceneConstants.FILE_PATH));

			String[] s = f.getName().split("\\.");
			resultIdScore.add(s[0]);
			resultIdScore.add(String.valueOf(scoreDoc.score));
			result.add(resultIdScore);
		}
		searcher.close();

		for (int i = 0; i < result.size(); i++)
			System.out.println("�l�ment � l'index " + i + " = " + result.get(i).get(0));

		return result;
	}
	
	
}
