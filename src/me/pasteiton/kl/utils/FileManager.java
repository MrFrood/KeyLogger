package me.pasteiton.kl.utils;

import java.util.List;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManager {

	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static Date date = new Date();
	public static String logLocation = System.getenv("APPDATA") + File.separator + "KeyLogger" + File.separator + "key-log-" + dateFormat.format(date) + ".txt";
	
	
	public void createLocation() {
		File file = new File(System.getenv("APPDATA") + File.separator + "KeyLogger");
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
	public void printContents(String data) {
		createLocation();
		try {
			File file = new File(logLocation);
			ArrayList<String> currentContents = new ArrayList<String>();
			if(file.exists()) {
				Scanner s = new Scanner(file);
				while(s.hasNext()) {
					currentContents.add(s.next());
				}
				s.close();
				
				PrintWriter pw = new PrintWriter(file, "UTF-8");
				for(int i = 0; i < currentContents.size(); i++) {
					pw.println(currentContents.get(i));
				}
				pw.println(data);
				pw.close();
			}else {
				PrintWriter pw = new PrintWriter(file, "UTF-8");
				for(int i = 0; i < currentContents.size(); i++) {
					pw.println(currentContents.get(i));
				}
				pw.println(data);
				pw.close();
			}
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public String[] readContents() {
		
		try {
			File file = new File(logLocation);
			if(file.exists()) {
				Scanner s = new Scanner(file);
				List<String> temps = new ArrayList<String>();
				String token1 = "";
				while(s.hasNext()) {
					token1 = s.next();
					temps.add(token1);
				}
				s.close();
				String[] array = temps.toArray(new String[0]);
				return array;
			}
		}catch(Exception e) { e.printStackTrace(); }
		
		return null;
	}
	
	
	
}
