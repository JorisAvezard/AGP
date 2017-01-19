package lucene;

import java.io.File;
import java.io.FileFilter;

/**
 * 
 * This class is used to treat only .txt files in the directory
 *
 */
public class TextFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().toLowerCase().endsWith(".txt");
	}
}