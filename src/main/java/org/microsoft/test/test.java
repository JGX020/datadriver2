package org.microsoft.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class test implements datacontroll {

	 public void inputFile(String paramFile) throws Exception
	    {
	        Properties props=new Properties();//使用Properties类来加载属性文件
	        FileInputStream iFile = new FileInputStream(paramFile);
	        props.load(iFile);

	        /**begin*******直接遍历文件key值获取*******begin*/
	        Iterator<String> iterator = props.stringPropertyNames().iterator();
	        while (iterator.hasNext()){
	            String key = iterator.next();
	            System.out.println(key+":"+props.getProperty(key));
	        }
	        /**end*******直接遍历文件key值获取*******end*/

	        /**begin*******在知道Key值的情况下，直接getProperty即可获取*******begin*/
	        props.setProperty("pp", "123nmp");
	        String user=props.getProperty("user");
	        String pass=props.getProperty("pp");
	        String text=props.getProperty("data");
	        
	        System.out.println("\n"+user+"\n"+pass+"\n"+text);
	        /**end*******在知道Key值的情况下，直接getProperty即可获取*******end*/
	        iFile.close();

	    }

	public void createFile(String paramFile) throws IOException {
		// TODO Auto-generated method stub
		File file=new File(paramFile);
    	if(!file.exists()){
    	file.createNewFile();
    	}
		
	}

	public void writeProperty(String properiesName, String key, String value) {
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try {
            is = new FileInputStream(properiesName);
//            is = PropertiesUtil.class.getClassLoader().getResourceAsStream(properiesName);
            p.load(is);
//            os = new FileOutputStream(PropertiesUtil.class.getClassLoader().getResource(properiesName).getFile());
            os = new FileOutputStream(properiesName);

            p.setProperty(key, value);
            p.store(os, key);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
                if (null != os)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
	/**
     * read properties file
     * @param paramFile file path
	 * @throws IOException 
	 * @throws FileNotFoundException 
     * @throws Exception
     */

	public String readProperty(String paramFile, String key) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		 Properties pps = new Properties();
		          pps.load(new FileInputStream(paramFile));
		          Enumeration enum1 = pps.propertyNames();//得到配置文件的名字
		         // while(enum1.hasMoreElements()) {
		          //    String strKey = (String) enum1.nextElement();
		              String strValue = pps.getProperty(key);
		            //  System.out.println(strKey + "=" + strValue);
		         //}
		              return strValue;
	}

	public void creatdir(String paramdir) {
		// TODO Auto-generated method stub
		File file=new File(paramdir);

		Boolean aa=file.mkdir();
	}
	public void copyFileUsingFileChannels(File source, File dest) throws IOException {    
        FileChannel inputChannel = null;    
        FileChannel outputChannel = null; 
        FileChannel outputChannel2=null;
        creatdir("temp");
    try {
        inputChannel = new FileInputStream(source).getChannel();
        outputChannel = new FileOutputStream(dest).getChannel();
        outputChannel2=new FileOutputStream("temp/"+dest).getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        outputChannel2.transferFrom(inputChannel, 0, inputChannel.size());
    } finally {
        inputChannel.close();
        outputChannel2.close();
        outputChannel.close();
    }
}
	 public String readExcel(File file,int index2,String key) {
	        try {
	        	String result="";
	            // 创建输入流，读取Excel
	            InputStream is = new FileInputStream(file.getAbsolutePath());
	            // jxl提供的Workbook类
	            Workbook wb = Workbook.getWorkbook(is);
	            String textinfo="{";
	            // Excel的页签数量
	            int sheet_size = wb.getNumberOfSheets();
	            for (int index = 0; index < sheet_size; index++) {
	                List<List> outerList=new ArrayList<List>();
	                // 每个页签创建一个Sheet对象
	                Sheet sheet = wb.getSheet(index);
	                // sheet.getRows()返回该页的总行数
	                for (int i = 0; i < 1; i++) {
	                    List innerList=new ArrayList();
	                    // sheet.getColumns()返回该页的总列数
	                    for (int j = 0; j < sheet.getColumns(); j++) {
	                        String cellinfo = sheet.getCell(j, i).getContents();
	                        if(cellinfo.isEmpty()){
	                            continue;
	                        }
	                        innerList.add(cellinfo);
	                        
	                     //   System.out.print(cellinfo);
	                        if(i==0){
	                        	if(j!=sheet.getColumns()-1){
	                        	textinfo+="\""+cellinfo+"\":\""+sheet.getCell(j,index2).getContents()+"\",";
	                        	}else{
	                        		textinfo+="\""+cellinfo+"\":\"\"";
	                        	}
	                        }
	                        
	                    }
	                    outerList.add(i, innerList);
	                    textinfo+="}";
	                    System.out.println(textinfo);
	                    JSONObject jsonObject = JSONObject.parseObject(textinfo);
	                    System.out.println(jsonObject.getString(key));
	                    result=jsonObject.getString(key);
	                }
	                return result;
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public  boolean isboolIp(String ipAddress) {  
	        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";   
	        Pattern pattern = Pattern.compile(ip);  
	        Matcher matcher = pattern.matcher(ipAddress);  
	        return matcher.matches();  
	    }

	public String createJsonfile(String paramFile, String content) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(new File(paramFile));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.flush();
		return null;
	}

	public void readsql(String stm) {
		// TODO Auto-generated method stub
		  String driver = "com.mysql.jdbc.Driver";
  	    String url = "jdbc:mysql://192.168.31.237:3307/test";
  	    String username = "root";
  	    String password = "123456";
  	    Connection conn = null;
  	    try {
  	        Class.forName(driver); //classLoader,加载对应驱动
  	        conn = (Connection) DriverManager.getConnection(url, username, password);
  	    } catch (ClassNotFoundException e) {
  	        e.printStackTrace();
  	    } catch (SQLException e) {
  	        e.printStackTrace();
  	    }
  	    String sql = stm;
  	    PreparedStatement pstmt;
  	    try {
  	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
  	        ResultSet rs = pstmt.executeQuery();
  	        int col = rs.getMetaData().getColumnCount();
  	        System.out.println("============================");
  	        while (rs.next()) {
  	            for (int i = 1; i <= col; i++) {
  	                System.out.print(rs.getString(i) + "\t");
  	                if ((i == 2) && (rs.getString(i).length() < 8)) {
  	                    System.out.print("\t");
  	                }
  	             }
  	            System.out.println("");
  	        }
  	            System.out.println("============================");
  	    } catch (SQLException e) {
  	        e.printStackTrace();
  	    }
	}

	

}
