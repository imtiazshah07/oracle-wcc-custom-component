package test.ae.msc;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import intradoc.common.FileUtils;

public class FileNameTest {
	public static void main(String ary[]){
		FileNameTest t = new FileNameTest();
		
		String rawFileName = "G:/test/000000Z4.1";
		String newFileName = t.getFileName(rawFileName);
		
		File rawFile = new File(rawFileName);
		File newFile = new File(rawFile.getParent(), newFileName);
		if(rawFile.renameTo(newFile)){
			System.out.println("SUCCESS");
		}
	}
	
	private String getFileName(String path){
		String fileName = new File(path).getName();
		if(FileUtils.getExtension(fileName).equalsIgnoreCase("1")){
			String newFileName = FilenameUtils.removeExtension(fileName)+".jpg";
			return newFileName;
		}
		return null;
	}
	
}
