package com.lld;

interface FileParser {
	void parse();
}

class CSVParser implements FileParser{

	@Override
	public void parse() {
		System.out.println("parsed to csv");		
	}	
}

class JSONParser implements FileParser{

	@Override
	public void parse() {
		System.out.println("parsed to json");		
	}	
}

class XMLParser implements FileParser{

	@Override
	public void parse() {
		System.out.println("parsed to xml");		
	}	
}

abstract class FileParserFactory {
	//common logic
	 public void process() {

	        System.out.println("Validating file...");
	        FileParser parser = getParser();
	        parser.parse();
	        System.out.println("Processing completed.");
	    }
	
	 //factory to create different object
	abstract FileParser getParser();
	
}

class CSVFileParserFactory extends FileParserFactory{

	@Override
	public FileParser getParser() {
		return new CSVParser();
	}	
}

class JSONFileParserFactory extends FileParserFactory{

	@Override
	public FileParser getParser() {
		return new JSONParser();
	}	
}

class XMLFileParserFactory extends FileParserFactory{

	@Override
	public FileParser getParser() {
		return new XMLParser();
	}	
}

public class FileParserFactoryDesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CSV
//		JSON
//		XML
		FileParserFactory fp=new XMLFileParserFactory();
		fp.process();
		
		
	}

}
