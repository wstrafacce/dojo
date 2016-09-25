package br.com.cubotecnologia.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class FileUtils {
	
	public static BufferedReader getLoadFile (String sPath) throws FileNotFoundException {
		return new BufferedReader(new FileReader(sPath));
	}
	
	public static BufferedWriter create (String sPath) throws IOException{
		File logFile = new File(sPath);
		return new BufferedWriter(new FileWriter(logFile));
	}
	
	public static List<String> getLines(String sPath) throws IOException{
		BufferedReader bfFile = getLoadFile(sPath);
		List<String> lLines = new ArrayList<String>();
		String sLine = StringUtils.EMPTY;
		
		while((sLine = bfFile.readLine()) != null) {
			lLines.add(sLine);
		}
		
		return lLines;
	}
	
	public static List<String> getLines(File fFile) throws IOException{
		BufferedReader bfFile = getLoadFile(fFile.getCanonicalPath());
		List<String> lLines = new ArrayList<String>();
		String sLine = StringUtils.EMPTY;
		
		while((sLine = bfFile.readLine()) != null) {
			lLines.add(sLine);
		}
		
		return lLines;
	}
	
	public static List<String> getLines(BufferedReader bfFile) throws IOException{
		List<String> lLines = new ArrayList<String>();
		String sLine = StringUtils.EMPTY;
		
		while((sLine = bfFile.readLine()) != null) {
			lLines.add(sLine);
		}
		
		return lLines;
	}
}
