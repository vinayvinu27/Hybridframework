package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readingdata { //supporting file
		
		
		Properties pro;
		public Readingdata() {
			File file=new File("./Configuration/Config.properties");
			
			try {
				FileInputStream fis=new FileInputStream(file);
				
				pro=new Properties();
				pro.load(fis);//loading the properties file
			} catch(Exception e) {
				System.out.println("exception is : "+ e.getMessage());
			}
			
		}
		
		public String getapplicationURL() {
			
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		public String getUsername() {
			String username=pro.getProperty("username");
			return username;
		}
		
		public String getPassword() {
			String password=pro.getProperty("password");
			return password;
		}
		public String getchromepath() {
			String cpath=pro.getProperty("cpath");
			return cpath;
		}
		public String getfirefoxpath() {
			String fpath=pro.getProperty("fpath");
			return fpath;
		}
		
		public String getEdgePath() {
			String epath=pro.getProperty("epath");
			return epath;
		}
	}