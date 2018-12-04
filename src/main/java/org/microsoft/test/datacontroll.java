package org.microsoft.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface datacontroll {
	/**
	 * 测试
	  **/
  public void inputFile(String paramFile) throws Exception;
  public void createFile(String paramFile) throws IOException;
  public void writeProperty(String properiesName,String key, String value);
  public String readProperty(String paramFile,String key) throws FileNotFoundException, IOException;
  public void creatdir(String paramdir);
  public void copyFileUsingFileChannels(File source, File dest) throws IOException;
  public String readExcel(File file,int index2,String key);
  public  boolean isboolIp(String ipAddress);
  public String createJsonfile(String paramFile, String content) throws IOException;
  public void readsql(String stm);
}
