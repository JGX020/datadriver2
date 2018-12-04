package org.microsoft.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException 
    {
    	datacontroll text=new test();
    	File textf=new File("E://11111//1111.xls");
    	for(int i=1;i<=10;i++)
    	text.readExcel(textf, i, "name");
    //	private static Connection getConn() {
    	//  datacontroll data=new test();
    	 // data.readsql("select * from scanner_server");
    	    
    	 //   return conn;
    	
    	/*JsonObject object = new JsonObject();
       // object.addProperty("cat", "it");
         
        JsonArray array = new JsonArray();
        File file = new File("access.log");
        String str=null;
   //     conn = DriverManager.getConnection("jdbc:oracle:thin:@119.29.153.37:1521:dbsrv2", "system", "oracledba");  
        InputStreamReader opw = new InputStreamReader(new FileInputStream(file), "GBK");
        BufferedReader bufr = new BufferedReader(opw);
        while ((str = bufr.readLine()) != null) {  
       //	 if(str.split(" ")[8].equals("200")){
       //		 text.createFile("data.properties");
        	JsonObject lan1 = new JsonObject();
            lan1.addProperty("ip", str.split(" ")[0]);
            lan1.addProperty("time", str.split(" ")[3].substring(1, str.split(" ")[3].length()));
            lan1.addProperty("method", str.split(" ")[5].substring(1, str.split(" ")[5].length()) );
            lan1.addProperty("status", str.split(" ")[8]);
            lan1.addProperty("url", str.split(" ")[6]);
            lan1.addProperty("size",str.split(" ")[9] );
            array.add(lan1);
       	//	 System.out.println(str.split(" ")[5]);
       	//	 text.writeProperty("data.properties", "ip"+i,str.split(" ")[0]);
       	//	 text.writeProperty("data.properties", "method"+i,str.split(" ")[5].substring(1, str.split(" ")[5].length()) );
       	//	 text.writeProperty("data.properties", "status"+i,str.split(" ")[8]);
      // 		 i++;
     	 //}
            System.out.println(str);  
        }  
     /*   JsonObject lan1 = new JsonObject();
        lan1.addProperty("id", 1);
        lan1.addProperty("name", "java");
        lan1.addProperty("ide", "Eclipse");
        array.add(lan1);
         
        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id", 2);
        lan2.addProperty("name", "Swift");
        lan2.addProperty("ide", "Xcode");
        array.add(lan2);
         
        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id", 3);
        lan3.addProperty("name", "C#");
        lan3.addProperty("ide", "Visual Studio");
        array.add(lan3);*/
         
    /*    object.add("data", array);
        
  //      object.addProperty("pop", true);
         
        /*System.out.print(object.toString());
        FileWriter fw = new FileWriter(new File("create.json"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(object.toString());
        bw.flush();*/
  /*      datacontroll test=new test();
        test.createJsonfile("creat12233.json", object.toString());
      //  System.out.println( "Hello World!" );
    /*	datacontroll test=new test();
    	 //ReadExcel obj = new ReadExcel();
         // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
         File file = new File("E:/test (2).txt");
       //  String excel = test.readExcel(file,5,"主机名");
        // System.out.println(excel);
         String str=null;
         String key="key";
         int i=0;
         datacontroll text=new test();
         InputStreamReader opw = new InputStreamReader(new FileInputStream(file), "GBK");
         BufferedReader bufr = new BufferedReader(opw);
         while ((str = bufr.readLine()) != null) {  
        	 if(text.isboolIp(str.split(" ")[0])){
        		 text.createFile("data.properties");
        		 System.out.println(str.split(" ")[5]);
        		 text.writeProperty("data.properties", "ip"+i,str.split(" ")[0]);
        		 text.writeProperty("data.properties", "method"+i,str.split(" ")[5].substring(1, str.split(" ")[5].length()) );
        		 text.writeProperty("data.properties", "status"+i,str.split(" ")[8]);
        		 i++;
        	 }
         //    System.out.println(str);  
         }  
      /*  System.out.println("list中的数据打印出来");
         for (int i = 0; i < excelList.size(); i++) {
             List list = (List) excelList.get(i);
             for (int j = 0; j < list.size(); j++) {
                 System.out.print(list.get(j));
             }
             System.out.println();
         }*/
     //   text.r*/
        
    }
}
